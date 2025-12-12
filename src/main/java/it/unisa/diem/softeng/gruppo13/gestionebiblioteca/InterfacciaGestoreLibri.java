/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.List;

/**
 *
 * @author Stefano
 */
public interface InterfacciaGestoreLibri {
    
    List<Libro> getLibri();
    
    void aggiungiLibro(Libro libro);
    
    void modificaLibro(Libro libro1, Libro libro2);
    
    void rimuoviLibro(Libro libro);
    
    List<Libro> cercaLibro(String query);
    
}
