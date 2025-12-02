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
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface InterfacciaBiblioteca {
    
    List<Libro> getLibri();
    List<Utente> getUtenti();
    List<Prestito> getPrestiti();
    
    void aggiungiLibro(String titolo, String autori, String anno, String isbn, String copie) throws Exception;
    void aggiungiUtente(String nome, String cognome, String matricola, String email) throws Exception;
    void aggiungiPrestito(Utente u, Libro l, LocalDate data) throws Exception;
    
    List<Libro> cercaLibri(String query);
    List<Utente> cercaUtenti(String query);

    void rimuoviLibro(Libro l);
    void rimuoviUtente(Utente u);
    void restituisciLibro(Prestito p);
   
    
}
