package buttons;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Obszar graficzny gry 
 * Dziedziczenie po JPanel
 * @author Paweł Trybuła
 */
public class Panel extends JPanel{
    /** stala przetrzymująca informacje o elemencie jaki należy wybrać*/
    public static int stan;
    /** informacje o aktualnym poziomie*/
    public static int poziom;
    /** zdobyte punkty */
    public static float punkty;
    /** przyciski z osadzona grafika */
    private JButton but1, but2, but3, but4;
    /** uruchomienie gry */
    private JButton start;
    /** restart gry */
    private JButton new_g;
    /** wyswietla kształt i figurę */
    private JLabel order;
    /** napis zegar */
    private JLabel zegar;
    /** napis poziom */
    private JLabel lvl;
    /** aktualny poziom */
    private JLabel number;
    /** napiz wskaż */
    private JLabel wskaz;
    /** etykiety streszczające zasady gry */
    private JLabel inst, inst2, inst3;
    /** poprawnosc wybranej figury */
    private JLabel dob_zle;
    /** napis ostatnia odpowiedź */
    private JLabel odpow;
    /** zdobyte punkty na koncu rozgrywki */
    private JLabel wynik;
    /** najwtzszy wynik */
    private JLabel highest;
    /** dynamicznie wyswietla pozostały czas */
    public static JLabel czas;
    /** pomocnicza ikona */
    private ImageIcon black = new ImageIcon("images\\czarny.jpg");
    /** ikona przycisku start */
    private ImageIcon but_start = new ImageIcon("images\\button_start.png");
    /** ikona przycisku nowa gra */
    private ImageIcon but_ng = new ImageIcon("images\\button_nowa_gra.png");
    /** ikony, reprezentujące figury, zmieniające się dynamicznie */
    private ImageIcon icon_b_1, icon_b_2, icon_b_3, icon_b_4;  
    /** obiekt przydzielający ikony figur */
    public Template ttt;
    /** wczytany najwyzszy wynik */
    private String wczyt;
    /** przechowuje aktualny pozostały czas */
    private String timeSTR;
    /** obiekt mierzący czas */
    public Timer timer;
    /** czas od którego zegar zaczyna odliczać */
    private float z_czasu;
    /** pomocniacza zmienna przy zmianie typu String -> float */
    private float wczyt_temp;
    
    /**
     * konstruktor wywolujacy funkcje ustawiającą wartości początkowe elementów
     */
    
