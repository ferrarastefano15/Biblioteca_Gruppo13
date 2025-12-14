/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;

/**
 * @class ValidatoreUtenti
 * @brief Classe responsabile della validazione dei dati di un utente.
 * 
 * La classe `ValidatoreUtente` si occupa di verificare la correttezza dei dati di 
 * un oggetto `Utente`. Controlla che i campi obbligatori siano presenti e che 
 * rispettino i vincoli del sistema.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class ValidatoreUtenti {
    
    /**
     * @brief Verifica la validità e la coerenza dei dati di un utente.
     * 
     * Questo metodo esegue un controllo sull'utente fornito per assicurarsi
     * che tutti i campi siano presenti e conformi ai requisiti del sistema prima 
     * dell'elaborazione.
     * 
     * @param[in] utente Utente da sottoporre a validazione.
     * @throws IllegalArgumentException Se uno o più campi del libro non rispettano
     *                                  i vincoli richiesti.
     */
    public void validaUtente(Utente utente) {
        
        if (utente == null) {
            throw new IllegalArgumentException("Utente nullo.");
        }
        
        if (utente.getNome() == null || utente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome obbligatorio.");
        }
        
        if (!utente.getNome().trim().matches("^[a-zA-Z\\s'-]+$")) {
            throw new IllegalArgumentException("Il nome non può contenere numeri.");
        }
        
        if (utente.getCognome() == null || utente.getCognome().trim().isEmpty()) {
            throw new IllegalArgumentException("Cognome obbligatorio.");
        }
        
        if (!utente.getCognome().trim().matches("^[a-zA-Z\\s'-]+$")) {
            throw new IllegalArgumentException("Il cognome non può contenere numeri.");
        }
        
        if (utente.getMatricola() == null || utente.getMatricola().trim().isEmpty()) {
            throw new IllegalArgumentException("Matricola obbligatoria.");  
        }
        
        if (utente.getEmail() == null || utente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email obbligatoria.");  
        }
        
        String email = utente.getEmail().trim();
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email non valida");
        }

        
    }
    
}
