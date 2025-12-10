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
        setUp();
        System.out.println("getTitolo");
        String expResult = "Il Talismano";
        String result = libro.getTitolo();
        assertEquals(expResult, result);
    } 
    
    @Test
    public void testGetAutori() {
        setUp();
        System.out.println("getAutori");
        String expResult = "Stephen King,Peter Straub";
        String result = libro.getAutori();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAnno() {
        setUp();
        System.out.println("getAnno");
        int expResult = 1984;
        int result = libro.getAnno();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGeIsbn() {
        setUp();
        System.out.println("getIsbn");
        String expResult = "9788878240087";
        String result = libro.getIsbn ();
        assertEquals(expResult, result);
    } 
   
}
