/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.ComparatorePrestiti;
import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @class GestorePrestiti
 * @brief Implementa i metodi di 'Prestito'.
 * 
 * La classe {@code GestorePrestiti} implementa l'interfaccia
 * {@code InterfacciaGestorePrestiti} passandogli
 * la lista dei prestiti e implementando i metodi per aggiungere, rimuovere e ordinare
 * i prestiti della biblioteca. Controlla che i prerequisiti per la creazione
 * del prestito siano soddisfatti.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestorePrestiti implements InterfacciaGestorePrestiti{
    
    /** @brief Numero massimo di prestiti attivi consentiti per ciascun utente */
    private static final int MAX_PRESTITI = 3;    

    /** @brief Lista dei prestiti attivi nella biblioteca */    
    private List<Prestito> prestiti = new ArrayList<>();

    /**
     * @brief Restituisce la lista di tutti i prestiti attivi.
     * 
     * @return Lista di prestiti attivi nella biblioteca.
     */    
    @Override
    public List<Prestito> getPrestiti() { 
        return prestiti; 
    }
    
    /**
     * @brief Imposta la lista dei prestiti.
     * 
     * Questo metodo viene utilizzato principalmente durante il caricamento
     * dei dati da una sorgente esterna (es. file).
     * 
     * @param[in] nuoviPrestiti Lista dei prestiti da impostare.
     * 
     * @post La lista interna dei prestiti viene sovrascritta con una nuova copia
     *       della lista fornita.
     */
    public void setPrestiti(List<Prestito> nuoviPrestiti) { 
        this.prestiti = new ArrayList<>(nuoviPrestiti); 
    }
    
    /**
     * @brief Aggiunge un nuovo prestito.
     * 
     * Questo metodo consente di registrare un nuovo prestito,
     * associando un utente a un libro con una data di restituzione.
     * 
     * @param[in] utente Utente che prende in prestito il libro.
     * @param[in] libro Libro che viene preso in prestito.
     * @param[in] scadenza Data di restituzione del libro.
     * 
     * @throws IllegalArgumentException Se uno dei parametri è nullo.
     * @throws Exception Se il libro non ha copie disponibili o se l'utente
     *                   ha raggiunto il numero massimo di prestiti consentiti.
     * 
     * @post Il prestito viene aggiunto alla lista dei prestiti attivi
     *       e il numero di copie disponibili del libro viene decrementato.
     */
    @Override
    public void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza) throws Exception {
        
        if (utente == null || libro == null || scadenza == null) {
            throw new IllegalArgumentException("Dati prestito incompleti.");
        }

        validaPrestito(utente, libro, prestiti); 

        libro.decrementaCopie();

        Prestito p = new Prestito(libro, utente, scadenza);
        prestiti.add(p);
    }

    /**
     * @brief Restituisce un libro preso in prestito.
     * 
     * Questo metodo consente di restituire un libro preso in prestito,
     * rimuovendo il prestito dal sistema e incrementando il numero
     * di copie disponibili del libro.
     * 
     * @param[in] prestito Prestito da restituire.
     * 
     * @post Il prestito viene rimosso dalla lista dei prestiti
     *       e la copia del libro viene resa nuovamente disponibile.
     */
    @Override
    public void restituisciLibro(Prestito prestito) {
        
        if (prestito != null && prestiti.remove(prestito)) {
            prestito.getLibro().incrementaCopie(); 
        }
    }
    
    /**
     * @brief Verifica se un libro è coinvolto in prestiti attivi.
     *
     * Questo metodo serve per controllare se un libro è coinvolto
     * in un prestito prima di consentirne l'eliminazione.
     *
     * @param[in] l Libro da controllare.
     * @return {@code true} se il libro è presente in almeno un prestito attivo,
     *         {@code false} altrimenti.
     */    
    @Override
    public boolean haPrestitiAttivi(Libro l) {

        if (l == null) return false;
        for (Prestito p : prestiti) {
            if (p.getLibro().equals(l)) return true; 
        }
        return false;
    }
    
    /**
     * @brief Verifica se un utente è coinvolto in prestiti attivi.
     *
     * Questo metodo serve per controllare se un utente è coinvolto
     * in un prestito prima di consentirne l'eliminazione.
     *
     * @param[in] u Utente da controllare.
     * @return {@code true} se l'utente è presente in almeno un prestito attivo,
     *         {@code false} altrimenti.
     */
    @Override
    public boolean haPrestitiAttivi(Utente u) {
        
        if (u == null) return false;
        for (Prestito p : prestiti) {
            if (p.getUtente().equals(u)) return true; 
        }
        return false;
    }

    /**
     * @brief Restituisce la lista dei prestiti ordinata per data di scadenza.
     *
     * La lista originale non viene modificata.
     *
     * @return Lista dei prestiti ordinata per data prevista di restituzione.
     */    
    @Override
    public List<Prestito> getOrdinati() {
        
        List<Prestito> listaOrdinabile = new ArrayList<>(this.prestiti);
        listaOrdinabile.sort(new ComparatorePrestiti());
        return listaOrdinabile;
    }
    
    /**
     * @brief Verifica la validità di un prestito.
     * 
     * Questo metodo controlla il rispetto dei vincoli di dominio:
     * disponibilità delle copie del libro e numero massimo di prestiti
     * consentiti per l'utente.
     * 
     * @param[in] utente Utente che richiede il prestito.
     * @param[in] libro Libro che viene preso in prestito.
     * @param[in] prestitiAttuali Lista dei prestiti attivi.
     * 
     * @throws Exception Se il libro non ha copie disponibili o se l'utente
     *                   ha superato il numero massimo di prestiti consentiti.
     */
    private void validaPrestito(Utente utente, Libro libro, List<Prestito> prestitiAttuali) throws Exception {
        
        if (libro.getCopieDisponibili() <= 0) { 
            throw new Exception("Copie non disponibili per il libro: " + libro.getTitolo());
        }

        long prestitiUtente = 0;
        for (Prestito p : prestitiAttuali) {
            if (p.getUtente().equals(utente)) {
                prestitiUtente++;
            }
        }

        if (prestitiUtente >= MAX_PRESTITI) {
            throw new Exception(
                "L'utente ha raggiunto il limite massimo di " + MAX_PRESTITI + " prestiti."
            );
        }
    }
    
    
}
