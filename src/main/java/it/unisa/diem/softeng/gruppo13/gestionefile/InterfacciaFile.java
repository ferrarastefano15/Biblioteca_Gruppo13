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
 * @interface InterfacciaFile
 * @brief Definisce le operazioni per la gestione dei file in un sistema di biblioteca.
 * 
 * L'interfaccia `InterfacciaFile` definisce il contratto per le operazioni di 
 * salvataggio dei dati relativi ai libri, agli utenti e ai prestiti in un file, 
 * in modo che possano essere successivamente letti.
 *
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */


public interface InterfacciaFile {
    

    /**
     * @brief Salva i dati di libri, utenti e prestiti in un file esterno.
     * 
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     */
      public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
    
    
}
