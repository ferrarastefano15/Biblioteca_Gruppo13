/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.dati;

import java.time.LocalDate;

/**
 * @class Prestito
 * @brief Rappresenta un prestito di un libro a un utente.
 * 
 * La classe `Prestito` memorizza e gestisce le informazioni dei prestiti.
 * @author Daniel, Andrea, Stefano, Daniele
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
     * @param[in] libro Il libro che viene preso in prestito.
     * @param[in] utente L'utente che prende in prestito il libro.
     * @param[in] dataRestituzione La data di restituzione prevista per il libro.
     */
        public Prestito(Libro libro, Utente utente, LocalDate dataRestituzione) {
            this.libro = libro;
            this.utente = utente;
            this.dataRestituzione = dataRestituzione;
        }

    
     /**
     * @brief Restituisce il libro preso in prestito.
     * @return Il libro preso in prestito.
     */
         public Libro getLibro() { return libro; }


    /**
     * @brief Restituisce l'utente che ha preso in prestito il libro.
     * @return L'utente che ha preso in prestito il libro.
     */
         public Utente getUtente() { return utente; }
    
    /**
     * @brief Restituisce la data di restituzione del libro.
     * @return La data di restituzione del libro.
     */
         public LocalDate getDataRestituzione() { return dataRestituzione; }
    
}
