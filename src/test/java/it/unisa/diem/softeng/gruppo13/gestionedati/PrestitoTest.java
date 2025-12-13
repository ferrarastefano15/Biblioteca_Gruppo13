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
public class PrestitoTest {
    
    private Libro libro;
    private Utente utente;
    private LocalDate dataRestituzione;
    
    private Prestito prestito;
    
    @BeforeEach
    public void setUp(){
    List<String> autore = new ArrayList<>();
    autore.add("Dante Alighieri");
        
    libro = new Libro("La Divina Commedia", autore, 1321, "9788817018012", 3);
        
    utente = new Utente("Ernesto", "Grigi", "543210988", "ernesto.grigi@gmail.com");
        
    dataRestituzione = LocalDate.of(2026, 11, 16); 
    
    prestito = new Prestito(libro, utente, dataRestituzione);
        
    }
    
    public PrestitoTest(){
        
    }
    
    @Test
    public void testGetLibro(){
        System.out.println("getLibro");
        
        List<String> autore = new ArrayList<>();
        autore.add("Dante Alighieri");
        
        Libro expLibro = new Libro("La Divina Commedia", autore, 1321, "9788817018012", 3);
        Libro libro1 = prestito.getLibro();
        
        assertEquals(expLibro, libro1);
    }
    
    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        
        Utente expUtente = new Utente("Ernesto", "Grigi", "543210988", "ernesto.grigi@gmail.com");
        Utente utente1 = prestito.getUtente();
        
        assertEquals(expUtente, utente1);
    }
    
    @Test
    public void testGetDataRestituzione() {
        System.out.println("getDataRestituzione");
        
        LocalDate expData = LocalDate.of(2026, 11, 16);
        LocalDate data = prestito.getDataRestituzione();
        
        assertEquals(expData, data);
    }
}
