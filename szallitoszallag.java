import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Szallitas {
    public static void main(String[] args) {
        ArrayList<String> adatok = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile("szallit.txt", "r");
            String sor;
            while ((sor = raf.readLine()) != null) {
                adatok.add(sor);
            }
            raf.close();
        } catch (IOException e) {
            System.err.println("HIBA: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int szallitasSorszama = scanner.nextInt();

        // Feladat 2: Szállítás sorszámának kezelése és kiírása
        String[] szallitasAdatok = adatok.get(szallitasSorszama - 1).split(" ");
        String indulasiHely = szallitasAdatok[1];
        String celHely = szallitasAdatok[2];
        System.out.println("Indulási hely: " + indulasiHely + ", Célhely: " + celHely);

        // Feladat 4: Meghatározni a legnagyobb távolságot és sorszámát
        int maxTavolsag = 0;
        ArrayList<Integer> maxTavSorszamok = new ArrayList<>();
        for (String adat : adatok) {
            String[] adatSor = adat.split(" ");
            int tavolsag = tav(Integer.parseInt(adatSor[0]), Integer.parseInt(adatSor[1]), Integer.parseInt(adatSor[2]));
            if (tavolsag > maxTavolsag) {
                maxTavolsag = tavolsag;
                maxTavSorszamok.clear();
                maxTavSorszamok.add(Integer.parseInt(adatSor[0]));
            } else if (tavolsag == maxTavolsag) {
                maxTavSorszamok.add(Integer.parseInt(adatSor[0]));
            }
        }
        System.out.println("Maximális távolság: " + maxTavolsag + ", Sorszám(ok): " + maxTavSorszamok);

        // Feladat 5: Összesen hány tömeg haladt el a 0 pozíció előtt
        int elhaladottTomeg = 0;
        for (String adat : adatok) {
            String[] adatSor = adat.split(" ");
            int helyzet = Integer.parseInt(adatSor[1]);
            if (helyzet < 0) {
                elhaladottTomeg += Integer.parseInt(adatSor[3]);
            }
        }
        System.out.println("Elhaladó tömeg: " + elhaladottTomeg);
    }

    // Feladat 3: Távolság kiszámítása
    public static int tav(int szalaghossz, int indulashelye, int erkezeshelye) {
        return Math.abs(erkezeshelye - indulashelye);
    }
}


public class SzallitasAdat {
    private int sorszam;
    private String indulasiHely;
    private String celHely;
    private int tomeg;

    // Getterek és setterek
    public int getSorszam() {
        return sorszam;
    }

    public void setSorszam(int sorszam) {
        this.sorszam = sorszam;
    }

    public String getIndulasiHely() {
        return indulasiHely;
    }

    public void setIndulasiHely(String indulasiHely) {
        this.indulasiHely = indulasiHely;
    }

    public String getCelHely() {
        return celHely;
    }

    public void setCelHely(String celHely) {
        this.celHely = celHely;
    }

    public int getTomeg() {
        return tomeg;
    }

    public void setTomeg(int tomeg) {
        this.tomeg = tomeg;
    }
}
