/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionefile;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.util.List;

/**
* @brief Salva lo stato corrente delle liste su file distinti.
* 
* Scrive i dati di libri, utenti e prestiti in tre file separati all'interno
* della directory di salvataggio. Questo approccio previene la perdita totale 
* dei dati in caso di corruzione di un singolo file.
*
* @author Daniel, Andrea, Stefano, Daniele
*/
public interface InterfacciaFile {
    

     /**
     * @brief Salva lo stato corrente delle liste su file distinti.
     * 
     * Scrive i dati di libri, utenti e prestiti in tre file separati all'interno
     * della directory di salvataggio. Questo approccio previene la perdita totale 
     * dei dati in caso di corruzione di un singolo file.
     * 
     * @param[in] libri Lista dei libri da salvare.
     * @param[in] utenti Lista degli utenti da salvare.
     * @param[in] prestiti Lista dei prestiti da salvare.
     * 
     * @pre Esiste almeno un dato da salvare
     * @post Nei file creati c'è almeno un dato
     */
      public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
      
      
     /**
     * @brief Carica i dati dai file e ricostruisce la coerenza dei riferimenti.
     * 
     * Legge i dati dai file separati e popola le liste passate come parametro.
     * Inoltre, effettua un ricollegamento (relinking) degli oggetti Libro e Utente
     * all'interno dei Prestiti, garantendo che puntino alle istanze corrette in memoria.
     * 
     * @param[in] libri Lista da popolare con i libri.
     * @param[in] utenti Lista da popolare con gli utenti.
     * @param[in] prestiti Lista da popolare con i prestiti ricollegati.
     * 
     * @pre La directory e i file dati devono esistere (altrimenti non fa nulla).
     * @post Le liste contengono i dati aggiornati e i prestiti sono coerenti.
     */
      public void caricaDati(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti);
    
    
}
