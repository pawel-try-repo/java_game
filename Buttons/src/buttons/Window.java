/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;
import java.awt.*;
import javax.swing.*;
/**
 * Klasa dziedziczy po JFrame
 * Utworzenie okna gry
 * @Paweł Trybuła
 */
public class Window extends JFrame {
    private JFrame okno;
    private int width, height;
    private String name;
    private Background_panel back;
    private Panel panel;
    
    /**
     * Główny konstruktor klasy
     * @param width szerokość okna
     * @param height wysokość okna
     * @param name nazwa okna
     */
    public Window ( int width, int height, String name){
        super();
        this.width=width;
        this.height=height;
        this.name=name;
        okno = new JFrame (name);
        okno.setSize(width, height);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        okno.setVisible(true);

        panel();
        backg();
    }
    /**
     * funkcja dodająca panel zawierający tło
     */
    private void backg(){      
        back = new Background_panel();
        okno.add(back);
    }
    /**
     * funkcja dodająca panel z oknem akcji
     */
    private void panel(){
        panel = new Panel();
        okno.add(panel); 
    }
}
