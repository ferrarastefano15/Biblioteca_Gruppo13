package it.unisa.diem.softeng.gruppo13.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;

/**
     *@class Main
     *@brief Classe di avvio per l'applicazione JavaFX.
     * 
     * La classe 'Main' avvia l'applicazione JavaFx fornendo i metodi
     * necessari all'avvio della scena
     * 
     *@author Daniel, Andrea, Stefano, Daniele 
     */
 
    public class Main extends Application {
        
        
    private static final String FXML_PATH = "/it/unisa/diem/softeng/gruppo13/gui/MainView.fxml";
    private static final String APP_TITLE = "Gestione Biblioteca - Gruppo 13";
    
    
     /**
     * @brief Metodo che avvia l'interfaccia grafica dell'applicazione.
     * 
     * Avvia l'applicazione JavaFX mostrando la finestra principale
     * 
     * @param[in] primaryStage Finestra principale dell'applicazione (Stage).
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    
        
     /**
     * @brief Metodo principale dell'applicazione.
     * 
     * @param[in] args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
            launch(args);
    }


   
}
