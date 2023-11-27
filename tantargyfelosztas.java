import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Leon
 */
public class tantargyfelosztas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       RandomAccessFile raf;
       String sor;
       ArrayList<String>adatok1 = new ArrayList<>();
       ArrayList<String>adatok2 = new ArrayList<>();
       ArrayList<String>adatok3 = new ArrayList<>();
       ArrayList<Integer>adatok4 = new ArrayList<>();
       int db = 0;
       Scanner s = new Scanner(System.in);
       try{
           raf = new RandomAccessFile("beosztas.txt", "r");
           sor = raf.readLine();
           while (sor != null){
               adatok1.add(sor);
               sor = raf.readLine();
               adatok2.add(sor);
               sor = raf.readLine();
               adatok3.add(sor);
               sor = raf.readLine();
               adatok4.add(Integer.parseInt(sor));
               sor = raf.readLine();
               db++;
           }
       }
       catch(IOException e){
           System.out.println("HIBA: " + e);
       }
       ArrayList<Tanfel>tanfelek = new ArrayList<>();
       for(int i = 0;i<adatok1.size() && i<adatok2.size() && i<adatok3.size() && i<adatok4.size();i++){
           Tanfel ujTanfelek = new Tanfel(adatok1.get(i),adatok2.get(i),adatok3.get(i),adatok4.get(i));
           tanfelek.add(ujTanfelek);
       }
        
        System.out.println(db);
        int hetiOra = 0;
        for(Tanfel tanfel :tanfelek){
            hetiOra += tanfel.getHetiOra();
        }
        System.out.println(hetiOra);
        System.out.println("tanar: ");
        String egyTanar = s.nextLine();
        int oradb = 0;
        for(Tanfel tanfel :tanfelek){
            
            if(tanfel.getTanarNev().equals(egyTanar)){
                oradb += tanfel.getHetiOra();
            }
        }
        System.out.println(egyTanar +" "+ oradb);
         ArrayList<String>tanarok = new ArrayList<>();
         for(Tanfel tanfel :tanfelek){
             String tanarNev = tanfel.getTanarNev();
             if(!tanarok.contains(tanarNev)){
                 tanarok.add(tanarNev);
             }
         }
         System.out.println(tanarok.size());
    }
}