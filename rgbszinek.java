import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Kepkezeles {
    private static int[][][] keppontok = new int[360][640][3];

    public static void main(String[] args) {
        beolvasKep();
        kiirKepontSzineket();
        szamolVilagosKepontokat();
        megkeresLegsotetebbPontokat();
    }

    private static void beolvasKep() {
        try {
            RandomAccessFile raf = new RandomAccessFile("kep.txt", "r");
            for (int sor = 0; sor < 360; sor++) {
                for (int oszlop = 0; oszlop < 640; oszlop++) {
                    for (int szin = 0; szin < 3; szin++) {
                        keppontok[sor][oszlop][szin] = Integer.parseInt(raf.readLine());
                    }
                }
            }
            raf.close();
        } catch (IOException e) {
            System.err.println("HIBA: " + e.getMessage());
        }
    }

    private static void kiirKepontSzineket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adja meg a sor számát (1-360):");
        int sorSzam = scanner.nextInt();
        System.out.println("Kérem adja meg az oszlop számát (1-640):");
        int oszlopSzam = scanner.nextInt();

        int[] szinek = keppontok[sorSzam - 1][oszlopSzam - 1];
        System.out.println("A képpont színe (R, G, B): " + szinek[0] + ", " + szinek[1] + ", " + szinek[2]);
    }

    private static void szamolVilagosKepontokat() {
        int vilagosPontok = 0;
        for (int sor = 0; sor < 360; sor++) {
            for (int oszlop = 0; oszlop < 640; oszlop++) {
                int sum = keppontok[sor][oszlop][0] + keppontok[sor][oszlop][1] + keppontok[sor][oszlop][2];
                if (sum > 600) {
                    vilagosPontok++;
                }
            }
        }
        System.out.println("A képen " + vilagosPontok + " világos képpont van.");
    }

    private static void megkeresLegsotetebbPontokat() {
        int minOsszeg = Integer.MAX_VALUE;
        ArrayList<int[]> legsotetebbPontok = new ArrayList<>();

        for (int sor = 0; sor < 360; sor++) {
            for (int oszlop = 0; oszlop < 640; oszlop++) {
                int sum = keppontok[sor][oszlop][0] + keppontok[sor][oszlop][1] + keppontok[sor][oszlop][2];
                if (sum < minOsszeg) {
                    minOsszeg = sum;
                    legsotetebbPontok.clear();
                    legsotetebbPontok.add(new int[]{keppontok[sor][oszlop][0], keppontok[sor][oszlop][1], keppontok[sor][oszlop][2]});
                } else if (sum == minOsszeg) {
                    legsotetebbPontok.add(new int[]{keppontok[sor][oszlop][0], keppontok[sor][oszlop][1], keppontok[sor][oszlop][2]});
                }
            }
        }

        System.out.println("A legkisebb összeg: " + minOsszeg);
        System.out.println("Legsötétebb pontok színei (R, G, B):");
        for (int[] pont : legsotetebbPontok) {
            System.out.println("RGB(" + pont[0] + ", " + pont[1] + ", " + pont[2] + ")");
        }
    }
}

