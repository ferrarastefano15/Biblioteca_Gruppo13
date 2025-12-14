/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.util.List;

/**
 * @brief Interfaccia per la gestione degli utenti della biblioteca.
 * 
 * Questa interfaccia definisce le operazioni fondamentali per la gestione
 * degli utenti registrati nel sistema: inserimento, modifica, rimozione
 * e ricerca degli utenti.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public interface InterfacciaGestoreUtenti {
    
    /**
     * @brief Restituisce la lista di tutti gli utenti registrati.
     * 
     * @return Lista di utenti presenti nel sistema.
     */
    List<Utente> getUtenti();
             
    /**
     * @brief Aggiunge un nuovo utente alla biblioteca.
     * 
     * L'utente viene inserito nel sistema solo se i dati sono validi
     * e se non esiste già un utente con la stessa matricola.
     * 
     * @param[in] utente Utente da aggiungere.
     */
    void aggiungiUtente(Utente utente);

    /**
     * @brief Rimuove un utente dal sistema.
     * 
     * Questo metodo elimina l'utente dalla lista degli utenti registrati.
     * 
     * @param[in] utente Utente da rimuovere.
     */
    void rimuoviUtente(Utente utente);

    /**
     * @brief Modifica i dati di un utente esistente.
     * 
     * Sostituisce le informazioni dell'utente presente nel sistema
     * con i nuovi dati forniti.
     * 
     * @param[in] vecchio Utente presente nel sistema da modificare.
     * @param[in] nuovo Nuovi dati dell'utente.
     * 
     */
    void modificaUtente(Utente vecchio, Utente nuovo);

    /**
     * @brief Cerca gli utenti in base a una query di ricerca.
     * 
     * La ricerca viene effettuata su nome, cognome e matricola.
     * 
     * @param[in] query Stringa di ricerca.
     * @return Lista di utenti che soddisfano i criteri di ricerca.
     */
    List<Utente> cercaUtente(String query);  
}