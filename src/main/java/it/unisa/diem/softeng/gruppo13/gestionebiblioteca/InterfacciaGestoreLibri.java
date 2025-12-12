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
    
    public void aggiungiLibro(Libro libro);
    
    public void modificaLibro(Libro libro1, Libro libro2);
    
    public void rimuoviLibro(Libro libro);
    
    public List<Libro> cercaLibro(String query);
    
}
