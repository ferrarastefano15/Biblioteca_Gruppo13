/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Stefano
 */
public class LibroTest {
    private Libro libro;
    
    @BeforeEach
    public void setUp(){
        
        List<String> autori = new ArrayList<>();
        autori.add("Stephen King");
        autori.add("Peter Straub");
        
        libro = new Libro("Il Talismano", autori, 1984, "9788878240087", 2);
        
    }
    
    public LibroTest(){
        
    }
    
    @Test
    public void testGeTitolo() {
        System.out.println("getTitolo");
        String expResult = "Il Talismano";
        String result = libro.getTitolo();
        assertEquals(expResult, result);
    } 
    
    @Test
    public void testGetAutori() {
        System.out.println("getAutori");
        String expResult = "Stephen King, Peter Straub";
        String result = libro.getAutori();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAnno() {
        System.out.println("getAnno");
        int expResult = 1984;
        int result = libro.getAnno();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGeIsbn() {
        System.out.println("getIsbn");
        String expResult = "9788878240087";
        String result = libro.getIsbn ();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCopieDisponibili() {
        System.out.println("getCopieDisponibili");
        int expResult = 2;
        int result = libro.getCopieDisponibili();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetTitolo() {
        System.out.println("setTitolo");
        String titolo = "Shining";
        libro.setTitolo(titolo);
        String expResult = "Shining";
        assertEquals(expResult, libro.getTitolo());
    }
    
    @Test
    public void testSetAutori() {
        System.out.println("setAutori");
        List<String> aut = new ArrayList<>();
        aut.add("J.K. Rowling");
        aut.add("abc");
        libro.setAutori(aut);
        String expResult = "J.K. Rowling, abc";
        assertEquals(expResult, libro.getAutori());
    }
    
    @Test
    public void testSetAnno() {
        System.out.println("setAnno");
        int anno = 1985;
        libro.setAnno(anno);
        int expResult = 1985;
        assertEquals(expResult, libro.getAnno());
    }
    
    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "9788878240086";
        libro.setIsbn(isbn);
        String expResult = "9788878240086";
        assertEquals(expResult, libro.getIsbn());
    }
   
    @Test
    public void testSetCopieDisponibili() {
        System.out.println("setCopieDisponibili");
        int copieDisponibili = 1;
        libro.setCopieDisponibili(copieDisponibili);
        int expResult = 1;
        assertEquals(expResult, libro.getCopieDisponibili());
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        List<String> autori = new ArrayList<>();
        autori.add("Stephen King");
        autori.add("Peter Straub");
        Libro libro2 = new Libro("Il Talismano", autori, 1984, "9788878240087", 2);
        assertTrue(libro.equals(libro2));
        Libro libro3 = new Libro("Il Talismano", autori, 1984, "9788878240086", 2);
        assertFalse(libro.equals(libro3));  
    }
    
    @Test
    public void testDecrementaCopie() {
        System.out.println("decrementaCopie");
        libro.decrementaCopie();
        int expResult = 1;
        assertEquals(expResult, libro.getCopieDisponibili());
    }
    
    @Test
    public void testIncrementaCopie() {
        System.out.println("decrementaCopie");
        libro.incrementaCopie();
        int expResult = 3;
        assertEquals(expResult, libro.getCopieDisponibili());
    }
    
    @Test
    public void testDecrementaCopieSottoZero() {
        System.out.println("decrementaCopie");
        libro.setCopieDisponibili(0);
        libro.decrementaCopie();
        assertEquals(0, libro.getCopieDisponibili());
    }
}
