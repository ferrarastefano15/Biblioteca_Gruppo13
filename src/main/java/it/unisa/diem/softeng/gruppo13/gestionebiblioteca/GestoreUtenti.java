/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Stefano
 */
public class GestoreUtenti {

    /** @brief Lista degli utenti registrati nella biblioteca */    
    private List<Utente> utenti = new ArrayList<>();

    /**
     * @brief Restituisce la lista di tutti gli utenti della biblioteca.
     * 
     * @return Lista di utenti registrati nella biblioteca.
     */    
    public List<Utente> getUenti() { return utenti; }
    
    
    public void setUtenti(List<Utente> nuoviUtenti) { this.utenti = new ArrayList<>(nuoviUtenti); }

    /**
     * @brief Aggiunge un nuovo utente alla biblioteca.
     * 
     * Questo metodo consente di aggiungere un nuovo utente alla biblioteca, 
     * fornendo le informazioni necessarie. 
     * I dati vengono validati prima di procedere con l'aggiunta.
     * 
     * @param[in] utente Utente da aggiungere
     */    
    public void aggiungiUtente(Utente utente) {
    }

     /**
     * @brief Rimuove un utente dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un utente dalla biblioteca, 
     * eliminandolo dalla lista degli utenti registrati.
     * 
     * @param[in] utente Utente da rimuovere dalla biblioteca.
     */    
    public void rimuoviUtente(Utente utente) {
    }

    /**
     * @brief Cerca gli utenti in base a una query di ricerca.
     * 
     * Questo metodo cerca gli utenti che corrispondono alla query fornita e 
     * restituisce una lista di utenti che soddisfano i criteri di ricerca.
     * 
     * @param[in] query Stringa di ricerca che rappresenta cognome o matricola di un utente.
     * @return Lista di utenti che corrispondono alla query.
     */    
    public List<Utente> cercaUtenti(String query) {
        return null;
    }

    
}
