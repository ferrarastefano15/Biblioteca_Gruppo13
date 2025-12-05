/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Stefano
 */
public class GestoreLibro {
    
    
    private List<Libro> libri = new ArrayList<>();

    public List<Libro> getLibri() { return libri; }
    
    public void setLibri(List<Libro> nuoviLibri) { this.libri = new ArrayList<>(nuoviLibri); }

    public void aggiungiLibro(Libro libro) {
    }

    public void rimuoviLibro(Libro libro) {
    }

    public List<Libro> cercaLibro(String query) {
        return null;
    }
    
}
