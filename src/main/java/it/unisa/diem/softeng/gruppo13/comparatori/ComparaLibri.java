/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.comparatori;

import it.unisa.diem.softeng.gruppo13.elementi.Libro;
import java.util.Comparator;

/**
 * @class ComparaLibri
 * @brief Implementa il comparatore per la classe `Libro`.
 * 
 * La classe `ComparaLibri` implementa l'interfaccia `Comparator` per confrontare due oggetti `Libro`.
 * Il metodo `compare` permetterà di definire l'ordine di confronto tra due libri, ad esempio in base al titolo, 
 * all'autore, all'anno di pubblicazione, o ad altri criteri. Al momento, il metodo non è implementato.
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class ComparaLibri implements Comparator<Libro> { 

    
/**
     * @brief Confronta due libri per stabilirne l'ordine.
     * 
     * Questo metodo deve confrontare due oggetti `Libro` in base a un criterio specifico (ad esempio, titolo, autore, anno).
     * Attualmente, il metodo solleva un'eccezione `UnsupportedOperationException` in quanto non è ancora stato implementato.
     * 
     * @param o1 Primo libro da confrontare.
     * @param o2 Secondo libro da confrontare.
     * @return Un valore negativo se il primo libro è "minore" del secondo, zero se sono uguali, 
     *         un valore positivo se il primo libro è "maggiore" del secondo, in base al criterio di confronto.
     * @throws UnsupportedOperationException Se il metodo non è implementato.
     */
@Override
    public int compare(Libro o1, Libro o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
