/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.comparatori;

import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import java.util.Comparator;

/**
 * @class ComparatorePrestiti
 * @brief Implementa il comparatore per la classe `Prestito`.
 * 
 * La classe `ComparatorePrestiti` implementa l'interfaccia `Comparator` per 
 * confrontare due oggetti `Prestito` fra di loro, al fine di ordinarli per
 * data di prevista restituzione.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class ComparatorePrestiti implements Comparator<Prestito> {

    /**
     * @brief Confronta due prestiti per data di restituzione.
     * 
     * 
     * @param[in] o1 Primo prestito da confrontare.
     * @param[in] o2 Secondo prestito da confrontare.
     * @return Un intero negativo se il primo prestito è "minore" del secondo, zero se sono uguali, 
     *         un intero positivo se il primo prestito è "maggiore" del secondo, in base al criterio di confronto.
     */
    @Override
    public int compare(Prestito o1, Prestito o2) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
