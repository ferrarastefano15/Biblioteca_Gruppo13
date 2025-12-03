/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.elementi;

import java.util.List;

/**
 * @class  Libro
 * @brief  Rappresenta un libro all'interno del sistema di gestione della biblioteca
 * La classe Libro incapsula tutte le informazioni fondamentali di un libro:
 * titolo, autore, codice ISBN, anno di pubblicazione, numero di pagine e altri
 * dati rilevanti. Serve per creare, memorizzare e gestire oggetti libro nel sistema,
 * permettendo operazioni di creazione, accesso e rappresentazione dei dati del libro.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class Libro {
    
    /** @brief Titolo del libro */
    private String titolo;
    
   /** @brief Autore del libro*/
    private List<String> autori;
   
    /** @brief Anno di pubblicazione del libro*/
    private int anno;
    
    /** @brief Codice univoco del libro */
    private String isbn;

    /** @brief Numero di copie disponibili */
    private int copieDisponibili;

    
     /**
     * @brief Costuttore del nuovo oggetto Libro.
     *
     * @param titolo Titolo da assegnare al libro.
     * @param autori Autore del libro.
     * @param isbn Codice ISBN univoco del libro.
     * @param anno Anno in cui il libro è stato pubblicato.
     * @param copieDisponibili Numero totale di pagine del libro.
     */

      public Libro(String titolo, List<String> autori, int anno, String isbn, int copieDisponibili) {
        this.titolo = titolo;
        this.autori = autori;
        this.anno = anno;
        this.isbn = isbn;
        this.copieDisponibili = copieDisponibili;
    }
    
    /**
     * @brief Restituisce il titolo del libro.
     * @return Il titolo del libro come stringa.
     */
     public String getTitolo() {
        return titolo;
    }
     

    /**
     * @brief Restituisce l'autore del libro.
     * @return Il nome dell'autore come stringa.
     */
        public List<String> getAutori() {
            return autori;
        }
    

    /**
     * @brief Restituisce l’anno di pubblicazione del libro.
     * @return L’anno di pubblicazione come intero.
     */
        public int getAnno() {
            return anno;
        }
   

    /**
     * @brief Restituisce il codice ISBN del libro.
     * @return Il codice ISBN come stringa.
     */
        public String getIsbn() {
            return isbn;
        }


     /**
     * @brief Restituisce il numero di copie disponibili del libro.
     * @return Numero di copie disponibili come intero.
     */
        public int getCopieDisponibili() {
            return copieDisponibili;
        }
    
    
     /**
     * @brief Imposta il titolo del libro.
     * 
     * Questo metodo imposta il titolo del libro e restituisce il nuovo titolo.
     * @return Il titolo del libro.
     */ 
        public String setTitolo(){
            return this.titolo=titolo;
        }
    
        
     /**
     * @brief Imposta gli autori del libro.
     * 
     * Questo metodo imposta la lista degli autori del libro e restituisce la lista aggiornata.
     * @return La lista degli autori del libro.
     */
         public List<String> setAutori() {
            return this.autori=autori;
        }
    
     /**
     * @brief Imposta l'anno di pubblicazione del libro.
     * 
     * Questo metodo imposta l'anno di pubblicazione del libro e restituisce l'anno.
     * @return L'anno di pubblicazione del libro.
     */

         public int setAnno() {
                return this.anno=anno;
            }
    
    
     /**
     * @brief Imposta il codice ISBN del libro.
     * 
     * Questo metodo imposta il codice ISBN del libro e restituisce il codice ISBN.
     * @return Il codice ISBN del libro.
     */
        public String setIsbn() {
                return this.isbn=isbn;
            }
    
   

     /**
     * @brief Imposta il numero di copie disponibili del libro.
     * 
     * Questo metodo imposta il numero di copie disponibili del libro e restituisce il nuovo numero di copie disponibili.
     * @return Il numero di copie disponibili del libro.
     */
        public int setCopieDisponibili() {
               return this.copieDisponibili=copieDisponibili;
           }
    
     /**
     * @brief Confronta due oggetti libro per determinare se sono uguali.
     * 
     * Questo metodo è stato sovrascritto per comparare un libro con un altro oggetto.
     * In questa versione, ritorna sempre `false`, indicando che l'oggetto libro non 
     * è mai uguale a un altro oggetto.
     *
     * @param o Oggetto da confrontare con il libro.
     * @return `false` (modificato per un confronto di esempio).
     */   
        @Override
            public boolean equals(Object o){
                return false;
            }
    

     /**
     * @brief Decrementa il numero di copie disponibili del libro di una unità.
     * 
     * Questo metodo riduce il numero di copie disponibili di un libro di una unità,
     * indicando che una copia è stata presa in prestito.
     */
            public void decrementaCopie() { this.copieDisponibili--; }
    

     /**
     * @brief Incrementa il numero di copie disponibili del libro di una unità.
     * 
     * Questo metodo aumenta il numero di copie disponibili di un libro di una unità,
     * indicando che una copia è stata restituita.
     */

            public void incrementaCopie() { this.copieDisponibili++; }
    
    /**
     * @brief Restituisce una rappresentazione testuale del libro.
     *
     * @return Una stringa contenente titolo, autore, ISBN, anno di pubblicazione e numero di pagine.
     */
            @Override
            public String toString(){
                return "";
            }
    
}
