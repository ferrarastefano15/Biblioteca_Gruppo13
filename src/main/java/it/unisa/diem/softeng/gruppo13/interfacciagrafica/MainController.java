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

    private InterfacciaGestoreLibri gestoreLibri;
    private InterfacciaGestoreUtenti gestoreUtenti;
    private InterfacciaGestorePrestiti gestorePrestiti;
    private InterfacciaFile gestoreFile;

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
        
        gestoreFile = new GestoreFile("Archivio"); 
        gestoreLibri = new GestoreLibri(); 
        gestoreUtenti = new GestoreUtenti();
        gestorePrestiti = new GestorePrestiti();
        
         gestoreFile.caricaDati(
            gestoreLibri.getLibri(), 
            gestoreUtenti.getUtenti(), 
            gestorePrestiti.getPrestiti()
        );
        
         
         if (vistaLibriController != null) 
            vistaLibriController.init(gestoreLibri, gestorePrestiti);
            
        if (vistaUtentiController != null) 
            vistaUtentiController.init(gestoreUtenti, gestorePrestiti);
            
        if (vistaPrestitiController != null) 
            vistaPrestitiController.init(gestorePrestiti, gestoreLibri, gestoreUtenti);
       
        setupTabListener();
    }
    
    // Nel MainController.java

private void setupTabListener() {
    // 1. Verifichiamo che la Tab Libri sia stata iniettata
    if (tabLibri != null) {
        
        // 2. Impostiamo un listener che si attiva quando la proprietà 'selected' cambia
        tabLibri.selectedProperty().addListener((obs, oldSelection, newSelection) -> {
            
            // 3. Se newSelection è TRUE, significa che l'utente ha cliccato sulla Tab Libri
            if (newSelection) {
                
                // 4. Verifichiamo che l'istanza del controller sia disponibile
                if (vistaLibriController != null) {
                    // CHIAMATA CHIAVE: Forziamo l'aggiornamento della tabella Libri
                    vistaLibriController.aggiornaTabella();
                }
            }
        });
    }
}
    
    @FXML
    private void btnSalva() {
        
      gestoreFile.salvaFile(
                gestoreLibri.getLibri(),
                gestoreUtenti.getUtenti(), 
                gestorePrestiti.getPrestiti()
        );
      
      GestoreMessaggi.mostraInfo("Salvataggio completato");
        
    }

    @FXML
    private void btnEsci() {
        
        Platform.exit();
        
    }
}