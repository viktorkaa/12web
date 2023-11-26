import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Szalag {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("szallit.txt", "r");
            Scanner scanner = new Scanner(System.in);

            int szalagHossz = file.readInt();
            int egysegMozdulasIdeje = file.readInt();

            int maxTavolsag = 0;
            int maxTavolsagSzallitasSorszam = 0;

            // Szállítások adatainak beolvasása és feladatok megoldása
            while (file.getFilePointer() < file.length()) {
                int sorszam = file.readInt();
                int indulashely = file.readInt();
                int erkezeshely = file.readInt();
                int tomeg = file.readInt();

                // 2. feladat: Indulási és célhely kiírása
                System.out.println("2. feladat:");
                int megadottSzallitasSorszam = scanner.nextInt();
                if (sorszam == megadottSzallitasSorszam) {
                    System.out.println("Indulási hely: " + indulashely);
                    System.out.println("Célhely: " + erkezeshely);
                }

                // 3. feladat: Szállítás távolságának kiszámítása és 4. feladat megoldása
                int tavolsag;
                if (erkezeshely > indulashely) {
                    tavolsag = erkezeshely - indulashely;
                } else {
                    tavolsag = szalagHossz - (indulashely - erkezeshely);
                }

                if (tavolsag > maxTavolsag) {
                    maxTavolsag = tavolsag;
                    maxTavolsagSzallitasSorszam = sorszam;
                }
            }

            System.out.println("4. feladat:");
            System.out.println("A legnagyobb szállítási távolság: " + maxTavolsag + ", sorszám: " + maxTavolsagSzallitasSorszam);

            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található.");
        } catch (IOException e) {
            System.out.println("Hibaa az adatok olvasása közben.");
        }
    }
}