    public Panel(){
        customization();
    }
    /** funkcja ustawiająca wartości początkowe elementów */
    public void customization(){
        this.removeAll();
        //Buttons
        but1 = new JButton();
        but2 = new JButton();
        but3 = new JButton();
        but4 = new JButton();
        start = new JButton();
        new_g = new JButton();
        new_g.setIcon(but_ng);
        new_g.setBounds(350, 300, 100, 40);        
        but1.setBounds(140,300,70,70);
        but2.setBounds(280,300,70,70);
        but3.setBounds(420,300,70,70);
        but4.setBounds(540,300,70,70);
        start.setBounds(350, 100, 100, 40);
        start.setIcon(but_start);               
        but1.setBorder(null);
        but2.setBorder(null);
        but3.setBorder(null);
        but4.setBorder(null);
        start.setBorder(null);
        new_g.setBorder(null);
        start.setBackground(Color.black);
        new_g.setBackground(Color.black);
        new_g.setVisible(false);
        
        //JLabels
        highest = new JLabel("");
        wynik = new JLabel();
        wskaz = new JLabel ("Wskaż :");
        order = new JLabel ("");
        zegar = new JLabel("Czas");
        czas = new JLabel ("0");
        lvl = new JLabel("Poziom");
        number = new JLabel("1");
        inst = new JLabel("Wciśnij START aby rozpocząć");
        inst2 = new JLabel ("Odnajdź figurę w odpowiednim kolorze");
        inst3 = new JLabel ("Nie pozwól aby czas spadł do 0");
        dob_zle = new JLabel("");
        odpow = new JLabel("Ostatnia odpowiedź : ");
        odpow.setBounds(20,520,200,40);
        odpow.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lvl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        odpow.setForeground(Color.BLACK);
        order.setForeground(Color.GRAY);
        dob_zle.setBounds(210, 520, 100, 40);
        dob_zle.setForeground(Color.BLACK);
        dob_zle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dob_zle.setVisible(true);
        number.setFont(new Font("Times New Roman", Font.BOLD, 30));
        order.setFont(new Font("Times New Roman", Font.BOLD, 35));
        order.setForeground(Color.GRAY);
        order.setBounds(310, 100, 650, 50);
        wskaz.setBounds(180, 100, 150, 50);
        wskaz.setFont(new Font("Times New Roman", Font.BOLD, 35));
        order.setForeground(Color.GRAY);
        wskaz.setVisible(false);
        wskaz.setForeground(Color.GRAY);
        zegar.setBounds(380,520,70,40);
        number.setBounds(700,520,70,40);
        czas.setBounds (450,520,70,40);
        czas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        zegar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lvl.setBounds(600,520,70,40);
        inst.setBounds(270, 150, 400, 100);
        inst.setForeground(Color.GRAY);
        inst.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inst2.setBounds(230, 175, 400, 100);
        inst2.setForeground(Color.GRAY);
        inst2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inst3.setBounds(270, 200, 400, 100);
        inst3.setForeground(Color.GRAY);
        inst3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        wynik.setVisible(false);
        wynik.setBounds(325, 100, 200, 60);
        wynik.setForeground(Color.GRAY);
        wynik.setFont(new Font("Times New Roman", Font.BOLD, 28));
        highest.setVisible(false);
        highest.setBounds(305, 150, 200, 60);
        highest.setForeground(Color.GRAY);
        highest.setFont(new Font("Times New Roman", Font.BOLD, 28));
        
        //Panel Setup
        this.setLayout(null);
        this.validate();
        this.setOpaque(false);
        this.setBounds(0, 0, Buttons.WIDTH, Buttons.HEIGHT);
        this.add(but1);
        this.add(but2);
        this.add(but3);
        this.add(but4);
        this.add(order);
        this.add(odpow);
        this.add(zegar);
        this.add(lvl);
        this.add(number);
        this.add(czas);
        this.add(start);
        this.add(wskaz);
        this.add(inst);
        this.add(inst2);
        this.add(dob_zle);
        this.add(inst3);
        this.add(new_g);
        this.add(wynik);
        this.add(highest);
        new_game();
    }
    /** funkcja rozpoczynająca rozgrywkę */
    public void new_game(){
        //Basic
        punkty=0;
        stan=0;
        poziom=0;
        start.setVisible(true);
        inst.setVisible(true);
        inst2.setVisible(true);
        wskaz.setVisible(false);
        but1.setIcon(black);
        but2.setIcon(black);
        but3.setIcon(black);
        but4.setIcon(black);
        
        /* dodanie akcji do przycisków */
        start.addActionListener(new ActionListener(){ //przycisk start
            @Override
            public void actionPerformed(ActionEvent e){
                losuj(0);
                start.setVisible(false);
                inst.setVisible(false);
                inst2.setVisible(false);
                inst3.setVisible(false);
                wskaz.setVisible(true);
                order.setVisible(true);
                next_lvl();
            }
        });
        
        but1.addActionListener(new ActionListener(){ // figura nr 1
            @Override
            public void actionPerformed(ActionEvent e){
                losuj(1);
                timer.stop();
                next_lvl();                
            }
        });
        but2.addActionListener(new ActionListener(){ //figura nr2
            @Override
            public void actionPerformed(ActionEvent e){
                losuj(2);
                timer.stop();
                next_lvl();
            }
        });
        but3.addActionListener(new ActionListener(){ //figura nr3
            @Override
            public void actionPerformed(ActionEvent e){
                losuj(3);
                timer.stop();
                next_lvl();
            }
        });
        but4.addActionListener(new ActionListener(){ //figura nr4
            @Override
            public void actionPerformed(ActionEvent e){
                losuj(4);
                timer.stop();
                next_lvl();
            }
        });
        new_g.addActionListener(new ActionListener(){ //przycisk zrestartowania gry
            @Override
            public void actionPerformed(ActionEvent e){
                new_g.setVisible(false);
                start.setVisible(true);
                wynik.setVisible(false);
                highest.setVisible(false);
                customization();                
            }
        });
    }
    
