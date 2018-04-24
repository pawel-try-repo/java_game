/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import java.io.*;
import java.util.Scanner;

/**
 * Klasa wykonująca operacje wejscia wyjscia na plikach
 * @author Paweł Trybuła
 */
public class Inoutfile{
    /** wartosc pozyskana z pliku txt */
    String zdanie;
    /**
     * funkcja nadpisująca najwyższy wynik
     * @param x najwyzszy wynik przekazany do zapisu do pliku tekstowego
     * @return 
     */
    public float write(float x){
        try{
        PrintWriter zapis = new PrintWriter("wynik.txt");
        zapis.println(x);
        zapis.close();
        }catch(Exception e){}
        return(0);
    }
    /**
     * funkcja wczytująca najwyższy dotychczasowy wynik
     * @return zwraca odczytany najwyższy wynik
     */
    public String read (){ 
        try{
            File file = new File("wynik.txt");
            Scanner in = new Scanner(file);
            zdanie = in.nextLine();
        }catch(Exception e){}
        return(zdanie);
    }
}
