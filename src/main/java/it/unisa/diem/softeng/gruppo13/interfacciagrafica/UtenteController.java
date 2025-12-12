package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreUtenti;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @class UtenteController
 * @brief Gestisce l'interfaccia utente per la visualizzazione e gestione degli utenti.
 * 
 * Questa classe si occupa della logica dell'interfaccia utente per la gestione 
 * degli utenti della biblioteca. Permette di visualizzare, aggiungere, modificare 
 * e rimuovere gli utenti.
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
public class UtenteController {


    @FXML private TableView<Utente> tabellaUtenti;
    @FXML private TableColumn<Utente, String> colCognome, colNome, colMatricola, colEmail;
    @FXML private TextField txtCerca;

    @FXML private TextField tfNome, tfCognome, tfMatricola, tfEmail;

    private InterfacciaGestoreUtenti gestoreUtenti;
    private InterfacciaGestorePrestiti gestorePrestiti;
    
    private ObservableList<Utente> datiUtenti;


     /**
     * @brief Inizializza il controller per gestire l'interfaccia per la visualizzazione
     * e la gestione degli utenti.
     * 
     * Questo metodo viene chiamato per configurare la tabella degli utenti, 
     * le azioni di selezione e l'aggiornamento della vista.
     * 
     * @param[in] gu Il gestore degli utenti.
     * @param[in] gp Il gestore dei prestiti.
     */
    public void init(InterfacciaGestoreUtenti igu, InterfacciaGestorePrestiti igp) {
        
        this.gestoreUtenti=igu;
        this.gestorePrestiti=igp;
        
        datiUtenti = FXCollections.observableArrayList();
        tabellaUtenti.setItems(datiUtenti);
    
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tabellaUtenti.getSelectionModel().selectedItemProperty().addListener(
        (obs, oldVal, newVal) -> riempiForm(newVal)
        );
        
        aggiornaTabella();
        
        
    }

    private void aggiornaTabella() {
        
        String query = txtCerca.getText();
        datiUtenti.setAll(gestoreUtenti.cercaUtente(query));
        
    }
    
    private void riempiForm(Utente u) {
        
        if (u != null) {
            tfNome.setText(u.getNome());
            tfCognome.setText(u.getCognome());
            tfMatricola.setText(u.getMatricola());
            tfEmail.setText(u.getEmail());
        } else {
            btnAnnulla();
        }
    }
    
    @FXML 
    private void btnCerca() { 
        aggiornaTabella(); 
    }

    @FXML
    private void btnAnnulla() { 
        
        tfNome.clear(); tfCognome.clear(); 
        tfMatricola.clear(); 
        tfEmail.clear();
        tabellaUtenti.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void btnAggiungi() {
        
        try {
            Utente u = new Utente(
                tfNome.getText().trim(), 
            tfCognome.getText().trim(),  
            tfMatricola.getText().trim(), 
            tfEmail.getText().trim()
            );
            
            gestoreUtenti.aggiungiUtente(u);
            
            aggiornaTabella();
            btnAnnulla();
        } catch (Exception e) { 
           GestoreMessaggi.mostraErrore(e.getMessage()); 
        }
    }

    @FXML
    private void btnModifica() {
        
        // 1. Recupera l'utente selezionato (Il "Vecchio")
        Utente selected = tabellaUtenti.getSelectionModel().getSelectedItem();
        
        if (selected == null) { 
            GestoreMessaggi.mostraErrore("Seleziona un utente da modificare."); 
            return; 
        }
        
        try {
            // 2. Controllo Integrità Referenziale
            // Non permettiamo di modificare un utente che ha libri in prestito
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Utente con prestiti attivi: impossibile modificare i dati.");
            }
            
            // 3. Creazione del "Nuovo" oggetto con i dati del form
            Utente nuovoUtente = new Utente(
                tfNome.getText(), 
                tfCognome.getText(), 
                tfMatricola.getText(),
                tfEmail.getText()
            );
            
            // 4. Chiamata al Service (Business Logic)
            gestoreUtenti.modificaUtente(selected, nuovoUtente);
            
            // 5. Aggiornamento UI
            aggiornaTabella();
            btnAnnulla();

        } catch (IllegalArgumentException e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        } catch (Exception e) { 
            GestoreMessaggi.mostraErrore(e.getMessage()); 
        }
        
    }

    @FXML
    private void btnRimuovi() {
        
        Utente selected = tabellaUtenti.getSelectionModel().getSelectedItem();
        if (selected == null) { return; }

        try {
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                GestoreMessaggi.mostraErrore("Impossibile eliminare: l'utente ha prestiti attivi."); return;
            }

            gestoreUtenti.rimuoviUtente(selected);
            aggiornaTabella();
            btnAnnulla();
            
        } catch (Exception e) { 
           GestoreMessaggi.mostraErrore(e.getMessage()); 
        }
    }

}