/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Stefano
 */
public class ComparatorePrestitiTest {
    
    private ComparatorePrestiti comparatore;
    
    private Prestito p1;
    private Prestito p2;
    
    @BeforeEach
    public void setUp() {
        comparatore = new ComparatorePrestiti();
    }
    
    // Data restituzione diversa
    @Test
    public void testCompare1() {
        System.out.println("compare");
        
        List<String> autore = new ArrayList<>();
        autore.add("Dante Alighieri");
        
        Libro libro;
        libro = new Libro("La Divina Commedia", autore, 1321, "9788817018012", 3);
        
        Utente utente;
        utente = new Utente("Ernesto", "Grigi", "543210988", "ernesto.grigi@gmail.com");
        
        LocalDate dataRestituzione1;
        dataRestituzione1 = LocalDate.of(2026, 11, 19); 
        LocalDate dataRestituzione2;
        dataRestituzione2 = LocalDate.of(2026, 11, 16); 
        
        
        Prestito prestito1;
        prestito1 = new Prestito(libro, utente, dataRestituzione1);
        Prestito prestito2;
        prestito2 = new Prestito(libro, utente, dataRestituzione2);
        
        int risultato = comparatore.compare(prestito1, prestito2);
        assertTrue(risultato > 0);
    }
    
    //Data restituzione uguale, matricole diverse
    @Test
    public void testCompare2() {
        System.out.println("compare");
        
        List<String> autore = new ArrayList<>();
        autore.add("Dante Alighieri");
        
        Libro libro;
        libro = new Libro("La Divina Commedia", autore, 1321, "9788817018012", 3);
        
        Utente utente1;
        utente1 = new Utente("Ernesto", "Grigi", "543210983", "ernesto.grigi@gmail.com");
        Utente utente2;
        utente2 = new Utente("Ernesto", "Grigi", "543210988", "ernesto.grigi@gmail.com");
        
        LocalDate dataRestituzione;
        dataRestituzione = LocalDate.of(2026, 11, 19); 
        
        Prestito prestito1;
        prestito1 = new Prestito(libro, utente1, dataRestituzione);
        Prestito prestito2;
        prestito2 = new Prestito(libro, utente2, dataRestituzione);
        
        int risultato = comparatore.compare(prestito1, prestito2);
        assertTrue(risultato < 0);
    }
    
    // Data restituzione diversa, matricole diverse, isbn uguale
    @Test
    public void testCompare3() {
        System.out.println("compare");
        
        List<String> autore = new ArrayList<>();
        autore.add("Dante Alighieri");
        
        Libro libro1;
        libro1 = new Libro("La Divina Commedia", autore, 1321, "9788817018017", 3);
        Libro libro2;
        libro2 = new Libro("La Divina Commedia", autore, 1321, "9788817018012", 3);
        
        Utente utente;
        utente = new Utente("Ernesto", "Grigi", "543210983", "ernesto.grigi@gmail.com");
        
        LocalDate dataRestituzione;
        dataRestituzione = LocalDate.of(2026, 11, 19); 
        
        Prestito prestito1;
        prestito1 = new Prestito(libro1, utente, dataRestituzione);
        Prestito prestito2;
        prestito2 = new Prestito(libro2, utente, dataRestituzione);
        
        int risultato = comparatore.compare(prestito1, prestito2);
        assertTrue(risultato > 0);
    }
    
}
