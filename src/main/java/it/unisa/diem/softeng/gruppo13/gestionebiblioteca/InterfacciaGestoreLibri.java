/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.List;

/**
 * @brief Interfaccia per la gestione dei libri della biblioteca.
 * 
 * Questa interfaccia definisce i metodi fondamentali per la gestione
 * dei libri all'interno del sistema: inserimento, modifica, rimozione
 * e ricerca dei libri presenti in catalogo.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public interface InterfacciaGestoreLibri {
    
    /**
     * @brief Restituisce la lista di tutti i libri presenti nella biblioteca.
     * 
     * @return Lista di libri presenti nel catalogo.
     */
    List<Libro> getLibri();
    
    /**
     * @brief Aggiunge un nuovo libro alla biblioteca.
     * 
     * Il libro viene inserito nel catalogo solo se i dati sono validi
     * e l'ISBN non è già presente nel sistema.
     * 
     * @param[in] libro Libro da aggiungere.
     */
    void aggiungiLibro(Libro libro);
    
    /**
     * @brief Modifica le informazioni di un libro esistente.
     * 
     * Questo metodo aggiorna i dati di un libro già presente nel catalogo
     * sostituendoli con quelli forniti.
     * 
     * @param[in] libro1 Libro presente nel sistema da modificare.
     * @param[in] libro2 Nuovi dati del libro.
     */
    void modificaLibro(Libro libro1, Libro libro2);
    
    /**
     * @brief Rimuove un libro dalla biblioteca.
     * 
     * Il libro viene eliminato dal catalogo dei libri disponibili.
     * 
     * @param[in] libro Libro da rimuovere.
     */
    void rimuoviLibro(Libro libro);
    
    /**
     * @brief Cerca i libri in base a una query di ricerca.
     * 
     * La ricerca viene effettuata su titolo, autore e ISBN.
     * 
     * @param[in] query Stringa di ricerca.
     * @return Lista ordinata di libri che soddisfano i criteri di ricerca.
     */
    List<Libro> cercaLibro(String query);
}
