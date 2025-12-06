package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.Arrays;
import java.util.List;

public class LibroController {

    @FXML private TableView<Libro> tabellaLibri;
    @FXML private TableColumn<Libro, String> colTitolo, colAutori, colIsbn;
    @FXML private TableColumn<Libro, Integer> colAnno, colCopie;
    @FXML private TextField txtCerca;

    @FXML private TextField tfTitolo, tfAutori, tfAnno, tfIsbn, tfCopie;

    private GestoreLibri gestore;
    private GestorePrestiti gestorePrestiti;

    public void init(GestoreLibri gl, GestorePrestiti gp) {
    }

    private void riempiForm(Libro l) {
    }

    @FXML private void btnCerca() {
    } 
    
    @FXML
    private void btnAnnulla() { 
    }
    
    private void btnPulisci() {
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

    private int parseIntero(String value, String fieldName) {
        return 0;
    }
    
    private void mostraErrore(String msg) {  
    }
}