/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.logica;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.util.List;

/**
 * @class SalvaFile
 * @brief Implementa l'interfaccia `InterfacciaFile` per la gestione del salvataggio dei dati.
 * 
 * La classe `SalvaFile` è responsabile per l'implementazione del salvataggio dei dati relativi a libri, utenti 
 * e prestiti in un file. Essa implementa l'interfaccia `InterfacciaFile`, che definisce il contratto per il salvataggio 
 * dei dati, ma al momento la funzionalità di salvataggio non è implementata.
 * @author Daniel, Andrea, Stefano, Daniele
 * @date Dicembre 03, 2025
 */
public class SalvaFile implements InterfacciaFile {
  

     /** @brief Riferimento all'archivio della biblioteca */
      private InterfacciaBiblioteca archivio;
    
    
    /**
     * @brief Salva i dati dei libri, degli utenti e dei prestiti in un file.
     * 
     * Questo metodo è destinato a implementare la logica per salvare i dati dei libri, degli utenti e dei prestiti
     * in un file. La persistenza dei dati garantisce che le informazioni possano essere recuperate anche dopo il riavvio
     * del programma. Al momento, il metodo solleva un'eccezione `UnsupportedOperationException` in quanto non è stato
     * implementato.
     * 
     * @param libri Lista dei libri da salvare.
     * @param utenti Lista degli utenti da salvare.
     * @param prestiti Lista dei prestiti da salvare.
     * @throws UnsupportedOperationException Se il metodo non è ancora implementato.
     */
        @Override
        public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    
    
}
