/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;


import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class GestoreLibriTest {
    
    private GestoreLibri gestore;
    private Libro l1;
    private Libro l2;
    private Libro l3;

    @BeforeEach
    void setUp() {
        gestore = new GestoreLibri();

        l1 = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "1111111111111", 5);
        l2 = new Libro("Il Signore degli Anelli", Arrays.asList("J.R.R. Tolkien"), 1954, "2222222222222", 3);
        l3 = new Libro("It", Arrays.asList("S. King"), 1986, "3333333333333", 10);
    }

    
    // Libro valido
    @Test
    void testAggiungiLibro1() {

        System.out.println("aggiungiLibro1");
        
        gestore.aggiungiLibro(l1);

        assertFalse(gestore.getLibri().isEmpty());
        assertTrue(gestore.getLibri().contains(l1));
    }

    // Libro non valido
    @Test
    void testAggiungiLibro2() {
        
        System.out.println("aggiungiLibro2");

        gestore.aggiungiLibro(l1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            gestore.aggiungiLibro(l1);
        });
        
        assertEquals(1, gestore.getLibri().size());
    }

    // Libro null
    @Test
    void testAggiungiLibro3() {
        
        System.out.println("aggiungiLibro3");
        gestore.aggiungiLibro(null);
        assertTrue(gestore.getLibri().isEmpty());
    }

    // Rimuovi libro esistente
    @Test
    void testRimuoviLibro1() {
        
        System.out.println("rimuoviLibro1");

        gestore.aggiungiLibro(l1);
        gestore.aggiungiLibro(l2);

        gestore.rimuoviLibro(l1);

        assertEquals(1, gestore.getLibri().size());
        assertFalse(gestore.getLibri().contains(l1));
        assertTrue(gestore.getLibri().contains(l2));
    }

    // Rimuovi libro non esistente 
    @Test
    void testRimuoviLibro2() {
        
        System.out.println("riuoviLibro2");
         
        gestore.aggiungiLibro(l1);
        gestore.rimuoviLibro(l2); 

        assertEquals(1, gestore.getLibri().size());
    }
    
    @Test
    void testRicercaLibri() {

        System.out.println("ricercaLibri");
        gestore.aggiungiLibro(l1);
        gestore.aggiungiLibro(l2); 
        gestore.aggiungiLibro(l3); 

        List<Libro> resTitolo = gestore.cercaLibro("Harry");
        assertEquals(1, resTitolo.size());
        assertEquals(l1, resTitolo.get(0));

        List<Libro> resAutore = gestore.cercaLibro("Tolkien");
        assertEquals(1, resAutore.size());
        assertEquals(l2, resAutore.get(0));

        List<Libro> resIsbn = gestore.cercaLibro("333333333333");
        assertEquals(1, resIsbn.size());
        assertEquals(l3, resIsbn.get(0));

        List<Libro> resVuoto = gestore.cercaLibro("Zorro");
        assertTrue(resVuoto.isEmpty());
    }
    
    
    @Test
    void testModificaLibro() {

        System.out.println("modificaLibro");
        
        gestore.aggiungiLibro(l1); 
        
        Libro l1Modificato = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 2000, "4444444444444", 5);

        gestore.modificaLibro(l1, l1Modificato);

        List<Libro> lista = gestore.getLibri();
        
        Libro libroAggiornato = lista.get(0);
        
        assertEquals(2000, libroAggiornato.getAnno());
        
        assertSame(l1, libroAggiornato);
    }

    
}
