/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionefile.InterfacciaFile;
import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @class Biblioteca
 * @brief Gestisce le operazioni relative alla biblioteca.
 * 
 * La classe `GestioneBiblioteca` è il cuore del sistema di gestione di una biblioteca. 
 * Permette di gestire libri, utenti e prestiti, offrendo metodi per aggiungere, cercare,
 * modificare e rimuovere elementi.
 * La classe utilizza anche un file manager per salvare e caricare i dati.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class Biblioteca implements InterfacciaBiblioteca{
    
     /** @brief Lista dei libri presenti nella biblioteca */
    private List<Libro> libri;
 
    /** @brief Lista degli utenti registrati nella biblioteca */
    private List<Utente> utenti;

    /** @brief Lista dei prestiti effettuati nella biblioteca */
    private List<Prestito> prestiti;

    /** @brief Gestore delle operazioni di file */
    private InterfacciaFile fileManager;

    
   /**
     * @brief Costruisce una nuova istanza di GestioneBiblioteca.
     * 
     * @param fileManager Il gestore delle operazioni sui file.
     */
   public Biblioteca(InterfacciaFile fileManager) {
        this.libri = new ArrayList<>();
        this.utenti = new ArrayList<>();
        this.prestiti = new ArrayList<>();
        this.fileManager = fileManager;
    }
    
    
    /**
     * @brief Restituisce la lista di tutti i libri della biblioteca.
     * 
     * Questo metodo restituirà la lista dei libri presenti nella biblioteca.
     *
     * @return Lista di libri presenti nella biblioteca.
     * @throws UnsupportedOperationException Metodo non implementato.
     */
        @Override
        public List<Libro> getLibri() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    
    /**
     * @brief Restituisce la lista di tutti gli utenti della biblioteca.
     * 
     * Questo metodo restituirà la lista degli utenti registrati nella biblioteca.
     *
     * @return Lista di utenti registrati nella biblioteca.
     * @throws UnsupportedOperationException Metodo non implementato.
     */
        @Override
            public List<Utente> getUtenti() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Restituisce la lista di tutti i prestiti attivi.
     * 
     * Questo metodo restituirà la lista di tutti i prestiti effettuati nella biblioteca.
     *
     * @return Lista di prestiti attivi nella biblioteca.
     * @throws UnsupportedOperationException Metodo non implementato.
     */
        @Override
            public List<Prestito> getPrestiti() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Aggiunge un nuovo libro alla biblioteca.
     * 
     * Questo metodo permette di aggiungere un nuovo libro alla biblioteca.
     * I dati vengono validati prima di procedere con l'aggiunta.
     *
     * @param titolo Titolo del libro da aggiungere.
     * @param autori Autori del libro da aggiungere.
     * @param anno Anno di pubblicazione del libro.
     * @param isbn Codice ISBN del libro.
     * @param copie Numero di copie del libro da aggiungere.
     * @throws Exception Se i dati non sono validi o l'aggiunta non riesce.
     * @throws UnsupportedOperationException Metodo non implementato.
     */
        @Override
            public void aggiungiLibro(String titolo, String autori, String anno, String isbn, String copie) throws Exception {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Aggiunge un nuovo utente alla biblioteca.
     * 
     * Questo metodo consente di aggiungere un nuovo utente alla biblioteca, fornendo le informazioni necessarie 
     * come il nome, il cognome, la matricola e l'indirizzo email.
     * 
     * @param nome Nome dell'utente da aggiungere.
     * @param cognome Cognome dell'utente da aggiungere.
     * @param matricola Matricola dell'utente.
     * @param email Indirizzo email dell'utente.
     * @throws Exception Se i dati forniti non sono validi.
     */
        @Override
            public void aggiungiUtente(String nome, String cognome, String matricola, String email) throws Exception {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Aggiunge un nuovo prestito.
     * 
     * Questo metodo consente di registrare un nuovo prestito, associando un utente a un libro con una data di restituzione.
     * 
     * @param u Utente che prende in prestito il libro.
     * @param l Libro che viene preso in prestito.
     * @param data Data di restituzione del libro.
     * @throws Exception Se i dati forniti non sono validi.
     */
        @Override
            public void aggiungiPrestito(Utente u, Libro l, LocalDate data) throws Exception {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Cerca i libri in base a una query di ricerca.
     * 
     * Questo metodo cerca i libri che corrispondono alla query fornita e restituisce una lista di libri che soddisfano 
     * i criteri di ricerca.
     * 
     * @param query Stringa di ricerca per trovare i libri.
     * @return Lista di libri che corrispondono alla query.
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public List<Libro> cercaLibri(String query) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Cerca gli utenti in base a una query di ricerca.
     * 
     * Questo metodo cerca gli utenti che corrispondono alla query fornita e restituisce una lista di utenti che soddisfano 
     * i criteri di ricerca.
     * 
     * @param query Stringa di ricerca per trovare gli utenti.
     * @return Lista di utenti che corrispondono alla query.
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public List<Utente> cercaUtenti(String query) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Rimuove un libro dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un libro dalla biblioteca, eliminandolo dalla lista dei libri disponibili.
     * 
     * @param l Libro da rimuovere dalla biblioteca.
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public void rimuoviLibro(Libro l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
     /**
     * @brief Rimuove un utente dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un utente dalla biblioteca, eliminandolo dalla lista degli utenti registrati.
     * 
     * @param u Utente da rimuovere dalla biblioteca.
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public void rimuoviUtente(Utente u) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Restituisce un libro preso in prestito.
     * 
     * Questo metodo consente di restituire un libro preso in prestito, aggiornando lo stato del prestito.
     * 
     * @param p Prestito da restituire.
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public void restituisciLibro(Prestito p) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    
    /**
     * @brief Salva tutti i dati della biblioteca.
     * 
     * Questo metodo salva tutte le informazioni riguardanti i libri, gli utenti e i prestiti.
     * 
     * @throws UnsupportedOperationException Non implementato.
     */
        @Override
            public void salvaTutto() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    
   
    /**
     * @brief Valida i dati del libro prima di aggiungerlo alla biblioteca.
     * 
     * Questo metodo verifica che i dati del libro siano validi, come il titolo, gli autori, l'anno, il codice ISBN, 
     * e il numero di copie disponibili.
     * 
     * @param t Titolo del libro.
     * @param a Autori del libro.
     * @param anno Anno di pubblicazione.
     * @param isbn Codice ISBN del libro.
     * @param copie Numero di copie disponibili
     */
        private void validaDatiLibro(String t, String a, String anno, String isbn, String copie){

           }

    
    /**
     * @brief Valida i dati dell'utente prima di aggiungerlo alla biblioteca.
     * 
     * Questo metodo verifica che i dati dell'utente siano validi, come il nome, il cognome, la matricola, 
     * e l'indirizzo email.
     * 
     * @param n Nome dell'utente.
     * @param c Cognome dell'utente.
     * @param m Matricola dell'utente.
     * @param e Email dell'utente.
     */
        private void validaDatiUtente(String n, String c, String m, String e){

            }

}
