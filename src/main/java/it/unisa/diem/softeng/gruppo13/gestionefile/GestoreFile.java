/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionefile;

import it.unisa.diem.softeng.gruppo13.gestionefile.InterfacciaFile;
import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionebiblioteca.InterfacciaBiblioteca;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GestoreFile implements InterfacciaFile {
    
    
    @Override
    public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
