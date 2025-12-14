/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;

/**
 * @class ValidatoreLibri
 * @brief Classe responsabile della validazione dei dati di un libro.
 * 
 * La classe `ValidatoreLibri` si occupa di verificare la correttezza dei dati di 
 * un oggetto `Libro`. Controlla che i campi obbligatori siano presenti e che 
 * rispettino i vincoli del sistema.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class ValidatoreLibri {
    
    /**
     * @brief Verifica la validità e la coerenza dei dati di un libro.
     * 
     * Questo metodo esegue un controllo sul libro fornito per assicurarsi
     * che tutti i campi siano presenti e conformi ai requisiti del sistema
     * prima dell'elaborazione.
     * 
     * @param[in] libro Libro da sottoporre a validazione.
     * 
     * @throws IllegalArgumentException Se uno o più campi del libro non rispettano
     * i vincoli richiesti.
     */
    public void validaLibro(Libro libro) {
        
        if(libro == null) {
            throw new IllegalArgumentException("Libro nullo");
        }
        
        if (libro.getTitolo() == null || libro.getTitolo().trim().isEmpty()) {
            throw new IllegalArgumentException("Il titolo è obbligatorio.");
        }
        
        if (libro.getAutori() == null || libro.getAutori().isEmpty()) {
            throw new IllegalArgumentException("Il libro deve avere almeno un autore.");
        }

        if (libro.getIsbn() == null || libro.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("L'ISBN è obbligatorio.");
        }
        
        if (!libro.getIsbn().matches("\\d{13}")) {
            throw new IllegalArgumentException("L'ISBN deve essere composto da 13 cifre numeriche.");
        }

        if (libro.getAnno() > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Anno futuro non valido.");
        }
        
        if (libro.getCopieDisponibili() < 1) {
            throw new IllegalArgumentException("Devi inserire almeno 1 copia.");
        }    
    }
    
}
