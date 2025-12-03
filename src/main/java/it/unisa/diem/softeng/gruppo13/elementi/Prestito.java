/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.elementi;

import java.time.LocalDate;

/**
 * @class Prestito
 * @brief Rappresenta un prestito di un libro a un utente.
 * 
 * La classe `Prestito` gestisce l'associazione tra un libro, un utente e la data di restituzione del libro.
 * Essa permette di tenere traccia dei prestiti effettuati, indicando quale utente ha preso in prestito quale libro 
 * e quando il libro deve essere restituito.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class Prestito {
    
    /** @brief Il libro preso in prestito */
    private Libro libro;

    /** @brief L'utente che ha preso in prestito il libro */
    private Utente utente;

    /** @brief La data entro cui il libro deve essere restituito */
    private LocalDate dataRestituzione;


    /**
     * @brief Costruttore di un nuovo prestito.
     * 
     * Questo costruttore crea un oggetto `Prestito` associando un libro a un utente 
     * con una data di restituzione specifica.
     *
     * @param libro Il libro che viene preso in prestito.
     * @param utente L'utente che prende in prestito il libro.
     * @param dataRestituzione La data di restituzione prevista per il libro.
     */
        public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione) {
            this.libro = libro;
            this.utente = utente;
            this.dataRestituzione = dataRestituzione;
        }

    
     /**
     * @brief Restituisce il libro preso in prestito.
     * 
     * Questo metodo restituisce il libro che è stato preso in prestito nell'oggetto `Prestito`.
     * 
     * @return Il libro preso in prestito.
     */
         public Libro getLibro() { return libro; }


    /**
     * @brief Restituisce l'utente che ha preso in prestito il libro.
     * 
     * Questo metodo restituisce l'utente che ha preso in prestito il libro.
     * 
     * @return L'utente che ha preso in prestito il libro.
     */
         public Utente getUtente() { return utente; }
    
    /**
     * @brief Restituisce la data di restituzione del libro.
     * 
     * Questo metodo restituisce la data in cui il libro deve essere restituito.
     * 
     * @return La data di restituzione del libro.
     */
         public LocalDate getDataRestituzione() { return dataRestituzione; }
    
}
