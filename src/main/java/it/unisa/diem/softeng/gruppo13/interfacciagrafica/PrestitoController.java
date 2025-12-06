package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.time.LocalDate;

public class PrestitoController {
    
    @FXML private TableView<Prestito> tabellaPrestiti;
    @FXML private TableColumn<Prestito, String> colPrestitoUtente, colPrestitoLibro;
    @FXML private TableColumn<Prestito, LocalDate> colPrestitoData;

    @FXML private ComboBox<Utente> cbUtente;
    @FXML private ComboBox<Libro> cbLibro;
    @FXML private DatePicker dpData;

    private GestorePrestiti gestore;
    private GestoreLibri gestoreLibri;
    private GestoreUtenti gestoreUtenti;

    public void init(GestorePrestiti gp, GestoreLibri gl, GestoreUtenti gu) {
    }

    private void aggiornaTabella() {
    }

    @FXML
    private void btnAggiungi() {
    }

    @FXML
    private void btnRimuovi() {
    }
    
    private void mostraErrore(String msg) {  
    }
}