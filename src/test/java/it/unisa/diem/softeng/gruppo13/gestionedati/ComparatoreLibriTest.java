/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Daniel
 */
public class ComparatoreLibriTest {
    
    private ComparatoreLibri comparatore;
    
    private Libro l1;
    private Libro l2;
    
    @BeforeEach
    public void setUp(){
        comparatore = new ComparatoreLibri();
    }
    
    
    // Titoli diversi
    @Test
    public void testCompare1(){
        List<String> autori = new ArrayList<>();
        autori.add("J.K. Rowling");
        l1 = new Libro ("Harry Potter e la pietra filosofale", autori, 1997, "1234567890123", 2);
        l2 = new Libro ("Harry Potter e il calice di fuoco", autori, 2000, "1234567890124", 2);
        int risultato = comparatore.compare(l1, l2);
        assertTrue( risultato > 0);
    }
    
    // Titoli uguali
    @Test
    public void testCompare2() {
        
        List<String> autori = new ArrayList<>();
        autori.add("J.K. Rowling");
        l1 = new Libro ("Harry Potter e la pietra filosofale", autori, 1997, "1234567890123", 2);
        l2 = new Libro ("Harry potter e la pietra filosofale", autori, 2000, "1234567890124", 2);
        int risultato = comparatore.compare(l1, l2);
        assertTrue( risultato < 0);
        
    }
    
}
