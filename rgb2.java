import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class KepFeldolgozas {
    public static void main(String[] args) {
        int szelesseg = 640;
        int magassag = 360;
        int[][][] kep = new int[magassag][szelesseg][3];

        try {
            RandomAccessFile fajl = new RandomAccessFile("kep.txt", "r");
            Scanner scanner = new Scanner(System.in);

            while (fajl.getFilePointer() < fajl.length()) {
                for (int i = 0; i < magassag; i++) {
                    for (int j = 0; j < szelesseg; j++) {
                        kep[i][j][0] = fajl.readInt();
                        kep[i][j][1] = fajl.readInt();
                        kep[i][j][2] = fajl.readInt();
                    }
                }
            }
            fajl.close();

            Scanner input = new Scanner(System.in);
            System.out.println("Adja meg a sor és oszlop számát (1-től indulva):");
            int sor = input.nextInt();
            int oszlop = input.nextInt();
            int[] pixel = kep[sor - 1][oszlop - 1];
            System.out.println("A(z) " + sor + ". sor és " + oszlop + ". oszlop RGB értéke: RGB(" + pixel[0] + ", " + pixel[1] + ", " + pixel[2] + ")");

            int vilagosPontok = 0;
            int minOsszeg = Integer.MAX_VALUE;

            for (int i = 0; i < magassag; i++) {
                for (int j = 0; j < szelesseg; j++) {
                    int osszeg = kep[i][j][0] + kep[i][j][1] + kep[i][j][2];
                    if (osszeg > 600) {
                        vilagosPontok++;
                    }
                    if (osszeg < minOsszeg) {
                        minOsszeg = osszeg;
                    }
                }
            }
            System.out.println("A képen összesen " + vilagosPontok + " világos képpont található.");
            System.out.println("A legkisebb összeg: " + minOsszeg);

            System.out.println("A legkisebb összegű pixelek színei:");
            for (int i = 0; i < magassag; i++) {
                for (int j = 0; j < szelesseg; j++) {
                    int osszeg = kep[i][j][0] + kep[i][j][1] + kep[i][j][2];
                    if (osszeg == minOsszeg) {
                        System.out.println("RGB(" + kep[i][j][0] + ", " + kep[i][j][1] + ", " + kep[i][j][2] + ")");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található.");
        } catch (IOException e) {
            System.out.println("Hibaa az olvasás során.");
        }
    }
}
