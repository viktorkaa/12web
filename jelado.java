import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ForgalmiMeres {
    public static void main(String[] args) {
        ArrayList<String> adatok = new ArrayList<>();
        try {
            RandomAccessFile file = new RandomAccessFile("meresek.txt", "r");
            String sor;
            while ((sor = file.readLine()) != null) {
                adatok.add(sor);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 1. feladat
        System.out.println("A mérések során rögzített járművek száma: " + adatok.size());

        // 2. feladat
        int forgalomElott9Orakor = 0;
        for (String adat : adatok) {
            String[] reszek = adat.split(" ");
            if (Integer.parseInt(reszek[0]) < 9) {
                forgalomElott9Orakor++;
            }
        }
        System.out.println("9 óra előtt haladt járművek száma: " + forgalomElott9Orakor);

        // 3. feladat - időpont bekérése a felhasználótól
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem, adjon meg egy óra értéket (0-23):");
        int ora = scanner.nextInt();
        System.out.println("Kérem, adjon meg egy perc értéket (0-59):");
        int perc = scanner.nextInt();

        // 3a. feladat
        int haladoJarmuvek = 0;
        for (String adat : adatok) {
            String[] reszek = adat.split(" ");
            if (Integer.parseInt(reszek[0]) == ora && Integer.parseInt(reszek[1]) == perc) {
                haladoJarmuvek++;
            }
        }
        System.out.println("A(z) " + ora + ":" + perc + " időpontban haladó járművek száma a kezdő méréspontnál: " + haladoJarmuvek);

        // 3b. feladat
        double utSzakaszHossza =  /* Itt számoljuk ki az útszakasz hosszát */;
        double forgalomSuruseg = haladoJarmuvek / utSzakaszHossza;
        System.out.println("A forgalomsűrűség a megadott időpontban: " + forgalomSuruseg);

        // 4. feladat
        // Az átlagsebesség és lehagyott járművek kiszámítása

        // 5. feladat
        // Legnagyobb átlagsebességgel haladó jármű adatai
      MeresAdat elsőMeres = adatok.get(0);
        int ora = elsőMeres.getOra();
        int perc = elsőMeres.getPerc();
        System.out.println("Az első mért adat: " + ora + ":" + perc);
    }
}


class MeresAdat {
    private int ora;
    private int perc;

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getPerc() {
        return perc;
    }

    public void setPerc(int perc) {
        this.perc = perc;
    }
}