    /** funkcja wywoływana przy przechodzeniu na kolejny poziom */
    public void next_lvl(){
        number.setText(poziom + "");
        z_czasu=(float)13-poziom; //czas do odliczania zależny od poziomu
        if(z_czasu<=2){
            z_czasu=2;
        }
        // timer obiekt odliczający czas
        timer = new Timer(100, new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent arg0) {
                z_czasu-=0.1;
                if(z_czasu<=0.0){ // warunek inicjujący ekran końcowy w przypadku przekroczenia czasu
                    dob_zle.setText("Time Out!");
                    koniec();
                }
                timeSTR = String.format("%.1f", z_czasu);
                czas.setText(timeSTR);
             }
        });
         timer.setRepeats(true);
         timer.start(); 
    }
    
    /** 
     * funkcja zajmująca się mechanizmem gry
     * przydziela odpowiednie ikony do przycisków
     * sprawdza poprawność naszych strzałów
     * @param button numer wcisniętego przycisku 
     * @return metoda nie zwraca wartości
     */
    public int losuj(int button){
        ttt = new Template();
        icon_b_1 = new ImageIcon(ttt.butt1);
        icon_b_2 = new ImageIcon(ttt.butt2);
        icon_b_3 = new ImageIcon(ttt.butt3);
        icon_b_4 = new ImageIcon(ttt.butt4);
        if(button==stan){ // jeżeli wciśnięty został przycisk start
            if(button==0){
                try {
                    dob_zle.setText("...");
                    Thread.sleep(500);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }else{ // jeżeli wciśnięty został przycisk zgodny z oczekiwaniami
                try {
                    punkty = punkty + poziom;
                    dob_zle.setText("Dobrze!");
                    Thread.sleep(500);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }else{ // jeżeli wciśnięty został przycisk niezgodny z oczekiwaniami
            try {
                punkty = punkty - 2;
                dob_zle.setText("Źle!");
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        poziom++;
        but1.setIcon(icon_b_1);
        but2.setIcon(icon_b_2);
        but3.setIcon(icon_b_3);
        but4.setIcon(icon_b_4);
        stan = ttt.num_butt+1;
        order.setText(ttt.label_fin);
        return(0);
    }
    
    /** 
     * funkcja inicjująca ekran końcowy gry
     * aktywuje się po przekroczeniu czasu
     */
    public void koniec(){
        Inoutfile iof = new Inoutfile(); //obiekt zarządzający operacjami wej/wyj do plików
        timer.stop();
        timer.setRepeats(false);
        but1.setVisible(false);
        but2.setVisible(false);
        but3.setVisible(false);
        but4.setVisible(false);
        order.setVisible(false);
        wskaz.setVisible(false);
        new_g.setVisible(true);
        wynik.setVisible(true);
        wynik.setText("Wynik :" + punkty);
        dob_zle.setText("");
        number.setText("1");
        //porównywanie uzuskanego wyniku z najlepszym
        wczyt = iof.read();
        wczyt_temp = Float.valueOf(wczyt); 
        if(wczyt_temp<punkty){
            iof.write(punkty);  
        }      
        highest.setVisible(true);
        highest.setText("Najlepszy :" + iof.read());
    }
}



