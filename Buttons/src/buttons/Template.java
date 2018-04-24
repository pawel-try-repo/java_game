/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import java.util.Random;

/**
 * klasa pomocnicza zajmująca się mechaniką gry
 * @author Paweł Trybuła
 */
class Template {
    /** przechowywanie wylosowanych grafik(adresy) */
    public String butt1, butt2, butt3, butt4;
    /** wartosc pomocnicz */
    public String label;
    /** zawiera gotowe do wyswietlenia żądanie konkretnej figury */
    public String label_fin;
    
    public int fig1, fig2, fig3, fig4, napis;
    /** wylosowany numer przycisku jaki należy wcisnąć */
    public int num_butt;
    /** tablica String przechowująca adresy grafik */
    public String[] icons = {"images\\brazowa_gwiazda.jpg",
                              "images\\czerwony_prostokat.jpg",
                              "images\\fioletowa_strzalka.jpg",
                              "images\\niebieska_gwiazda.jpg",
                              "images\\pomaranczowe_serce.jpg",
                              "images\\rozowy_trojkat.jpg",
                              "images\\siwy_kwadrat.jpg",
                              "images\\zolte_kolo.jpg",
                              "images\\zielony_trojkat.jpg",
                              "images\\zielony_prostokat.jpg"};

    /**
     * konstruktor w którym wykonywane są główne zadania klasy
     * wylosowanie figur do wyswietlenia
     * wylosowanie przycisku jaki należy wcisnąć
     */
    public Template() {
        
        //Losowanie Kształtów i Buttona (bez powtórzeń)      
        //Losowanie buttona
        Random r = new Random();
        num_butt=(r.nextInt(4));
        
        //Losowanie pierwszej figury
        Random s = new Random();
        fig1=(s.nextInt(8));
        //Losowanie drugiej figury
        Random t = new Random();
        fig2=(t.nextInt(8));
        while(fig2==fig1){
            fig2=(t.nextInt(8));
        }
        //Losowanie trzeciej figury
        Random u = new Random();
        fig3=(t.nextInt(8));
        while(fig3==fig2||fig3==fig1){
            fig3=(t.nextInt(8));
        }
        //Losowanie czwartej figury
        Random w = new Random();
        fig4=(t.nextInt(8));
        while(fig4==fig1||fig4==fig2||fig4==fig3){
            fig4=(t.nextInt(8));
        }
        
        ///Uaktywnienie buttona
        if(num_butt==0){
            napis=fig1;
            }else if(num_butt==1){
                napis=fig2;
            }else if(num_butt==2){
                napis=fig3;
            }else
                napis=fig4;
                
            
        ////Tworzenie polecenia////
        label = icons[napis];
        if (label=="images\\brazowa_gwiazda.jpg"){
            label_fin="brązową gwiazdę.";
            }else if(label=="images\\czerwony_prostokat.jpg"){
                label_fin="czerwony prostokąt.";
            }else if(label=="images\\fioletowa_strzalka.jpg"){
                label_fin="fioletową strzałkę.";
            }else if(label=="images\\niebieska_gwiazda.jpg"){
                label_fin="niebieską gwiazdę.";
            }else if(label=="images\\pomaranczowe_serce.jpg"){
                label_fin="pomarańczowe serce.";
            }else if(label=="images\\rozowy_trojkat.jpg"){
                label_fin="różowy trójkąt.";
            }else if(label=="images\\siwy_kwadrat.jpg"){
                label_fin="siwy kwadrat.";
            }else if(label=="images\\zolte_kolo.jpg"){
                label_fin="żółte koło.";
            }else if(label=="images\\zielony_trojkat.jpg"){
                label_fin="zielony trójkąt.";
            }else if(label=="images\\zielony_prostokat.jpg"){
                label_fin="zielony prostokąt.";
            }
            
        butt1 = icons[fig1];
        butt2 = icons[fig2];
        butt3 = icons[fig3];
        butt4 = icons[fig4];
        
        /// z klasy możemy pozyskać :
        /// randomowe ikony (butt1, butt2, butt3, butt4)
        /// numer przycisku aktywnego (num_butt)
        /// etykieta przypisana do przycisku (label_fin)
    }
    
}
