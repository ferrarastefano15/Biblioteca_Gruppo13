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

/**
 * @class PrestitoController
 * @brief Gestisce l'interfaccia utente per la visualizzazione e gestione dei prestiti.
 * 
 * Questa classe si occupa della logica dell'interfaccia utente per gestire i prestiti dei libri. 
 * Permette di visualizzare, aggiungere e restituire i prestiti interagendo con i 
 * gestori di libri, utenti e prestiti.
 * 
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
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

     /**
     * @brief Gestisce l'interfaccia utente per la visualizzazione e gestione dei prestiti.
     * 
     * Questo metodo viene chiamato per configurare la tabella dei prestiti, 
     * i selettori di utenti, libri e data, e aggiornare i dati.
     * 
     * @param[in] gp Il gestore dei prestiti.
     * @param[in] gl Il gestore dei libri.
     * @param[in] gu Il gestore degli utenti.
     */
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