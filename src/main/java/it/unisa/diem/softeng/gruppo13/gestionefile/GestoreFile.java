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
 * La classe `SalvaFile` è responsabile per l'implementazione del salvataggio 
 * dei dati relativi a libri, utenti e prestiti in file esterni. 
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class GestoreFile implements InterfacciaFile {
  
    private static final String FILE_NAME = "archivio_biblioteca.dat";
    
    /**
     * @brief Salva i dati dei libri, degli utenti e dei prestiti in un file .dat
     * 
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     */
        @Override
        public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        }
    
    
    
}
