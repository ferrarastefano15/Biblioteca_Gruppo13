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

    /** @brief Gestore della logica di business dei prestiti */
    private InterfacciaGestorePrestiti gestorePrestiti;

    /** @brief Gestore della logica di business dei libri */
    private InterfacciaGestoreLibri gestoreLibri;

    /** @brief Gestore della logica di business degli utenti */
    private InterfacciaGestoreUtenti gestoreUtenti;

    /**
     * @brief Inizializza il controller dei prestiti.
     * 
     * Configura la tabella dei prestiti, popola i ComboBox e imposta
     * la data di default per i prestiti.
     * 
     * @param[in] igp Gestore dei prestiti.
     * @param[in] igl Gestore dei libri.
     * @param[in] igu Gestore degli utenti.
     */
    public void init(InterfacciaGestorePrestiti igp, InterfacciaGestoreLibri igl, InterfacciaGestoreUtenti igu) {
        this.gestorePrestiti = igp;
        this.gestoreLibri = igl;
        this.gestoreUtenti = igu;

        configuraTabella();

        // Aggiorna i ComboBox quando vengono aperti
        cbUtente.setOnShowing(e -> riempiForm());
        cbLibro.setOnShowing(e -> riempiForm());

        // Imposta data di default 15 giorni nel futuro
        dpData.setValue(LocalDate.now().plusDays(15));

        aggiornaTabella();
    }

    /**
     * @brief Configura le colonne della tabella e lo stile delle righe.
     */
    private void configuraTabella() {
        // Colonna utente
        colPrestitoUtente.setCellValueFactory(d -> 
            new SimpleStringProperty(d.getValue().getUtente().toString())
        );

        // Colonna libro
        colPrestitoLibro.setCellValueFactory(d -> 
            new SimpleStringProperty(d.getValue().getLibro().toString())
        );

        // Colonna data di restituzione
        colPrestitoData.setCellValueFactory(d -> new SimpleObjectProperty<>(d.getValue().getDataRestituzione()));
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

        // Evidenzia i prestiti in ritardo
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

    /**
     * @brief Aggiorna la tabella con tutti i prestiti ordinati per data.
     */
    private void aggiornaTabella() {
        tabellaPrestiti.getItems().setAll(gestorePrestiti.getOrdinati());
    }

    /**
     * @brief Popola i ComboBox di utenti e libri con i dati correnti.
     */
    private void riempiForm() {
        cbUtente.getItems().setAll(gestoreUtenti.cercaUtente(""));
        cbLibro.getItems().setAll(gestoreLibri.cercaLibro(""));
    }

    /**
     * @brief Ripristina i valori di default del form per inserire un nuovo prestito.
     */
    private void svuotaForm() {
        cbUtente.setValue(null);
        cbLibro.setValue(null);
        dpData.setValue(LocalDate.now().plusDays(15));
    }

    /**
     * @brief Registra un nuovo prestito.
     * 
     * Valida i dati selezionati e chiama il gestore dei prestiti per aggiungere il prestito.
     * Aggiorna la tabella e i ComboBox, mostrando eventuali messaggi.
     */
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

    /**
     * @brief Restituisce un libro e rimuove il prestito dal sistema.
     * 
     * Aggiorna la tabella, i ComboBox e mostra un messaggio informativo.
     */
    @FXML
    private void btnRimuovi() {
        Prestito p = tabellaPrestiti.getSelectionModel().getSelectedItem();
        if (p == null) { 
            GestoreMessaggi.mostraErrore("Seleziona un prestito da restituire."); 
            return; 
        }

        gestorePrestiti.restituisciLibro(p);

        aggiornaTabella();
        riempiForm();
        cbLibro.getItems().setAll(gestoreLibri.cercaLibro(""));
        GestoreMessaggi.mostraInfo("Libro restituito.");
    }
    
}