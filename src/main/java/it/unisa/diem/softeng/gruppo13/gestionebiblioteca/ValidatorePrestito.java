/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ValidatorePrestito {
    
    private static final int MAX_PRESTITI = 3;

    public void valida(Utente utente, Libro libro, List<Prestito> prestitiAttuali) throws Exception {
    }

}
