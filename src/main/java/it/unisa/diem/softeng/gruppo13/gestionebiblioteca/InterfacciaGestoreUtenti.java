/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface InterfacciaGestoreUtenti {
    
    public List<Utente> getUtenti();
             
    void aggiungiUtente(Utente utente);

    void rimuoviUtente(Utente utente);

    void modificaUtente(Utente vecchio, Utente nuovo);

    List<Utente> cercaUtente(String query);

    List<Utente> getUtentiOrdinati();
    
}
