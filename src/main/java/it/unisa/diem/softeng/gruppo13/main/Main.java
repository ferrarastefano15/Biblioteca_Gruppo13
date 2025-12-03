package it.unisa.diem.softeng.gruppo13.main;

import javafx.application.Application;
import javafx.stage.Stage;

/**
     *@class Main
     *@brief Classe di avvio per l'applicazione JavaFX.
     *
     * La classe `Main` estende `Application` ed è il punto di partenza per l'esecuzione dell'applicazione JavaFX.
     * Contiene il metodo `main` per avviare l'applicazione e il metodo `start` che verrà utilizzato per configurare
     * e mostrare la finestra principale (Stage) dell'applicazione. Al momento, il metodo `start` non è implementato. 
     *
     *@author Daniel, Andrea, Stefano, Daniele
     *@date Dicembre 03, 2025
     * 
     * 
     */
 
    public class Main extends Application {
        
      /**
     * @brief Metodo principale dell'applicazione.
     * 
     * Il metodo `main` è il punto di partenza per l'esecuzione dell'applicazione. In questo caso, stampa semplicemente
     * "Hello World!" sulla console.
     * 
     * @param args Argomenti da linea di comando (non utilizzati in questa implementazione).
     */
        public static void main(String[] args) {
            System.out.println("Hello World!");
        }


    /**
     * @brief Metodo che avvia l'interfaccia grafica dell'applicazione.
     * 
     * Il metodo `start` è il punto di ingresso per la configurazione e la visualizzazione dell'interfaccia grafica.
     * Questo metodo verrà chiamato dal framework JavaFX per avviare l'applicazione, ma al momento l'implementazione
     * è mancante e solleva un'eccezione `UnsupportedOperationException`.
     * 
     * @param primaryStage Finestra principale dell'applicazione (Stage).
     * @throws UnsupportedOperationException Se il metodo non è implementato.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
