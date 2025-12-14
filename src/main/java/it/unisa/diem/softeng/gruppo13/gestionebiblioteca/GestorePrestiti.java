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
      
    /** @brief Lista dei prestiti attivi nella biblioteca */    
    private List<Prestito> prestiti = new ArrayList<>();
    
    /** @brief Validatore dei prestiti della biblioteca*/
    private ValidatorePrestiti validatore = new ValidatorePrestiti();

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

        validatore.validaPrestito(utente, libro, scadenza, prestiti); 

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
    
}
