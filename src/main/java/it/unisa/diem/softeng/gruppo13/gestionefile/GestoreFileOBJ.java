/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionefile;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.List;

/**
 * @class GestoreFile
 * @brief Gestione del salvataggio dei dati.
 * 
 * La classe `GestoreFileCSV` è responsabile per l'implementazione del salvataggio 
 * e caricamento dei dati relativi a libri, utenti e prestiti in file esterno con
 * formato obj. 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreFileOBJ implements InterfacciaFile {
  
    
    /**
     * @brief Salva i dati dei libri, degli utenti e dei prestiti un file .obj
     * 
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     */
        @Override
        public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        }

    /**
     * @brief Carica i dati dei libri, degli utenti e dei prestiti da un file .obj
     * 
     * @param[in] libri Lista dei libri da importare.
     * @param[in] utenti Lista degli utenti da importare.
     * @param[in] prestiti Lista dei prestiti da importare.
     */
        @Override
        public void caricaDati(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        }
        
        
    
    
    
}
