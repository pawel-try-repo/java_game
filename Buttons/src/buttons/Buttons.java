/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;
import java.awt.EventQueue;
/**
 *
 * @Pawerł Trybuła
 */
public class Buttons {
    
    /**
     * parametry rozmiaru okna
     */
    public static final int WIDTH=800, HEIGHT=600, HEIGHT_MENU=100;
    /**
     * funkcja tworząca okno gry
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window(WIDTH, HEIGHT, "Klocki");
            }
	});
    }     
}
