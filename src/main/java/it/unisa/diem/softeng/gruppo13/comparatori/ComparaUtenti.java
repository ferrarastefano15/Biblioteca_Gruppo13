/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.comparatori;

import it.unisa.diem.softeng.gruppo13.elementi.Utente;
import java.util.Comparator;

/**
 * @class ComparaUtenti
 * @brief Implementa il comparatore per la classe `Utente`.
 * 
 * La classe `ComparaUtenti` implementa l'interfaccia `Comparator` per confrontare due oggetti `Utente`.
 * Il metodo `compare` permette di stabilire l'ordine di confronto tra due utenti, che potrebbe essere basato 
 * su diversi criteri, ad esempio il nome, il cognome, la matricola o l'email.
 * Al momento, il metodo non è implementato.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class ComparaUtenti implements Comparator<Utente> {

    /**
     * @brief Confronta due utenti per stabilirne l'ordine.
     * 
     * Questo metodo deve confrontare due oggetti `Utente` in base a un criterio specifico (ad esempio, nome, cognome, matricola, email).
     * Attualmente, il metodo solleva un'eccezione `UnsupportedOperationException` in quanto non è ancora stato implementato.
     * 
     * @param o1 Primo utente da confrontare.
     * @param o2 Secondo utente da confrontare.
     * @return Un valore negativo se il primo utente è "minore" del secondo, zero se sono uguali, 
     *         un valore positivo se il primo utente è "maggiore" del secondo, in base al criterio di confronto.
     * @throws UnsupportedOperationException Se il metodo non è implementato.
     */
    @Override
    public int compare(Utente o1, Utente o2) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
