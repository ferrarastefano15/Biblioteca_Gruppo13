package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import javafx.scene.control.Alert;

/**
 * @class GestoreMessaggi
 * @brief Classe che gestisce la visualizzazione dei messaggi di sistema all'utente.
 * 
 * Questa classe fornisce la logica per mostrare notifiche e avvisi.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreMessaggi {
    
    /** @brief Visualizza una finestra per segnalare un errore. */
    public static void mostraErrore(String msg) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
        
    }
    
    /** @brief Visualizza una finestra per mostrare un'informazione. */
    public static void mostraInfo(String msg) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informazione");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
        
    }

}