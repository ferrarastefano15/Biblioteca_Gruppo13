/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.List;

/**
 * @class ValidatorePrestito
 * @brief Gestitsce la logica di validazione per l'aggiunta di nuovi prestiti.
 * 
 * Questa classe controlla se un utente ha i prerequisiti per la validazione di un
 * nuovo prestito, inizializzando la costante MAX_PRESTITI.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class ValidatorePrestito {
    
    /** @brief Costante che indica il numero massimo di prestiti attivi per ogni utente*/
    private static final int MAX_PRESTITI = 3;

    /**
     * @brief Verifica la validità di un prestito.
     * 
     * Questo metodo controlla se i prerequisiti per la validazione di un nuovo prestito
     * sono soddisfatti, verifica se l'utente ha meno di 3 presiti attivi e se il
     * libro ha almeno una copia disponibile.
     * 
     * @param[in] utente Utente che richiede il prestito.
     * @param[in] libro Libro che viene preso in prestito.
     * @param[in] prestitiAttuali Lista di prestiti attivi dell'utente.
     */
    public void valida(Utente utente, Libro libro, List<Prestito> prestitiAttuali) throws Exception {
    }

}
