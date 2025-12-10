package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private GestoreUtenti gestore;
    private GestorePrestiti gestorePrestiti;


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
    public void init(GestoreUtenti gu, GestorePrestiti gp) {
    }

    private void aggiornaTabella() {
    }
    
    private void riempiForm(Utente u) {
    }
    
    @FXML 
    private void btnCerca() { 
    }

    @FXML
    private void btnAnnulla() { 
    }

    @FXML
    private void btnAggiungi() {
    }

    @FXML
    private void btnModifica() {
    }

    @FXML
    private void btnRimuovi() {
    }

}