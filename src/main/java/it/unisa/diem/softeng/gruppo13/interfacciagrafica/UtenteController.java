package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreUtenti;
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

    /** @brief Gestore della logica di business degli utenti */
    private InterfacciaGestoreUtenti gestoreUtenti;

    /** @brief Gestore della logica di business dei prestiti */
    private InterfacciaGestorePrestiti gestorePrestiti;

    /** @brief Lista osservabile per la tabella utenti */
    private ObservableList<Utente> datiUtenti;

    /**
     * @brief Inizializza il controller degli utenti.
     * 
     * Configura la tabella degli utenti, imposta listener per la selezione
     * di un utente e aggiorna la vista iniziale.
     * 
     * @param[in] igu Interfaccia gestore degli utenti.
     * @param[in] igp Interfaccia gestore dei prestiti.
     */
    public void init(InterfacciaGestoreUtenti igu, InterfacciaGestorePrestiti igp) {
        
        this.gestoreUtenti = igu;
        this.gestorePrestiti = igp;

        datiUtenti = FXCollections.observableArrayList();
        tabellaUtenti.setItems(datiUtenti);

        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Listener per la selezione di un utente
        tabellaUtenti.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> riempiForm(newVal)
        );

        aggiornaTabella();
    }

    /** @brief Aggiorna la tabella filtrando gli utenti secondo la query di ricerca. */
    private void aggiornaTabella() {
        String query = txtCerca.getText();
        datiUtenti.setAll(gestoreUtenti.cercaUtente(query));
    }

    /** @brief Riempi i campi del form con i dati dell'utente selezionato. */
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

    /** @brief Aggiorna la tabella in base alla query di ricerca inserita. */
    @FXML 
    private void btnCerca() { 
        aggiornaTabella(); 
    }

    /** @brief Ripristina i valori di default dei campi del form. */
    @FXML
    private void btnAnnulla() { 
        tfNome.clear(); 
        tfCognome.clear(); 
        tfMatricola.clear(); 
        tfEmail.clear();
        tabellaUtenti.getSelectionModel().clearSelection();
    }

    /** @brief Aggiunge un nuovo utente. */
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

    /** @brief Modifica i dati dell'utente selezionato. */
    @FXML
    private void btnModifica() {
        Utente selected = tabellaUtenti.getSelectionModel().getSelectedItem();
        if (selected == null) { 
            GestoreMessaggi.mostraErrore("Seleziona un utente da modificare."); 
            return; 
        }

        try {
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Utente con prestiti attivi: impossibile modificare i dati.");
            }

            Utente nuovoUtente = new Utente(
                tfNome.getText(), 
                tfCognome.getText(), 
                tfMatricola.getText(),
                tfEmail.getText()
            );

            gestoreUtenti.modificaUtente(selected, nuovoUtente);

            aggiornaTabella();
            btnAnnulla();

        } catch (IllegalArgumentException e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        } catch (Exception e) { 
            GestoreMessaggi.mostraErrore(e.getMessage()); 
        }
    }

    /** @brief Rimuove l'utente selezionato. */
    @FXML
    private void btnRimuovi() {
        Utente selected = tabellaUtenti.getSelectionModel().getSelectedItem();
        if (selected == null) { return; }

        try {
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                GestoreMessaggi.mostraErrore("Impossibile eliminare: l'utente ha prestiti attivi."); 
                return;
            }

            gestoreUtenti.rimuoviUtente(selected);
            aggiornaTabella();
            btnAnnulla();

        } catch (Exception e) { 
           GestoreMessaggi.mostraErrore(e.getMessage()); 
        }
    }
}
