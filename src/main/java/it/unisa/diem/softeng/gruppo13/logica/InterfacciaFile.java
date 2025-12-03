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
 * @interface InterfacciaFile
 * @brief Definisce le operazioni per la gestione dei file in un sistema di biblioteca.
 * 
 * L'interfaccia `InterfacciaFile` definisce il contratto per le operazioni di salvataggio dei dati relativi 
 * ai libri, agli utenti e ai prestiti in un file. Le classi che implementano questa interfaccia devono fornire
 * una soluzione per persistere i dati in un file, in modo che possano essere successivamente letti e caricati.
 *
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */


public interface InterfacciaFile {
    

    /**
     * @brief Salva i dati di libri, utenti e prestiti in un file.
     * 
     * Questo metodo deve salvare le informazioni dei libri, degli utenti e dei prestiti in un file.
     * La persistenza dei dati permette di recuperare i dati anche dopo il riavvio del programma.
     * 
     * @param libri Lista dei libri da salvare.
     * @param utenti Lista degli utenti da salvare.
     * @param prestiti Lista dei prestiti da salvare.
     */
      public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
    
    
}
