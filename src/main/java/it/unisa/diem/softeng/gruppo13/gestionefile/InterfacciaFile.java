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
 * L'interfaccia definisce il contratto per le operazioni di persistenza e recupero dei dati 
 * per l'archivio della biblioteca, in particolare le operazione di scrittura dei 
 * dati (libri, utenti, prestiti) nelle rispettive fonti esterne, e le operazione 
 * di lettura dei dati dalle fonti esterne e di ricostruzione delle collezioni in memoria.
 * @author Daniel, Andrea, Stefano, Daniele
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
      
      
     /**
     * @brief Carica i dati di libri, utenti e prestiti da un file esterno.
     * 
     * @param[in] libri Lista dei libri da importare.
     * @param[in] utenti Lista degli utenti da importare.
     * @param[in] prestiti Lista dei prestiti da importare.
     */
      public void caricaDati(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
    
    
}
