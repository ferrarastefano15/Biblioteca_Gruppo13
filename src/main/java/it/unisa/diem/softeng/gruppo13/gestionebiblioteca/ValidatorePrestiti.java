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
 * @class ValidatorePrestiti
 * @brief Classe responsabile della validazione dei dati di un prestito.
 * 
 * La classe `ValidatorePrestiti` si occupa di verificare la correttezza dei dati di 
 * un oggetto `Prestito`. Controlla che i campi obbligatori siano presenti e che 
 * rispettino i vincoli del sistema.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class ValidatorePrestiti {
    
    /** @brief Numero massimo di prestiti attivi consentiti per ciascun utente */
    private static final int MAX_PRESTITI = 3;
    
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
     * ha superato il numero massimo di prestiti consentiti.
     */
    public void validaPrestito(Utente utente, Libro libro, LocalDate scadenza, List<Prestito> prestitiAttuali) throws Exception {
        
        if (utente == null || libro == null || scadenza == null) {
            throw new IllegalArgumentException("I dati del prestito non possono essere nulli.");
        }
        
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
            throw new Exception("L'utente ha raggiunto il limite massimo di " + MAX_PRESTITI + " prestiti.");
        }     
    }
    
}
