/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.time.LocalDate;
import java.util.List;

/**
 * @brief Interfaccia per la gestione dei prestiti della biblioteca.
 * 
 * Questa interfaccia definisce le operazioni fondamentali per la gestione
 * dei prestiti: creazione di nuovi prestiti, restituzione dei libri,
 * verifica di prestiti attivi.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public interface InterfacciaGestorePrestiti {
    
    /**
     * @brief Restituisce la lista di tutti i prestiti attivi.
     * 
     * @return Lista di prestiti attivi nella biblioteca.
     */
    List<Prestito> getPrestiti();
    
    /**
     * @brief Aggiunge un nuovo prestito alla biblioteca.
     * 
     * Registra un nuovo prestito associando un utente a un libro
     * e impostando una data di scadenza per la restituzione.
     * 
     * @param[in] utente Utente che prende in prestito il libro.
     * @param[in] libro Libro che viene preso in prestito.
     * @param[in] scadenza Data di restituzione del libro.
     * 
     * @throws Exception Se i dati non sono validi, se il libro non è disponibile
     * o se l'utente ha raggiunto il numero massimo di prestiti consentiti.
     */
    void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza) throws Exception;
    
    /**
     * @brief Restituisce un libro precedentemente preso in prestito.
     * 
     * Questo metodo rimuove il prestito dal sistema e rende nuovamente
     * disponibile una copia del libro.
     * 
     * @param[in] prestito Prestito da restituire.
     */
    void restituisciLibro(Prestito prestito);
    
    /**
     * @brief Verifica se un libro è coinvolto in prestiti attivi.
     * 
     * Questo metodo viene utilizzato per impedire l'eliminazione di un libro
     * che risulta attualmente in prestito.
     * 
     * @param[in] l Libro da controllare.
     * @return 'true' se il libro è presente in almeno un prestito attivo;
     * 'false' altrimenti.
     */
    boolean haPrestitiAttivi(Libro l);
    
    /**
     * @brief Verifica se un utente è coinvolto in prestiti attivi.
     * 
     * Questo metodo viene utilizzato per impedire l'eliminazione di un utente
     * che risulta attualmente coinvolto in uno o più prestiti.
     * 
     * @param[in] u Utente da controllare.
     * @return 'true' se l'utente è presente in almeno un prestito attivo;
     * 'false' altrimenti.
     */
    boolean haPrestitiAttivi(Utente u);
    
    /**
     * @brief Restituisce la lista dei prestiti ordinata per data di scadenza.
     * 
     * La lista restituita è ordinata in base alla data prevista di restituzione
     * del libro.
     * 
     * @return Lista di prestiti ordinata per data di scadenza.
     */
    List<Prestito> getOrdinati();
}
