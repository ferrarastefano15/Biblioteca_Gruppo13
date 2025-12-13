package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionefile.GestoreFile;
import it.unisa.diem.softeng.gruppo13.gestionefile.InterfacciaFile;
import it.unisa.diem.softeng.gruppo13.interfacciagrafica.GestoreMessaggi;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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
    

    @FXML private TabPane tabPanePrincipale; 
    @FXML private Tab tabLibri; 
    @FXML private Tab tabUtenti;
    @FXML private Tab tabPrestiti; 

    @FXML private LibroController vistaLibriController;
    @FXML private UtenteController vistaUtentiController;
    @FXML private PrestitoController vistaPrestitiController;

    /** @brief Gestore della logica di business dei libri */
    private InterfacciaGestoreLibri gestoreLibri;

    /** @brief Gestore della logica di business degli utenti */
    private InterfacciaGestoreUtenti gestoreUtenti;

    /** @brief Gestore della logica di business dei prestiti */
    private InterfacciaGestorePrestiti gestorePrestiti;

    /** @brief Gestore per il caricamento e salvataggio dei dati su file */
    private InterfacciaFile gestoreFile;

    /**
     * @brief Inizializza il controller principale.
     * 
     * Inizializza i gestori, carica i dati dal file e inietta
     * i servizi nei sotto-controller (libri, utenti, prestiti).
     * Imposta anche il listener per aggiornare la tabella libri
     * quando l'utente seleziona la tab corrispondente.
     *
     * @param[in] location URL relativo alla posizione della vista FXML.
     * @param[in] resources Bundle di risorse associato alla vista.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestoreFile = new GestoreFile("Archivio"); 
        gestoreLibri = new GestoreLibri(); 
        gestoreUtenti = new GestoreUtenti();
        gestorePrestiti = new GestorePrestiti();

        // Carica i dati da file nei rispettivi gestori
        gestoreFile.caricaDati(
            gestoreLibri.getLibri(), 
            gestoreUtenti.getUtenti(), 
            gestorePrestiti.getPrestiti()
        );

        // Inietta i servizi nei sotto-controller
        if (vistaLibriController != null) 
            vistaLibriController.init(gestoreLibri, gestorePrestiti);
            
        if (vistaUtentiController != null) 
            vistaUtentiController.init(gestoreUtenti, gestorePrestiti);
            
        if (vistaPrestitiController != null) 
            vistaPrestitiController.init(gestorePrestiti, gestoreLibri, gestoreUtenti);

        // Imposta listener sulle tab
        setupTabListener();
    }

    /**
     * @brief Imposta il listener sulla tab dei libri.
     * 
     * Quando l'utente seleziona la tab dei libri, aggiorna la tabella
     * per riflettere eventuali modifiche ai dati.
     */
    private void setupTabListener() {
        if (tabLibri != null) {
            tabLibri.selectedProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection && vistaLibriController != null) {
                    vistaLibriController.aggiornaTabella();
                }
            });
        }
    }

    /**
     * @brief Gestisce l'azione di salvataggio dei dati.
     * 
     * Salva su file tutti i libri, utenti e prestiti correnti.
     * Mostra un messaggio informativo all'utente.
     */
    @FXML
    private void btnSalva() {
        gestoreFile.salvaFile(
            gestoreLibri.getLibri(),
            gestoreUtenti.getUtenti(), 
            gestorePrestiti.getPrestiti()
        );
      
        GestoreMessaggi.mostraInfo("Salvataggio completato");
    }

    /**
     * @brief Gestisce l'azione di uscita dall'applicazione.
     * 
     * Chiude l'applicazione in modo ordinato.
     */
    @FXML
    private void btnEsci() {
        Platform.exit();
    }
}