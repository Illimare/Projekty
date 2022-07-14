package lodz_gis_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.StrictMath.sqrt;
import java.util.Arrays;
import java.util.Scanner;

public class Obliczenia {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("liczby.txt"));
            
            int licznik = 0;
            double suma = 0;
            double iloczyn = 1;
            int[] tabLiczb = new int[150];
            int max = tabLiczb[0];
            int min = tabLiczb[0];
            
            while (sc.hasNext()){
                
                String wyraz = sc.next();
                int liczba = Integer.parseInt(wyraz);
                
                tabLiczb[licznik] = liczba;
                
                suma = suma + liczba;
                
                System.out.println(++licznik+". "+liczba);
  
            }
            
            System.out.print("Tablica Liczb: ");
            
            for (int i = 0; i < tabLiczb.length; i++) {
                System.out.print(tabLiczb[i]+" ");
            }
            
            for(int i=0; i<tabLiczb.length; i++){
            iloczyn = tabLiczb[i] * tabLiczb[i];
            }
            
            for (int i = 0; i < tabLiczb.length; i++) {
            if (tabLiczb[i] > max)
                max = tabLiczb[i];
            }
            
            System.out.println("");
            
            System.out.println("Suma liczb: "+suma);
            
            PrintWriter pw = new PrintWriter(new File("obliczenia.txt"));
            
            pw.println("Suma liczb: "+suma);
            pw.flush();
            
            double srednia = suma/tabLiczb.length;
            System.out.println("Średnia arytmetyczna: " + srednia);
            pw.println("Średnia arytmetyczna: " + srednia);
            pw.flush();
            
            double geometryczna = sqrt(iloczyn);
            System.out.println("Średnia geometryczna: " + geometryczna);
            pw.println("Średnia geometryczna: " + geometryczna);
            pw.flush();
            
            System.out.println("Największa liczba w tablicy to: " + max);
            pw.println("Największa liczba w tablicy to: " + max);
            pw.flush();
            
            Arrays.sort(tabLiczb);
            
            System.out.println("Najmniejsza liczba w tablicy to: " + tabLiczb[0]);
            pw.println("Najmniejsza liczba w tablicy to: " + tabLiczb[0]);
            pw.flush();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Brak pliku");
        }

    }

}
