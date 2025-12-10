/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @class GestorePrestiti
 * @brief Implementa i metodi di 'Prestito'.
 * 
 * La classe 'GestorePrestiti' serve a gestire i prestiti della bilbioteca, passandogli
 * la lista dei prestiti e implementando i metodi per aggiungere, rimuovere e ordinare
 * i prestiti della biblioteca. Controlla che i prerequisiti per la creazione
 * del prestito siano soddisfatti.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestorePrestiti {

    /** @brief Lista dei prestiti effettuati nella biblioteca */    
    private List<Prestito> prestiti = new ArrayList<>();
    
     /**
     * @brief Verifica i prerequisiti di un prestito
     *
     * Questa istanza incapsula la logica di validazione dei prestiti
     *
     * @see ValidatorePrestito
     */    
    private ValidatorePrestito valida = new ValidatorePrestito();

    /**
     * @brief Restituisce la lista di tutti i prestiti attivi.
     * 
     * @return Lista di prestiti attivi nella biblioteca.
     */    
    public List<Prestito> getPrestiti() { return prestiti; }
    
    
    public void setPrestiti(List<Prestito> nuoviPrestiti) { this.prestiti = new ArrayList<>(nuoviPrestiti); }
    
    /**
     * @brief Aggiunge un nuovo prestito.
     * 
     * Questo metodo consente di registrare un nuovo prestito, 
     * associando un utente a un libro con una data di restituzione.
     * 
     * @param[in] utente Utente che prende in prestito il libro.
     * @param[in] libro Libro che viene preso in prestito.
     * @param[in] scadenza Data di restituzione del libro.
     */
    public void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza) throws Exception {
    }

    /**
     * @brief Restituisce un libro preso in prestito.
     * 
     * Questo metodo consente di restituire un libro preso in prestito, 
     * rimuovendo il prestito dal sistema.
     * 
     * @param[in] prestito Prestito da restituire.
     */
    public void restituisciLibro(Prestito prestito) {
    }
    
     /**
     * @brief Verifica se un libro è coinvolto in prestiti attivi.
     *
     * Questo metodo serve per controllare se un libro è coinvolto 
     * in un prestito, prima di poterlo eliminare.
     *
     * @param[in] l Il libro da controllare
     * @return 'true' se il libro è presente in almeno un prestito; 'false' altrimenti.
     */    
    public boolean haPrestitiAttivi(Libro l) {
        return false;
    }
    
     /**
     * @brief Verifica se un utente è coinvolto in prestiti attivi.
     *
     * Questo metodo serve per controllare se un utente
     * è coinvolto in un prestito, prima di poterlo eliminare.
     *
     * @param[in] u L'utente da controllare
     * @return 'true' se l'utente è presente in almeno un prestito; 'false' altrimenti.
     */
    public boolean haPrestitiAttivi(Utente u) {
        return false;
    }

     /**
     * @brief Restituisce la lista dei prestiti ordinata per data di scadenza.
     *
     * Utilizza uno stream per filtrare e ordinare la lista originale senza modificarla,
     * garantendo che l'interfaccia riceva i dati nell'ordine corretto.
     *
     * @return Lista di prestiti contenente tutti i prestiti registrati,
     * ordinati per data prevista di restituzione.
     */    
    public List<Prestito> getOrdinati() {
        return null;
    }
    
}
