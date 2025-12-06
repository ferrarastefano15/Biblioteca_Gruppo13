/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.dati;

import java.util.List;

/**
 * @class Utente
 * @brief Rappresenta un utente della biblioteca.
 * 
 * La classe `Utente` memorizza le informazioni di un utente e permette di 
 * gestire questi dati.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class Utente {
    
    /** @brief Nome dell'utente */
     private String nome;

    /** @brief Cognome dell'utente */
     private String cognome;
    
    /** @brief Matricola dell'utente */
     private String matricola;
    
    /** @brief Email dell'utente */
     private String email;

    
    /**
     * 
     * @brief Costruisce un nuovo utente.
     * 
     * @param[in] nome Nome dell'utente.
     * @param[in] cognome Cognome dell'utente.
     * @param[in] matricola Matricola identificativa dell'utente.
     * @param[in] email Indirizzo email dell'utente.
     */
     public Utente(String nome, String cognome, String matricola, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
    }
    
    /**
     * @brief Restituisce il nome dell'utente.
     * @return Il nome dell'utente.
     */
        public String getNome() {
            return nome;
        }


    /**
     * @brief Restituisce il cognome dell'utente.
     * @return Il cognome dell'utente.
     */
        public String getCognome() {
            return cognome;
        }

    
     /**
     * @brief Restituisce la matricola dell'utente.
     * @return La matricola dell'utente.
     */
        public String getMatricola() {
                return matricola;
            }

    
    /**
     * @brief Restituisce l'email dell'utente.
     * @return L'email dell'utente.
     */
        public String getEmail() {
                return email;
            }

    
    /**
     * @brief Imposta il nome dell'utente.
     * @param[in] nome Nuovo nome dell'utente.
     */
        public void setNome(String nome) {
                this.nome = nome;
            }

    
    /**
     * @brief Imposta il cognome dell'utente.
     * @param[in] cognome Nuovo cognome dell'utente.
     */
        public void setCognome(String cognome) {
                this.cognome = cognome;
            }

    
    /**
     * @brief Imposta la matricola dell'utente.
     * @param[in] matricola Nuova matricola dell'utente.
     */
        public void setMatricola(String matricola) {
                this.matricola = matricola;
            }

    
    /**
     * @brief Imposta l'email dell'utente.
     * @param[in] email Nuova email dell'utente.
     */
        public void setEmail(String email) {
                this.email = email;
            }

    
    /**
     * @brief Confronta due oggetti utente per determinare se sono uguali.
     * 
     * @param[in] o Oggetto da confrontare con l'utente.
     * @return 'true' se gli utenti sono uguali, `false` altrimenti
     */
        @Override
            public boolean equals(Object o){
                return false;
            }
    
    
    /**
     * @brief Restituisce una rappresentazione testuale dell'utente.
     * 
     * @return Una stringa contenente nome, cognome, matricola, email.
     */
        @Override
            public String toString(){
                return "";
            }
    
}
