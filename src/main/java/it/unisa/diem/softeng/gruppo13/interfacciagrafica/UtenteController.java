package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.dati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UtenteController {


    @FXML private TableView<Utente> tabellaUtenti;
    @FXML private TableColumn<Utente, String> colCognome, colNome, colMatricola, colEmail;
    @FXML private TextField txtCerca;

    @FXML private TextField tfNome, tfCognome, tfMatricola, tfEmail;

    private GestoreUtenti gestore;
    private GestorePrestiti gestorePrestiti;


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

    private void mostraErrore(String msg) {  
    }
}