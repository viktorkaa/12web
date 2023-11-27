import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class CsokiAutomata {

    public static void main(String[] args) {
        String csokiFile = "csoki.txt";
        String vasarlasFile = "vasarlas.txt";

        String[] csokiAdatok = beolvasCsokiAdatok(csokiFile);
        int[] vasarlasAdatok = beolvasVasarlasAdatok(vasarlasFile);

        if (csokiAdatok == null || vasarlasAdatok == null) {
            csokiAdatok = new String[]{"1000", "500", "1500", "0", "20000"};
            vasarlasAdatok = new int[]{1, 3, 5};
        }

        int csokiErtek = szamolCsokiErtek(csokiAdatok);
        System.out.println("Az automatában " + csokiErtek + " fabatka értékű csokoládé van.");

        megjelenitRekeszek(vasarlasAdatok);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a csokoládéra szánt pénzösszeget: ");
        int penzOsszeg = scanner.nextInt();
        int[] valaszthatoRekeszek = kivalasztRekeszek(csokiAdatok, penzOsszeg);
        System.out.print("Választható rekeszek: ");
        for (int i = 0; i < valaszthatoRekeszek.length; i++) {
            System.out.print(valaszthatoRekeszek[i]);
            if (i < valaszthatoRekeszek.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static String[] beolvasCsokiAdatok(String fileNeve) {
        String[] csokiAdatok = new String[5];
        try (RandomAccessFile file = new RandomAccessFile(fileNeve, "r")) {
            for (int i = 0; i < 5; i++) {
                csokiAdatok[i] = file.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return csokiAdatok;
    }

    public static int[] beolvasVasarlasAdatok(String fileNeve) {
        int[] vasarlasAdatok = null;
        try (RandomAccessFile file = new RandomAccessFile(fileNeve, "r")) {
            String line = file.readLine();
            String[] parts = line.split(" ");
            vasarlasAdatok = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                vasarlasAdatok[i] = Integer.parseInt(parts[i]);
            }
        } catch (IOException | NumberFormatException e) {
            return null;
        }
        return vasarlasAdatok;
    }

    public static int szamolCsokiErtek(String[] adatok) {
        int ertek = 0;
        for (String adat : adatok) {
            ertek += Integer.parseInt(adat);
        }
        return ertek;
    }

    public static void megjelenitRekeszek(int[] rekeszek) {
        System.out.print("Vásárolt rekeszek: ");
        for (int i = 0; i < rekeszek.length; i++) {
            System.out.print(rekeszek[i]);
            if (i < rekeszek.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static int[] kivalasztRekeszek(String[] adatok, int csokiMennyiseg) {
        ArrayList<Integer> valaszthatoRekeszek = new ArrayList<>();
        for (int i = 0; i < adatok.length; i++) {
            if (Integer.parseInt(adatok[i]) >= csokiMennyiseg) {
                valaszthatoRekeszek.add(i + 1);
            }
        }
        return valaszthatoRekeszek.stream().mapToInt(i -> i).toArray();
    }
}
