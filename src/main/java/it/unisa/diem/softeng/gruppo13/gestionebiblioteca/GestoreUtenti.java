/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionedati.ComparatoreUtenti;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @class GestoreUtenti
 * @brief Implementa i metodi di 'Utente'.
 * 
 * La classe 'GestoreUtenti' serve a gestire gli utenti della bilbioteca, passandogli
 * la lista degli utenti e implementando i metodi per aggiungere, rimuovere e cercare
 * gli utenti della biblioteca.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreUtenti {

    /** @brief Lista degli utenti registrati nella biblioteca */    
    private List<Utente> utenti = new ArrayList<>();

    /**
     * @brief Restituisce la lista di tutti gli utenti della biblioteca.
     * 
     * @return Lista di utenti registrati nella biblioteca.
     */    
    public List<Utente> getUtenti() { return utenti; }
    
    
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
        
        if(utente==null) return ;
        
        validaUtente(utente);
        
        for (Utente u : utenti) {
            if (u.getMatricola().equalsIgnoreCase(utente.getMatricola())) {
                throw new IllegalArgumentException("Matricola già esistente.");
            }
        }
        
        utenti.add(utente);
    }   
    
    /**
     * @brief  Modifica le informazioni di un utente della biblioteca.
     * 
     * Questo metodo individua l'utente originale nel sistema e ne sostituisce 
     * le informazioni con i nuovi dati forniti. 
     * 
     * @param[in] utente1 Utente della bilbioteca da modificare.
     * @param[in] utente2 Utente modificato.
     */
    public void modificaUtente(Utente utente1, Utente utente2){
        
        if (utente1 == null || utente2 == null) {
        throw new IllegalArgumentException("Dati non validi.");
        }
    
        validaUtente(utente2);
    
        if (!utente1.getMatricola().equalsIgnoreCase(utente2.getMatricola())) {
            for (Utente u: utenti) {
                if (u!= utente1 && u.getMatricola().equalsIgnoreCase(utente2.getMatricola())) {
                    throw new IllegalArgumentException("Impossibile modificare: la matricola esiste già per un altro utente.");
                }
            }
        }

  
        utente1.setCognome(utente2.getCognome());
        utente1.setNome(utente2.getNome());
        utente1.setMatricola(utente2.getMatricola());
        utente1.setEmail(utente2.getEmail());
    
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
        
        utenti.remove(utente);
        
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
     
        String q = (query == null) ? "" : query.toLowerCase();

        List<Utente> risultati = new ArrayList<>();

        for (Utente u : utenti) {
        
            boolean matchNome = u.getNome() != null && u.getNome().toLowerCase().contains(q);
        
            boolean matchCognome = u.getCognome()!= null && u.getCognome().toLowerCase().contains(q);
        
            boolean matchMatricola = u.getMatricola() != null && u.getMatricola().toLowerCase().contains(q);

            if (matchNome || matchCognome || matchMatricola) {
                risultati.add(u);
            }
        }
        
        risultati.sort(new ComparatoreUtenti());

        return risultati;        
        
    }

    /**
     * @brief Verifica la validità e la coerenza dei dati di un utente.
     * 
     * Questo metodo esegue un controllo sull'utente fornito per assicurarsi
     * che tutti i campi siano presenti e conformi ai requisiti del sistema prima 
     * dell'elaborazione.
     * 
     * @param[in] utente Utente da sottoporre a validazione.
     */
    private void validaUtente(Utente utente) {
        
        if (utente == null) throw new IllegalArgumentException("Utente nullo.");
        
        if (utente.getNome() == null || utente.getNome().isEmpty()) 
            throw new IllegalArgumentException("Nome obbligatorio.");

        if (utente.getCognome() == null || utente.getCognome().isEmpty()) 
            throw new IllegalArgumentException("Cognome obbligatorio.");

        if (utente.getMatricola() == null || utente.getMatricola().isEmpty()) 
            throw new IllegalArgumentException("Matricola obbligatoria.");  
        
        if (utente.getEmail() == null || utente.getEmail().isEmpty()) 
            throw new IllegalArgumentException("Email obbligatoria.");  
        
    }
}
