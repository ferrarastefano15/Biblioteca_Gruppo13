/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.elementi;

import java.util.List;

/**
 * @class Utente
 * @brief Rappresenta un utente della biblioteca.
 * 
 * La classe `Utente` descrive le informazioni di un utente che può prendere in prestito dei libri dalla biblioteca. 
 * Contiene i dati personali dell'utente come nome, cognome, matricola e email, e permette di gestire questi dati.
 * L'utente può anche avere prestiti attivi, sebbene questa parte non sia implementata nel costruttore in modo completo.
 * 
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
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
     * Questo costruttore crea un oggetto `Utente` associando i dati personali come nome, cognome, matricola ed email.
     * Al momento, il parametro `prestitiAttivi` non viene utilizzato.
     *
     * @param nome Nome dell'utente.
     * @param cognome Cognome dell'utente.
     * @param matricola Matricola identificativa dell'utente.
     * @param email Indirizzo email dell'utente.
     * @param prestitiAttivi
     */
     public Utente(String nome, String cognome, String matricola, String email, List<Prestito> prestitiAttivi) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
    }
    
    /**
     * @brief Restituisce il nome dell'utente.
     * 
     * Questo metodo restituisce il nome dell'utente.
     * 
     * @return Il nome dell'utente.
     */
        public String getNome() {
            return nome;
        }


    /**
     * @brief Restituisce il cognome dell'utente.
     * 
     * Questo metodo restituisce il cognome dell'utente.
     * 
     * @return Il cognome dell'utente.
     */
        public String getCognome() {
            return cognome;
        }

    
     /**
     * @brief Restituisce la matricola dell'utente.
     * 
     * Questo metodo restituisce la matricola dell'utente, che lo identifica univocamente.
     * 
     * @return La matricola dell'utente.
     */
        public String getMatricola() {
                return matricola;
            }

    
    /**
     * @brief Restituisce l'email dell'utente.
     * 
     * Questo metodo restituisce l'indirizzo email dell'utente.
     * 
     * @return L'email dell'utente.
     */
        public String getEmail() {
                return email;
            }

    
    /**
     * @brief Imposta il nome dell'utente.
     * 
     * Questo metodo imposta il nome dell'utente.
     * 
     * @param nome Nuovo nome dell'utente.
     */
        public void setNome(String nome) {
                this.nome = nome;
            }

    
    /**
     * @brief Imposta il cognome dell'utente.
     * 
     * Questo metodo imposta il cognome dell'utente.
     * 
     * @param cognome Nuovo cognome dell'utente.
     */
        public void setCognome(String cognome) {
                this.cognome = cognome;
            }

    
    /**
     * @brief Imposta la matricola dell'utente.
     * 
     * Questo metodo imposta la matricola dell'utente.
     * 
     * @param matricola Nuovo matricola dell'utente.
     */
        public void setMatricola(String matricola) {
                this.matricola = matricola;
            }

    
    /**
     * @brief Imposta l'email dell'utente.
     * 
     * Questo metodo imposta l'email dell'utente.
     * 
     * @param email Nuova email dell'utente.
     */
        public void setEmail(String email) {
                this.email = email;
            }

    
    /**
     * @brief Confronta due oggetti utente per determinare se sono uguali.
     * 
     * Questo metodo è stato sovrascritto per confrontare un utente con un altro oggetto.
     * In questa versione, ritorna sempre `false`, indicando che l'utente non è uguale a un altro oggetto.
     *
     * @param o Oggetto da confrontare con l'utente.
     * @return `false` (modificato per un confronto di esempio).
     */
        @Override
            public boolean equals(Object o){
                return false;
            }
    
    
    /**
     * @brief Restituisce una rappresentazione testuale dell'utente.
     * 
     * Questo metodo restituisce una rappresentazione stringa dell'utente. 
     * In questa versione, il metodo restituisce `null`, ma dovrebbe essere implementato 
     * per restituire informazioni come nome, cognome, matricola, etc.
     *
     * @return La rappresentazione testuale dell'utente.
     */
        @Override
            public String toString(){
                return null;
            }
    
}
