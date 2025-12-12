package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreUtenti;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.time.LocalDate;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @class PrestitoController
 * @brief Gestisce l'interfaccia utente per la visualizzazione e gestione dei prestiti.
 * 
 * Questa classe si occupa della logica dell'interfaccia utente per gestire i prestiti dei libri. 
 * Permette di visualizzare, aggiungere e restituire i prestiti interagendo con i 
 * gestori di libri, utenti e prestiti. 
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
public class PrestitoController {
    
    @FXML private TableView<Prestito> tabellaPrestiti;
    @FXML private TableColumn<Prestito, String> colPrestitoUtente, colPrestitoLibro;
    @FXML private TableColumn<Prestito, LocalDate> colPrestitoData;

    @FXML private ComboBox<Utente> cbUtente;
    @FXML private ComboBox<Libro> cbLibro;
    @FXML private DatePicker dpData;

    private InterfacciaGestorePrestiti gestorePrestiti;
    private InterfacciaGestoreLibri gestoreLibri;
    private InterfacciaGestoreUtenti gestoreUtenti;

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
    public void init(InterfacciaGestorePrestiti igp, InterfacciaGestoreLibri igl, InterfacciaGestoreUtenti igu) {
    
        this.gestorePrestiti=igp;
        this.gestoreLibri=igl;
        this.gestoreUtenti=igu;
        
        configuraTabella();
        
        cbUtente.setOnShowing(e -> riempiForm());
        cbLibro.setOnShowing(e -> riempiForm());
        
        dpData.setValue(LocalDate.now().plusDays(15));
        
        aggiornaTabella();
        
    }
    
    private void configuraTabella() {
        
        colPrestitoUtente.setCellValueFactory(d -> 
            new SimpleStringProperty(d.getValue().getUtente().toString())
        );

        colPrestitoLibro.setCellValueFactory(d -> 
            new SimpleStringProperty(d.getValue().getLibro().toString())
        );

        // Sostituisce sia PropertyValueFactory che CellFactory (se vuoi il massimo della robustezza)

        colPrestitoData.setCellValueFactory(d -> {
            LocalDate data = d.getValue().getDataRestituzione(); 
            return new SimpleObjectProperty<>(data); 
        });

        colPrestitoData.setCellFactory(tc -> new TableCell<Prestito, LocalDate>() {
        @Override
        protected void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            }
        });
        tabellaPrestiti.setRowFactory(tv -> new TableRow<Prestito>() {
         
        @Override
        protected void updateItem(Prestito p, boolean empty) {
            super.updateItem(p, empty);
            if (p != null && !empty && p.inRitardo()) {
                setStyle("-fx-background-color: #ffcccc;"); 
            } else {
                setStyle("");
            }
        }
        });
        
    }

    private void aggiornaTabella() {
        
        tabellaPrestiti.getItems().setAll(gestorePrestiti.getOrdinati());
        
    }

    
    private void riempiForm() {
        cbUtente.getItems().setAll(gestoreUtenti.cercaUtente(""));
        cbLibro.getItems().setAll(gestoreLibri.cercaLibro(""));
    }
    
    private void svuotaForm() {
    cbUtente.setValue(null); 
    cbLibro.setValue(null);
    dpData.setValue(LocalDate.now().plusDays(15)); 
    }
    
    
    @FXML
    private void btnAggiungi() {
        
        try {
            Utente u = cbUtente.getValue();
            Libro l = cbLibro.getValue();
            LocalDate d = dpData.getValue();

            if (u == null || l == null || d == null) {
                throw new IllegalArgumentException("Selezionare utente, libro e data.");
            }

            svuotaForm();
            gestorePrestiti.aggiungiPrestito(u, l, d);
            
            aggiornaTabella();
            riempiForm();
            cbLibro.getItems().setAll(gestoreLibri.cercaLibro(""));
            GestoreMessaggi.mostraInfo("Prestito registrato con successo.");
        } catch (Exception e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
        
    }

    @FXML
    private void btnRimuovi() {
        
        Prestito p = tabellaPrestiti.getSelectionModel().getSelectedItem();
        if (p == null) { 
            GestoreMessaggi.mostraErrore("Seleziona un prestito da restituire."); return; 
        }

        gestorePrestiti.restituisciLibro(p);
        
        aggiornaTabella();
        riempiForm(); 
        cbLibro.getItems().setAll(gestoreLibri.cercaLibro(""));
        GestoreMessaggi.mostraInfo("Libro restituito.");
    }
    
}