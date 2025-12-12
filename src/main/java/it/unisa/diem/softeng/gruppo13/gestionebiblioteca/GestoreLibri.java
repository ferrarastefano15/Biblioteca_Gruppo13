/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.unisa.diem.softeng.gruppo13.gestionedati.ComparatoreLibri;
/**
 * @class GestoreLibri
 * @brief Implementa i metodi di 'Libro'.
 * 
 * La classe 'GestoreLibri' serve a gestire i libri della bilbioteca, passandogli
 * la lista dei libri e implementando i metodi per aggiungere, rimuovere e cercare
 * i libri della biblioteca.
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreLibri implements InterfacciaGestoreLibri{
    
    /** @brief Lista dei libri presenti nella biblioteca */
    private List<Libro> libri = new ArrayList<>();

    /**
     * @brief Restituisce la lista di tutti i libri della biblioteca.
     *
     * @return Lista di libri presenti nella biblioteca.
     */    
    public List<Libro> getLibri() { return libri; }
    
     /**
     * @brief Sostituisce l'elenco corrente dei libri con una nuova lista.
     *
     * Questo metodo viene utilizzato principalmente durante la fase di inizializzazione
     * o caricamento dati per popolare il service con i libri letti da un file esterno.
     *
     * @param[in] nuoviLibri La lista di libri da impostare nel service.
     *
     */
    public void setLibri(List<Libro> nuoviLibri) { this.libri = new ArrayList<>(nuoviLibri); }

    /**
     * @brief Aggiunge un nuovo libro alla biblioteca.
     * 
     * Questo metodo permette di aggiungere un nuovo libro alla biblioteca.
     * I dati vengono validati prima di procedere con l'aggiunta.
     *
     * @param[in] libro Libro da aggiungere 
     */
    @Override
    public void aggiungiLibro(Libro libro) {
        
        if(libro==null) return ;
        
        validaLibro(libro);
        
        for (Libro l : libri) {
            if (l.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
                throw new IllegalArgumentException("ISBN già esistente.");
            }
        }
        
        libri.add(libro);
        
    }

    /**
     * @brief Modifica le informazioni di un libro della biblioteca.
     * 
     * Questo metodo individua il libro originale nel sistema e ne sostituisce 
     * le informazioni con i nuovi dati forniti. 
     * 
     * @param[in] libro1 Libro della bilbioteca da modificare.
     * @param[in] libro2 Libro modificato.
     */
    @Override
    public void modificaLibro(Libro libro1, Libro libro2){
        
        if (libro1 == null || libro2 == null) {
            throw new IllegalArgumentException("Dati non validi.");
        }
    
        validaLibro(libro2);
    
        if (!libro1.getIsbn().equalsIgnoreCase(libro2.getIsbn())) {
            for (Libro l : libri) {
                if (l != libro1 && l.getIsbn().equalsIgnoreCase(libro2.getIsbn())) {
                    throw new IllegalArgumentException("Impossibile modificare: il nuovo ISBN esiste già per un altro libro.");
                }
            }
        }

  
        libro1.setTitolo(libro2.getTitolo());
        libro1.setAutori(libro2.getAutori());
        libro1.setAnno(libro2.getAnno());
        libro1.setIsbn(libro2.getIsbn());
    }
    
    /**
     * @brief Rimuove un libro dalla biblioteca.
     * 
     * Questo metodo consente di rimuovere un libro dalla biblioteca, 
     * eliminandolo dalla lista dei libri disponibili.
     * 
     * @param[in] libro Libro da rimuovere
     */    
    @Override
    public void rimuoviLibro(Libro libro) {
        
        libri.remove(libro);
        
    }

    /**
     * @brief Cerca i libri in base a una query di ricerca.
     * 
     * Questo metodo cerca i libri che corrispondono alla query fornita e 
     * restituisce una lista di libri che soddisfano i criteri di ricerca.
     * 
     * @param[in] query Stringa di ricerca che rappresenta titolo, autore o 
     * codice del libro.
     * 
     * @return Lista di libri che corrispondono alla query.
     */  
    @Override
    public List<Libro> cercaLibro(String query) {
        
    String q = (query == null) ? "" : query.toLowerCase();

    List<Libro> risultati = new ArrayList<>();

    for (Libro l : libri) {
        
        boolean matchTitolo = l.getTitolo() != null && l.getTitolo().toLowerCase().contains(q);
        
        boolean matchAutore = l.getAutori() != null && l.getAutori().toLowerCase().contains(q);
        
        boolean matchIsbn   = l.getIsbn() != null && l.getIsbn().toLowerCase().contains(q);

        if (matchTitolo || matchAutore || matchIsbn) {
            risultati.add(l);
        }
    }
    risultati.sort(new ComparatoreLibri());

    return risultati;
    }
    
    /**
     * @brief Verifica la validità e la coerenza dei dati di un libro.
     * 
     * Questo metodo esegue un controllo sul libro fornito per assicurarsi
     * che tutti i campi siano presenti e conformi ai requisiti del sistema prima 
     * dell'elaborazione.
     * 
     * @param[in] libro Libro da sottoporre a validazione.
     */
    private void validaLibro(Libro libro) {
        
    if (libro.getTitolo() == null || libro.getTitolo().isEmpty()) {
        throw new IllegalArgumentException("Il titolo è obbligatorio.");
    }
    
    if (libro.getAutori() == null || libro.getAutori().isEmpty()) {
            throw new IllegalArgumentException("Il libro deve avere almeno un autore.");
        }

    if (libro.getIsbn() == null || libro.getIsbn().isEmpty()) {
        throw new IllegalArgumentException("L'ISBN è obbligatorio.");
    }
    
    if (!libro.getIsbn().matches("\\d{13}")) {
            throw new IllegalArgumentException("L'ISBN deve essere composto da 13 cifre numeriche.");
        }

    if (libro.getAnno() > java.time.Year.now().getValue()) {
        throw new IllegalArgumentException("Anno futuro non valido.");
    }
    
    if (libro.getCopieDisponibili() < 1 ) {
            throw new IllegalArgumentException("Devi inserire almeno 1 copia.");
        }
    }
    
}
