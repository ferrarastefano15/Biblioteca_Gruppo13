/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.util.Comparator;

/**
 * @class ComparatoreUtenti
 * @brief Implementa il comparatore per la classe `Utente`.
 * 
 * La classe `ComparatoreUtenti` implementa l'interfaccia `Comparator` per 
 * confrontare due oggetti `Utente` fra di loro, al fine di ordinarli per 
 * cognome e nome. Se risultano uguali, li ordina per matricola.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class ComparatoreUtenti implements Comparator<Utente> {

    /**
     * @brief Confronta due utenti per cognome, nome e matricola.
     * 
     * 
     * @param[in] o1 Primo utente da confrontare.
     * @param[in] o2 Secondo utente da confrontare.
     * @return Un intero negativo se il primo utente è "minore" del secondo, zero se sono uguali, 
     *         un intero positivo se il primo utente è "maggiore" del secondo, in base al criterio di confronto.
     */
    @Override
    public int compare(Utente o1, Utente o2) {
        
        
        if (o1 == null || o2 == null) {
           return (o1 == null) ? -1 : 1;
        }

        int res = o1.getCognome().compareToIgnoreCase(o2.getCognome());

        if (res == 0) {
            res = o1.getNome().compareToIgnoreCase(o2.getNome());

            if (res == 0) {
                return o1.getMatricola().compareToIgnoreCase(o2.getMatricola());
            }
        }
    
        return res;
    }
}
