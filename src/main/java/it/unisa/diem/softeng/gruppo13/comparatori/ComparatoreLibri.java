/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.comparatori;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import java.util.Comparator;

/**
 * @class ComparatoreLibri
 * @brief Implementa il comparatore per la classe `Libro`.
 * 
 * La classe `ComparatoreLibri` implementa l'interfaccia `Comparator` per 
 * confrontare due oggetti `Libro` fra di loro, al fine di ordonarli per titolo
 * o, se uguale, per codice ISBN
 * @author Daniel, Daniel, Andrea, Stefano, Daniele
 */
public class ComparatoreLibri implements Comparator<Libro> { 

    
     /**
     * @brief Confronta due libri per titolo o codice ISBN.
     * 
     * @param[in] o1 Primo libro da confrontare.
     * @param[in] o2 Secondo libro da confrontare.
     * @return Un intero negativo se il primo libro è "minore" del secondo, zero se sono uguali, 
     *         un intero positivo se il primo libro è "maggiore" del secondo, in base al criterio di confronto.
     */
@Override
    public int compare(Libro o1, Libro o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
