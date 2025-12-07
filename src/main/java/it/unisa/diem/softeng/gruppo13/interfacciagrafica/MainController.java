package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

/**
 * @class MainController
 * @brief Controller principale che gestisce le viste di libri, utenti e prestiti.
 * 
 * Questa classe è responsabile per l'inizializzazione e la gestione dell'interfaccia
 * utente principale. Coordina i controller di libri, utenti e prestiti, 
 * collegandosi alle relative schermate, e gestisce le operazioni di salvataggio ed uscita.
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
public class MainController implements Initializable {

    @FXML private LibroController vistaLibriController;
    @FXML private UtenteController vistaUtentiController;
    @FXML private PrestitoController vistaPrestitiController;

    private GestoreLibri gestoreLibri;
    private GestoreUtenti gestoreUtenti;
    private GestorePrestiti gestorePrestiti;

     /**
     * @brief Inizializza il controller principale.
     * 
     * Questo metodo viene chiamato all'avvio dell'applicazione. Inizializza i 
     * servizi per la gestione di libri, utenti e prestiti, carica i dati dal file
     * e inietta i servizi nei sotto-controller.
     * 
     * @param[in] location L'URL relativo alla posizione della vista FXML.
     * @param[in] resources Il bundle di risorse associato alla vista.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void btnSalva() {
    }

    @FXML
    private void btnEsci() {
    }
}