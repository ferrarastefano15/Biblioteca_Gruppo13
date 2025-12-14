/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidatoreLibriTest {
    
    private ValidatoreLibri validatore = new ValidatoreLibri();
    
    private Libro libro;
    
    @BeforeEach
    void setUp() {
        
        libro = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "1111111111111", 5);
        
    }
    
    // libro nullo
    @Test
    void testValidaLibro1() {
        
        libro = null;
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // titolo vuoto
    @Test
    void testValidaLibro2() {
        
        libro.setTitolo("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // nessun autore
    @Test
    void testValidaLibro3() {
        
        libro.setAutori("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // ISBN vuoto
    @Test
    void testValidaLibro4() {
        
        libro.setIsbn("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // ISBN =! 13
    @Test
    void testValidaLibro5() {
        
        libro.setIsbn("10203");
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // anno futuro
    @Test
    void testValidaLibro6() {
        
        libro.setAnno(2027);
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(libro);
        });
    }
    
    // copie disponibili < 1
    @Test
    void testValidaLibro7() {
        
        Libro l = new Libro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, "1111111111111", 0);
        
        assertThrows(Exception.class, () -> {
            validatore.validaLibro(l);
        });
    }
    
}
