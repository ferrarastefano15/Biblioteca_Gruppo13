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
 * La classe GestorePrestiti implementa l'interfaccia InterfacciaGestorePrestiti
 * passandogli la lista dei prestiti e implementando i metodi per aggiungere, 
 * rimuovere e ordinare i prestiti della biblioteca.
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
     * @see InterfacciaGestorePrestiti.getPrestiti
     */    
    @Override
    public List<Prestito> getPrestiti() { 
        return prestiti; 
    }

    
    /**
     * @brief Aggiunge un nuovo prestito.
     * 
     * @see InterfacciaGestorePrestiti.aggiungiPrestito
     */
    @Override
    public void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza) throws Exception {
        
        if (utente == null || libro == null || scadenza == null) {
            throw new IllegalArgumentException("Dati prestito incompleti.");
        }

        validaPrestito(utente, libro, scadenza, prestiti); 

        libro.decrementaCopie();

        Prestito p = new Prestito(libro, utente, scadenza);
        prestiti.add(p);
    }

    /**
     * @brief Restituisce un libro preso in prestito.
     * 
     * @see InterfacciaGestorePrestiti.restituisciLibro
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
     * @see InterfacciaGestorePrestiti.haprestitiAttivi
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
     * @see InterfacciaGestorePrestiti.haPrestitiAttivi
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
     * @see InterfacciaGestorePrestiti.getOrdinati
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
     * @param[in] scadenza Data prevista per la restituzione
     * 
     * @throws Exception Se il libro non ha copie disponibili o se l'utente
     *                   ha superato il numero massimo di prestiti consentiti.
     */
    private void validaPrestito(Utente utente, Libro libro, LocalDate scadenza, List<Prestito> prestitiAttuali) throws Exception {
        
        if (scadenza.isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("La data di scadenza non può essere antecedente alla data odierna.");
        }
        
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
