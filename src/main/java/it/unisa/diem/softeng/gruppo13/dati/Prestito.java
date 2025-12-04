/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.dati;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Prestito {
    
    private Libro libro;
    private Utente utente;
    private LocalDate dataRestituzione;

    public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione) {
        this.libro = libro;
        this.utente = utente;
        this.dataRestituzione = dataRestituzione;
    }

    public Libro getLibro() { return libro; }
    public Utente getUtente() { return utente; }
    public LocalDate getDataRestituzione() { return dataRestituzione; }
    
}
