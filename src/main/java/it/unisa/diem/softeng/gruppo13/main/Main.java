package it.unisa.diem.softeng.gruppo13.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        
    
     /** @brief Percorso del file FXML della vista principale */
    private static final String FXML_PATH = "/it/unisa/diem/softeng/gruppo13/interfacciagrafica/main_view.fxml";

    /** @brief Titolo della finestra principale dell'applicazione */
    private static final String TITLE = "Gestione Biblioteca - Gruppo 13";

    /**
     * @brief Metodo che avvia l'interfaccia grafica dell'applicazione.
     * 
     * Carica la vista principale da FXML, imposta il titolo e la scena
     * dello stage principale e mostra la finestra.
     * 
     * @param[in] primaryStage Finestra principale dell'applicazione (Stage).
     * @throws Exception Se si verifica un errore durante il caricamento del file FXML.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(FXML_PATH));

        primaryStage.setTitle(TITLE);

        primaryStage.setScene(new Scene(root,1000,600));

        primaryStage.show();
    }

    /**
     * @brief Metodo principale dell'applicazione.
     * 
     * Lancia l'applicazione JavaFX.
     * 
     * @param[in] args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        launch(args);
    }

   
}
