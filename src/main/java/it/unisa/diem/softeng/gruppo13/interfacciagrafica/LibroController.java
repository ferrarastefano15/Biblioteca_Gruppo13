package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @class LibroController
 * @brief Gestisce l'interfaccia utente per la visualizzazione e gestione dei libri in biblioteca.
 * 
 * Questa classe gestisce la logica dell'interfaccia utente per la gestione dei libri, 
 * inclusa la visualizzazione dei libri in una tabella, l'aggiunta, la modifica, 
 * la rimozione e la ricerca dei libri. 
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
public class LibroController {

    @FXML private TableView<Libro> tabellaLibri;
    @FXML private TableColumn<Libro, String> colTitolo, colAutori, colIsbn;
    @FXML private TableColumn<Libro, Integer> colAnno, colCopie;
    @FXML private TextField txtCerca;

    @FXML private TextField tfTitolo, tfAutori, tfAnno, tfIsbn, tfCopie;

    private InterfacciaGestoreLibri gestoreLibri;
    private InterfacciaGestorePrestiti gestorePrestiti;
    
    private ObservableList<Libro> datiLibri;

     /**
     * @brief Inizializza il controller dei libri.
     * 
     * Questo metodo viene chiamato durante l'inizializzazione del controller 
     * per configurare la tabella dei libri, impostare i listener per la selezione 
     * di un libro dalla tabella, e aggiornare la vista con i libri.
     * 
     * @param[in] gl Il gestore dei libri.
     * @param[in] gp Il gestore dei prestiti.
     */
    public void init(InterfacciaGestoreLibri igl, InterfacciaGestorePrestiti igp) {
        
        this.gestoreLibri=igl;
        this.gestorePrestiti=igp;
        
        datiLibri = FXCollections.observableArrayList();
        tabellaLibri.setItems(datiLibri);
        
        colTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        colAnno.setCellValueFactory(new PropertyValueFactory<>("anno"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colCopie.setCellValueFactory(new PropertyValueFactory<>("copieDisponibili"));
        
        colAutori.setCellValueFactory(data -> 
                new SimpleStringProperty(data.getValue().getAutori())
        );
        
        tabellaLibri.getSelectionModel().selectedItemProperty().addListener(
        (obs, oldVal, newVal) -> riempiForm(newVal)
        );
        
        aggiornaTabella();
    }

    private void aggiornaTabella(){
        
        String query = txtCerca.getText();
        tabellaLibri.getItems().setAll(gestoreLibri.cercaLibro(query));
    }
    
    private void riempiForm(Libro l) {
        
        if (l != null) {
            tfTitolo.setText(l.getTitolo());
            tfAutori.setText(l.getAutori());
            tfAnno.setText(String.valueOf(l.getAnno()));
            tfIsbn.setText(l.getIsbn());
            tfCopie.setText(String.valueOf(l.getCopieDisponibili()));
        } else {
            btnAnnulla(); 
        }
    }

    @FXML private void btnCerca() {
        
        aggiornaTabella();
    } 
    
    @FXML
    private void btnAnnulla() { 
        
        tfTitolo.clear();
        tfAutori.clear();
        tfAnno.clear();
        tfIsbn.clear();
        tfCopie.clear();
        
        tabellaLibri.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void btnAggiungi() {
        
        try {
            // 1. Parsing dei dati (View Logic)
            int anno = validaIntero(tfAnno.getText(), "Anno");
            int copie = validaIntero(tfCopie.getText(), "Copie");
            List<String> autori = Arrays.asList(tfAutori.getText().split(","));

            // 2. Creazione Oggetto
            Libro nuovo = new Libro(
                tfTitolo.getText(),
                autori,
                anno,
                tfIsbn.getText(),
                copie
            );

            // 3. Chiamata al Service (Business Logic)
            gestoreLibri.aggiungiLibro(nuovo);
            
            // 4. Aggiornamento UI
            aggiornaTabella();
            btnAnnulla(); // Pulisce i campi dopo l'inserimento

        } catch (NumberFormatException e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        } catch (IllegalArgumentException e) {
            GestoreMessaggi.mostraErrore(e.getMessage()); // Errori di validazione del Service
        } catch (Exception e) {
            GestoreMessaggi.mostraErrore("Errore imprevisto: " + e.getMessage());
        }
    }

    @FXML
    private void btnModifica() {
        
        Libro selected = tabellaLibri.getSelectionModel().getSelectedItem();
        
        if (selected == null) { 
            GestoreMessaggi.mostraErrore("Seleziona un libro dalla tabella per modificarlo."); 
            return; 
        }
        
        try {
            // 2. Controllo Integrità Referenziale (Responsabilità del Controller/PrestitoService)
            // Non permettiamo di modificare un libro che è fuori in prestito
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Impossibile modificare questo libro perché ci sono copie in prestito.");
            } else {
            }
            
            // 3. Raccolta dati dai campi (Parsing)
            int anno = validaIntero(tfAnno.getText(), "Anno");
            int copie = validaIntero(tfCopie.getText(), "Copie");
            List<String> autori = Arrays.asList(tfAutori.getText().split(","));
            
            // 4. Creazione dell'oggetto "Nuovo" (DTO con i dati aggiornati)
            Libro nuovoLibro = new Libro(
                tfTitolo.getText(),
                autori,
                anno,
                tfIsbn.getText(), // Prendo il testo, nel caso l'utente abbia corretto l'ISBN
                copie
            );
            
            // 5. Chiamata al Gestore (Business Logic)
            gestoreLibri.modificaLibro(selected, nuovoLibro);
            
            // 6. Aggiornamento UI
            aggiornaTabella();
            btnAnnulla(); // Pulisce i campi
            GestoreMessaggi.mostraInfo("Libro modificato con successo.");

        } catch (NumberFormatException e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Errori di validazione del Gestore (es. ISBN duplicato, Anno futuro)
            GestoreMessaggi.mostraErrore(e.getMessage());
        } catch (Exception e) {
            // Errori generici o di integrità (es. Libro in prestito)
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
    }

    @FXML
    private void btnRimuovi() {
        
        Libro selected = tabellaLibri.getSelectionModel().getSelectedItem();
        if (selected == null) { GestoreMessaggi.mostraErrore("Seleziona un libro da eliminare."); return; }

        try {
            // 1. Controllo Integrità
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Impossibile eliminare: il libro è attualmente in prestito.");
            }
            
            // 2. Chiamata al Service
            gestoreLibri.rimuoviLibro(selected);
            
            // 3. Refresh
            aggiornaTabella();
            btnAnnulla();

        } catch (Exception e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
    }

    private int validaIntero(String value, String fieldName) {
        
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Il campo '" + fieldName + "' deve essere un numero intero valido.");
        }
        
    }
    
}