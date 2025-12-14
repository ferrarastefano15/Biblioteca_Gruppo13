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

/**
 * @class GestoreUtenti
 * @brief Implementa i metodi di 'Utente'.
 * 
 * La classe 'GestoreUtenti' serve a gestire gli utenti della bilbioteca, passandogli
 * la lista degli utenti e implementando i metodi per aggiungere, rimuovere e cercare
 * gli utenti della biblioteca.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreUtenti implements InterfacciaGestoreUtenti{

    /** @brief Lista degli utenti registrati nella biblioteca */    
    private List<Utente> utenti = new ArrayList<>();
    
    /** @brief Validatore degli utenti della biblioteca */
    private ValidatoreUtenti validatore = new ValidatoreUtenti();
    
    /**
     * @brief Restituisce la lista di tutti gli utenti della biblioteca.
     * 
     * @return Lista di utenti registrati nella biblioteca.
     */    
    @Override
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
    @Override
    public void aggiungiUtente(Utente utente) {
        
        if(utente==null) return ;
        
        validatore.validaUtente(utente);
        
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
     * @see InterfacciaGestoreUtenti.modificaUtente
     */
    @Override
    public void modificaUtente(Utente utente1, Utente utente2){
        
        if (utente1 == null || utente2 == null) {
        throw new IllegalArgumentException("Dati non validi.");
        }
    
        validatore.validaUtente(utente2);
    
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
     * @see InterfacciaGestoreUtenti.rimuoviUtente
     */ 
    @Override
    public void rimuoviUtente(Utente utente) {
        
        utenti.remove(utente);
        
    }

    /**
     * @brief Cerca gli utenti in base a una query di ricerca.
     * 
     * @see InterfacciaGestoreUtenti.cercaUtente
     */   
    @Override
    public List<Utente> cercaUtente(String query) {
     
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
    
}
