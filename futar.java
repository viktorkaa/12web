import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class TavokFeladat {

    public static void main(String[] args) {
        ArrayList<Integer> tavolsagok = new ArrayList<>();

        try {
            RandomAccessFile fajl = new RandomAccessFile("tavok.txt", "r");
            String sor;
            while ((sor = fajl.readLine()) != null) {
                tavolsagok.add(Integer.parseInt(sor));
            }
            fajl.close();
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
        }

        if (tavolsagok.isEmpty()) {
            System.out.println("Nincsenek adatok a fájlban.");
            return;
        }

        // 2. Feladat: Hét legelső útja
        System.out.println("Hét legelső útja: " + tavolsagok.get(0) + " km");

        // 3. Feladat: Hét utolsó útja
        System.out.println("Hét utolsó útja: " + tavolsagok.get(tavolsagok.size() - 1) + " km");

        // 4. Feladat: Szabadnapok száma
        System.out.print("Szabadnapok száma: ");
        for (int i = 0; i < tavolsagok.size(); i++) {
            if (i % 7 == 0 && i != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 5. Feladat: Legtöbb fuvar napja
        int maxTavolsag = 0;
        int maxTavolsagIndex = 0;
        for (int i = 0; i < tavolsagok.size(); i++) {
            if (tavolsagok.get(i) > maxTavolsag) {
                maxTavolsag = tavolsagok.get(i);
                maxTavolsagIndex = i;
            }
        }
        String[] napok = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println("Legtöbb fuvar napja: " + napok[maxTavolsagIndex % 7]);

        // 6. Feladat: Egyes napokon megtett távolság
        String[] napNevek = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        for (int i = 0; i < tavolsagok.size(); i++) {
            System.out.println(napNevek[i % 7] + ": " + tavolsagok.get(i) + " km");
        }
    }
}
