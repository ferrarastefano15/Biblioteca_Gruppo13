package it.unisa.diem.softeng.gruppo13.interfacciagrafica;

import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreLibri;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestoreUtenti;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.GestorePrestiti;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

public class MainController implements Initializable {

    @FXML private LibroController vistaLibriController;
    @FXML private UtenteController vistaUtentiController;
    @FXML private PrestitoController vistaPrestitiController;

    private GestoreLibri gestoreLibri;
    private GestoreUtenti gestoreUtenti;
    private GestorePrestiti gestorePrestiti;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void btnSalva() {
    }

    @FXML
    private void btnEsci() {
    }
}