/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.Comparator;

/**
 * @class ComparatoreLibri
 * @brief Implementa il comparatore per la classe `Libro`.
 * 
 * La classe `ComparatoreLibri` implementa l'interfaccia `Comparator` per 
 * confrontare due oggetti `Libro` fra di loro, al fine di ordonarli per titolo
 * o, se uguale, per codice ISBN
 * @author Daniel, Andrea, Stefano, Daniele
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
        
        if (o1 == null || o2 == null) {
           return (o1 == null) ? -1 : 1;
        }

        int res = o1.getTitolo().compareToIgnoreCase(o2.getTitolo());

        if (res == 0)
            res = o1.getIsbn().compareToIgnoreCase(o2.getIsbn());
    
        return res;
    }
  
    
}
