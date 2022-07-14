package lodz_gis_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PlikiOdczytZapis {

    public static void main(String[] args) {
        
        Scanner sc = null;
        PrintWriter pw = null;
        
        try {
            System.out.println("Hello");

            sc = new Scanner(new File("plik.txt"));

            System.out.println(sc.nextLine());
            System.out.println(sc.nextLine());
            // System.out.println(sc.nextLine());

            pw = new PrintWriter(new File("wynik.txt"));
            
            pw.println("Hello");
            pw.println("Dodawanie: "+(2+6));
            pw.flush();
                     
        } catch (FileNotFoundException ex1) {
            System.out.println("Brak pliku");
        } catch (NoSuchElementException ex2) {
            System.out.println("Nie ma nic do czytania");
        } finally {
            sc.close();
            pw.close();
        }   

    }
    
}
