/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;
import java.awt.*;
import javax.swing.*;
/**
 * klasa ustawiająca tło gry
 * klasa dziedziczy po JPanel
 * @author Paweł Trybuła
 */
public class Background_panel extends JPanel {
    /** etykieta na której osadzone zostaje tło */
    private JLabel background;
    /** tło gry */
    private ImageIcon back = new ImageIcon("images\\background.png");
    
    /**
     * konstruktor klasy ustawiający odpowiednie tło gry
     */
    public Background_panel (){
        background = new JLabel ();
        background.setIcon(back);
        background.setLayout(new BorderLayout());
        this.setBounds(0, 0, Buttons.WIDTH, Buttons.HEIGHT);
        this.setOpaque(false);
        this.add(background);
    }
}
