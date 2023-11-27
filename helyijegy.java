import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class BuszJegyek {
    public static void main(String[] args) {
        ArrayList<String> adatok = new ArrayList<>();

        try {
            RandomAccessFile fajl = new RandomAccessFile("eladott.txt", "r");
            String sor;
            while ((sor = fajl.readLine()) != null) {
                adatok.add(sor);
            }
            fajl.close();
        } catch (IOException e) {
            System.out.println("Hiba történt az állomány olvasása közben.");
            // Ha hiba történik az állomány olvasása közben, az első 10 sorral dolgozunk
            String[] alapAdatok = {
                "1 100",
                "2 150",
                "3 200",
                "4 120",
                "5 180",
                "6 250",
                "7 300",
                "8 210",
                "9 180",
                "10 220"
            };
            for (String sor : alapAdatok) {
                adatok.add(sor);
            }
        }

        // 2. feladat: Legutolsó jegyvásárló ülésének sorszáma és az általa beutazott távolság
        if (!adatok.isEmpty()) {
            String[] utolsoJegy = adatok.get(adatok.size() - 1).split(" ");
            int ulesSorszam = Integer.parseInt(utolsoJegy[0]);
            int tavolsag = Integer.parseInt(utolsoJegy[1]);
            System.out.println("Legutolsó jegyvásárló ülés sorszáma: " + ulesSorszam);
            System.out.println("Beutazott távolság: " + tavolsag);
        }

        // 3. feladat: Listázza ki, kik utazták végig a teljes utat
        for (String sor : adatok) {
            System.out.print(sor.split(" ")[0] + " ");
        }
        System.out.println();

        // 4. feladat: Jegybevételek kiszámítása
        int osszesBevetel = 0;
        for (String sor : adatok) {
            int tavolsag = Integer.parseInt(sor.split(" ")[1]);
            osszesBevetel += tavolsag;
        }
        System.out.println("Jegybevétel összesen: " + osszesBevetel);

        // 5. feladat: Hányan szálltak fel és le a végállomás előtt
        int felszallas = 0;
        int leszallas = 0;
        for (String sor : adatok.subList(0, adatok.size() - 1)) {
            felszallas += Integer.parseInt(sor.split(" ")[0]);
            leszallas += Integer.parseInt(sor.split(" ")[1]);
        }
        System.out.println("Végállomást megelőzően fel szálltak: " + felszallas);
        System.out.println("Végállomást megelőzően le szálltak: " + leszallas);
    }
}
