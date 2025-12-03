/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.logica;

import it.unisa.diem.softeng.gruppo13.elementi.Libro;
import it.unisa.diem.softeng.gruppo13.elementi.Prestito;
import it.unisa.diem.softeng.gruppo13.elementi.Utente;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface InterfacciaFile {
    
    public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
    
    
}
