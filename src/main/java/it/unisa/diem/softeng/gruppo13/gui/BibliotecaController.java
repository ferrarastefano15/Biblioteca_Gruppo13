/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gui;

import it.unisa.diem.softeng.gruppo13.logica.InterfacciaBiblioteca;
import it.unisa.diem.softeng.gruppo13.logica.InterfacciaFile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class BibliotecaController implements Initializable {

    
    private InterfacciaBiblioteca archivio;
    private InterfacciaFile file;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSalvaFile(ActionEvent event) {
    }

    @FXML
    private void btnEsci(ActionEvent event) {
    }

    @FXML
    private void btnAggiungiLibro(ActionEvent event) {
    }

    @FXML
    private void btnModificaLibro(ActionEvent event) {
    }

    @FXML
    private void handleEliminaLibro(ActionEvent event) {
    }

    @FXML
    private void btnCercaLibro(KeyEvent event) {
    }

    @FXML
    private void btnAggiungiUtente(ActionEvent event) {
    }

    @FXML
    private void btnModificaUtente(ActionEvent event) {
    }

    @FXML
    private void btnEliminaUtente(ActionEvent event) {
    }

    @FXML
    private void btnCercaUtente(KeyEvent event) {
    }

    @FXML
    private void btnRegistraPrestito(ActionEvent event) {
    }

    @FXML
    private void btnRegistraRestituzione(ActionEvent event) {
    }
    
}
