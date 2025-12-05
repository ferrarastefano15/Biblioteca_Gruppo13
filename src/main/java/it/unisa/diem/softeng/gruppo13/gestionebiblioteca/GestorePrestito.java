/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class GestorePrestito {
  
    private List<Prestito> prestiti = new ArrayList<>();
    private ValidatorePrestito valida = new ValidatorePrestito();

    public List<Prestito> getTutti() { return prestiti; }
    public void setPrestiti(List<Prestito> nuoviPrestiti) { this.prestiti = new ArrayList<>(nuoviPrestiti); }

    public void aggiungiPrestito(Utente utente, Libro libro, LocalDate scadenza) throws Exception {
    }

    public void restituisciLibro(Prestito prestito) {
    }
    
    // Metodo per controllare se si può cancellare un utente o libro
    public boolean haPrestitiAttivi(Object entita) {
        return false;
    }

    public List<Prestito> getOrdinati() {
        return null;
    }
    
}
