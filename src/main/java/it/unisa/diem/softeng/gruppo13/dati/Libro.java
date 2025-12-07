/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.dati;

import java.util.List;

/**
 * @class  Libro
 * @brief  Rappresenta un libro della biblioteca
 * 
 * La classe `Libro` memorizza le informazioni di un libro e permette di 
 * gestire questi dati.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class Libro {
    
    /** @brief Titolo del libro */
    private String titolo;
    
   /** @brief Autori del libro*/
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
     * @param[in] titolo Titolo da assegnare al libro.
     * @param[in] autori Autori del libro.
     * @param[in] isbn Codice ISBN univoco del libro.
     * @param[in] anno Anno in cui il libro è stato pubblicato.
     * @param[in] copieDisponibili Numero totale di pagine del libro.
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
     * @return Il titolo del libro.
     */
     public String getTitolo() {
        return titolo;
    }
     

    /**
     * @brief Restituisce gli autori del libro.
     * @return I nomi degli autori.
     */
        public List<String> getAutori() {
            return autori;
        }
    

    /**
     * @brief Restituisce l’anno di pubblicazione del libro.
     * @return L’anno di pubblicazione.
     */
        public int getAnno() {
            return anno;
        }
   

    /**
     * @brief Restituisce il codice ISBN del libro.
     * @return Il codice ISBN.
     */
        public String getIsbn() {
            return isbn;
        }


     /**
     * @brief Restituisce il numero di copie disponibili del libro.
     * @return Numero di copie disponibil.
     */
        public int getCopieDisponibili() {
            return copieDisponibili;
        }
    
    
     /**
     * @brief Imposta il titolo del libro.
     * @param[in] titolo Il titolo del libro.
     */ 
        public void setTitolo(String titolo){
            this.titolo=titolo;
        }
    
        
     /**
     * @brief Imposta gli autori del libro.
     * @param[in] autori La lista degli autori del libro.
     */
         public void setAutori(List<String> autori) {
            this.autori=autori;
        }
    
     /**
     * @brief Imposta l'anno di pubblicazione del libro.
     * @param[in] anno L'anno di pubblicazione del libro.
     */

         public void setAnno(int anno) {
                this.anno=anno;
            }
    
    
     /**
     * @brief Imposta il codice ISBN del libro.
     * @param[in] isbn Il codice ISBN del libro.
     */
        public void setIsbn(String isbn) {
                this.isbn=isbn;
            }
    
   

     /**
     * @brief Imposta il numero di copie disponibili del libro.
     * @param[in] copieDisponibili Il numero di copie disponibili del libro.
     */
        public void setCopieDisponibili(int copieDisponibili) {
               this.copieDisponibili=copieDisponibili;
           }
    
     /**
     * @brief Confronta due oggetti libro per determinare se sono uguali.
     * 
     * @param[in] o Oggetto da confrontare con il libro.
     * @return 'true' se gli utenti sono uguali, `false` altrimenti
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
     * 
     * @invariant Il numero di copie disponibili non può essere minore di zero.
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
     * @return Una stringa contenente titolo, autore, ISBN, anno di pubblicazione.
     */
            @Override
            public String toString(){
                return "";
            }
    
}
