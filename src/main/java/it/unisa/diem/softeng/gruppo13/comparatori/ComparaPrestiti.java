/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.comparatori;

import it.unisa.diem.softeng.gruppo13.elementi.Prestito;
import java.util.Comparator;

/**
 * @class ComparaPrestiti
 * @brief Implementa il comparatore per la classe `Prestito`.
 * 
 * La classe `ComparaPrestiti` implementa l'interfaccia `Comparator` per confrontare due oggetti `Prestito`.
 * Il metodo `compare` permette di stabilire l'ordine di confronto tra due prestiti, che potrebbe essere 
 * basato su diversi criteri, ad esempio la data di restituzione, il libro prestato, o l'utente che ha preso in prestito il libro.
 * Al momento, il metodo non è implementato.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class ComparaPrestiti implements Comparator<Prestito> {

    /**
     * @brief Confronta due prestiti per stabilirne l'ordine.
     * 
     * Questo metodo deve confrontare due oggetti `Prestito` in base a un criterio specifico (ad esempio, data di restituzione, 
     * libro prestato, utente).
     * Attualmente, il metodo solleva un'eccezione `UnsupportedOperationException` in quanto non è ancora stato implementato.
     * 
     * @param o1 Primo prestito da confrontare.
     * @param o2 Secondo prestito da confrontare.
     * @return Un valore negativo se il primo prestito è "minore" del secondo, zero se sono uguali, 
     *         un valore positivo se il primo prestito è "maggiore" del secondo, in base al criterio di confronto.
     * @throws UnsupportedOperationException Se il metodo non è implementato.
     */
    @Override
    public int compare(Prestito o1, Prestito o2) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
