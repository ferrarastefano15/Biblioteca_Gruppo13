/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Stefano
 */
public interface InterfacciaGestorePrestiti {
    
    List<Prestito> getPrestiti();
    
    void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza)  throws Exception ;
    
    void restituisciLibro(Prestito prestito);
    
    boolean haPrestitiAttivi(Libro l);
    
    boolean haPrestitiAttivi(Utente u);
    
    List<Prestito> getOrdinati();
    
}
