/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Stefano
 */
public class GestoreUtenti {

    private List<Utente> utenti = new ArrayList<>();

    public List<Utente> getUenti() { return utenti; }
    public void setUtenti(List<Utente> nuoviUtenti) { this.utenti = new ArrayList<>(nuoviUtenti); }

    public void aggiungiUtente(Utente utente) {
    }

    public void rimuoviUtente(Utente utente) {
    }

    public List<Utente> cercaUtenti(String query) {
        return null;
    }

    
}
