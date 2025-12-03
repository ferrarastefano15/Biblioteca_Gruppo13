/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.logica;

import it.unisa.diem.softeng.gruppo13.elementi.Libro;
import it.unisa.diem.softeng.gruppo13.elementi.Prestito;
import it.unisa.diem.softeng.gruppo13.elementi.Utente;
import java.time.LocalDate;
import java.util.List;

/**
 * @interface InterfacciaBiblioteca
 * @brief Definisce le operazioni di gestione di una biblioteca.
 * 
 * L'interfaccia `InterfacciaBiblioteca` fornisce i metodi necessari per la gestione di una biblioteca, 
 * incluse le operazioni per la gestione di libri, utenti e prestiti.
 * Le classi che implementano questa interfaccia devono fornire le implementazioni per aggiungere, 
 * cercare, rimuovere e restituire libri e utenti, nonché salvare i dati e gestire i prestiti.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */

  
  public interface InterfacciaBiblioteca {
    
    /**
     * @brief Restituisce la lista di tutti i libri presenti nella biblioteca.
     * 
     * Questo metodo deve restituire una lista contenente tutti i libri registrati nella biblioteca.
     * 
     * @return Lista di oggetti `Libro` presenti nella biblioteca.
     */
       List<Libro> getLibri();

     /**
     * @brief Restituisce la lista di tutti gli utenti registrati nella biblioteca.
     * 
     * Questo metodo deve restituire una lista contenente tutti gli utenti registrati nella biblioteca.
     * 
     * @return Lista di oggetti `Utente` registrati nella biblioteca.
     */
       List<Utente> getUtenti();

    /**
     * @brief Restituisce la lista di tutti i prestiti attivi nella biblioteca.
     * 
     * Questo metodo deve restituire una lista contenente tutti i prestiti attivi nella biblioteca.
     * 
     * @return Lista di oggetti `Prestito` attivi nella biblioteca.
     */
       List<Prestito> getPrestiti();
    
    
     /**
     * @brief Aggiunge un nuovo libro alla biblioteca.
     * 
     * Questo metodo consente di aggiungere un nuovo libro alla biblioteca, specificando le informazioni 
     * come il titolo, gli autori, l'anno di pubblicazione, il codice ISBN e il numero di copie disponibili.
     * 
     * @param titolo Titolo del libro da aggiungere.
     * @param autori Autori del libro.
     * @param anno Anno di pubblicazione del libro.
     * @param isbn Codice ISBN del libro.
     * @param copie Numero di copie disponibili del libro.
     * @throws Exception Se i dati forniti non sono validi.
     */
      void aggiungiLibro(String titolo, String autori, String anno, String isbn, String copie) throws Exception;

     /**
     * @brief Aggiunge un nuovo utente alla biblioteca.
     * 
     * Questo metodo consente di aggiungere un nuovo utente alla biblioteca, fornendo i dati dell'utente 
     * come nome, cognome, matricola e indirizzo email.
     * 
     * @param nome Nome dell'utente da aggiungere.
     * @param cognome Cognome dell'utente da aggiungere.
     * @param matricola Matricola identificativa dell'utente.
     * @param email Indirizzo email dell'utente.
     * @throws Exception Se i dati forniti non sono validi.
     */
      void aggiungiUtente(String nome, String cognome, String matricola, String email) throws Exception;

    /**
     * @brief Aggiunge un nuovo prestito.
     * 
     * Questo metodo consente di registrare un nuovo prestito, associando un utente a un libro con una data di restituzione.
     * 
     * @param u Utente che prende in prestito il libro.
     * @param l Libro che viene preso in prestito.
     * @param data Data di restituzione del libro.
     * @throws Exception Se i dati forniti non sono validi.
     */
      void aggiungiPrestito(Utente u, Libro l, LocalDate data) throws Exception;
    
     
    /**
     * @brief Cerca i libri in base a una query di ricerca.
     * 
     * Questo metodo consente di cercare i libri che corrispondono alla query fornita e restituisce una lista di libri che soddisfano 
     * i criteri di ricerca.
     * 
     * @param query Stringa di ricerca per trovare i libri.
     * @return Lista di libri che corrispondono alla query di ricerca.
     */
      List<Libro> cercaLibri(String query);

    /**
     * @brief Cerca gli utenti in base a una query di ricerca.
     * 
     * Questo metodo consente di cercare gli utenti che corrispondono alla query fornita e restituisce una lista di utenti che soddisfano 
     * i criteri di ricerca.
     * 
     * @param query Stringa di ricerca per trovare gli utenti.
     * @return Lista di utenti che corrispondono alla query di ricerca.
     */
      List<Utente> cercaUtenti(String query);

    
     /**
     * @brief Rimuove un libro dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un libro dalla biblioteca, eliminandolo dalla lista dei libri disponibili.
     * 
     * @param l Libro da rimuovere dalla biblioteca.
     */
     void rimuoviLibro(Libro l);

    /**
     * @brief Rimuove un utente dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un utente dalla biblioteca, eliminandolo dalla lista degli utenti registrati.
     * 
     * @param u Utente da rimuovere dalla biblioteca.
     */
     void rimuoviUtente(Utente u);

    /**
     * @brief Restituisce un libro preso in prestito.
     * 
     * Questo metodo consente di restituire un libro preso in prestito, aggiornando lo stato del prestito.
     * 
     * @param p Prestito da restituire.
     */
     void restituisciLibro(Prestito p);


     /**
     * @brief Salva tutti i dati della biblioteca.
     * 
     * Questo metodo consente di salvare tutte le informazioni riguardanti i libri, gli utenti e i prestiti 
     * della biblioteca.
     */
     void salvaTutto();
  
}
