/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.logica;

import it.unisa.diem.softeng.gruppo13.elementi.Libro;
import it.unisa.diem.softeng.gruppo13.elementi.Prestito;
import it.unisa.diem.softeng.gruppo13.elementi.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GestioneBiblioteca implements InterfacciaBiblioteca{
    
    private List<Libro> libri;
    private List<Utente> utenti;
    private List<Prestito> prestiti;
    private InterfacciaFile fileManager;

    public GestioneBiblioteca(InterfacciaFile fileManager) {
        this.libri = new ArrayList<>();
        this.utenti = new ArrayList<>();
        this.prestiti = new ArrayList<>();
        this.fileManager = fileManager;
    }
    
    

    @Override
    public List<Libro> getLibri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utente> getUtenti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestito> getPrestiti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aggiungiLibro(String titolo, String autori, String anno, String isbn, String copie) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aggiungiUtente(String nome, String cognome, String matricola, String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aggiungiPrestito(Utente u, Libro l, LocalDate data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> cercaLibri(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utente> cercaUtenti(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rimuoviLibro(Libro l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rimuoviUtente(Utente u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restituisciLibro(Prestito p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvaTutto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validaDatiLibro(String t, String a, String anno, String isbn, String copie){

    }

    private void validaDatiUtente(String n, String c, String m, String e){
        
    }

}
