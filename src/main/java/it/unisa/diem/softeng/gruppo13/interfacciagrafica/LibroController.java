package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaGestorePrestiti;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    /** @brief Gestore della logica di business dei libri */
    private InterfacciaGestoreLibri gestoreLibri;

    /** @brief Gestore della logica di business dei prestiti */
    private InterfacciaGestorePrestiti gestorePrestiti;
    
    /** @brief Lista osservabile dei libri mostrati nella tabella */
    private ObservableList<Libro> datiLibri;

    /**
     * @brief Inizializza il controller dei libri.
     * 
     * Configura la tabella, i binding delle colonne, i listener
     * e carica i dati iniziali.
     * 
     * @param[in] igl Interfaccia gestore dei libri.
     * @param[in] igp Interfaccia gestore dei prestiti.
     */
    public void init(InterfacciaGestoreLibri igl, InterfacciaGestorePrestiti igp) {
        this.gestoreLibri = igl;
        this.gestorePrestiti = igp;

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

    /** @brief Aggiorna la tabella dei libri. */
    void aggiornaTabella() {
        String query = txtCerca.getText();
        tabellaLibri.getItems().setAll(gestoreLibri.cercaLibro(query));
    }

    /** @brief Riempie il form con i dati del libro selezionato. */
    private void riempiForm(Libro l) {
        if (l != null) {
            tfTitolo.setText(l.getTitolo());
            tfAutori.setText(l.getAutori());
            tfAnno.setText(String.valueOf(l.getAnno()));
            tfIsbn.setText(l.getIsbn());
            tfCopie.setText(String.valueOf(l.getCopieDisponibili()));
            tfCopie.setEditable(false);
        } else {
            btnAnnulla();
        }
    }

    /** @brief Gestisce l'azione di ricerca dei libri. */
    @FXML
    private void btnCerca() {
        aggiornaTabella();
    }

    /** @brief Ripristina il form allo stato iniziale. */
    @FXML
    private void btnAnnulla() {
        tfTitolo.clear();
        tfAutori.clear();
        tfAnno.clear();
        tfIsbn.clear();
        tfCopie.clear();
        tfCopie.setEditable(true);
        tabellaLibri.getSelectionModel().clearSelection();
    }

    /** @brief Aggiunge un nuovo libro al sistema. */
    @FXML
    private void btnAggiungi() {
        try {
            int anno = validaIntero(tfAnno.getText(), "Anno");
            int copie = validaIntero(tfCopie.getText(), "Copie");
            List<String> autori = Arrays.asList(tfAutori.getText().split(","));

            Libro nuovo = new Libro(
                tfTitolo.getText(),
                autori,
                anno,
                tfIsbn.getText(),
                copie
            );

            gestoreLibri.aggiungiLibro(nuovo);

            aggiornaTabella();
            btnAnnulla();

        } catch (Exception e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
    }

    /** @brief Modifica il libro selezionato. */
    @FXML
    private void btnModifica() {
        Libro selected = tabellaLibri.getSelectionModel().getSelectedItem();

        if (selected == null) {
            GestoreMessaggi.mostraErrore("Seleziona un libro dalla tabella per modificarlo.");
            return;
        }

        try {
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Impossibile modificare questo libro perché ci sono copie in prestito.");
            }

            int anno = validaIntero(tfAnno.getText(), "Anno");
            int copie = validaIntero(tfCopie.getText(), "Copie");
            List<String> autori = Arrays.asList(tfAutori.getText().split(","));

            Libro nuovoLibro = new Libro(
                tfTitolo.getText(),
                autori,
                anno,
                tfIsbn.getText(),
                copie
            );

            gestoreLibri.modificaLibro(selected, nuovoLibro);

            aggiornaTabella();
            btnAnnulla();
            GestoreMessaggi.mostraInfo("Libro modificato con successo.");

        } catch (Exception e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
    }

    /** @brief Rimuove il libro selezionato. */
    @FXML
    private void btnRimuovi() {
        Libro selected = tabellaLibri.getSelectionModel().getSelectedItem();

        if (selected == null) {
            GestoreMessaggi.mostraErrore("Seleziona un libro da eliminare.");
            return;
        }

        try {
            if (gestorePrestiti.haPrestitiAttivi(selected)) {
                throw new Exception("Impossibile eliminare: il libro è attualmente in prestito.");
            }

            gestoreLibri.rimuoviLibro(selected);

            aggiornaTabella();
            btnAnnulla();

        } catch (Exception e) {
            GestoreMessaggi.mostraErrore(e.getMessage());
        }
    }

    /** @brief Valida e converte una stringa in intero. */
    private int validaIntero(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                "Il campo '" + fieldName + "' deve essere un numero intero valido."
            );
        }
    }
}