/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class GestorePrestitiTest {
    
    private GestorePrestiti gestore;
    private Utente u1;
    private Utente u2;
    private Libro l1; // Copie disponibili
    private Libro l2; // Copie esaurite
    private Libro l3; // Una copia
    
    @BeforeEach
    void setUp() {
        gestore = new GestorePrestiti();

        u1 = new Utente("Mario", "Rossi", "001", "mario@email.it");
        u2 = new Utente("Luigi", "Verdi", "002", "luigi@email.it");

        l1 = new Libro("Java Base", Arrays.asList("Autore A"), 2020, "0000000000001", 5);
        l2 = new Libro("Java Advanced", Arrays.asList("Autore B"), 2021, "0000000000002", 0);
        l3 = new Libro("C++", Arrays.asList("Autore C"), 1999, "0000000000003", 1);
    }
    
    // Prestito valido
    @Test
    public void testAggiungiPrestito1() throws Exception{
        
        System.out.println("aggiungiPrestito1");
        gestore.aggiungiPrestito(u1, l1, LocalDate.now().plusDays(30));

        List<Prestito> lista = gestore.getPrestiti();
        assertEquals(1, lista.size());
        
        Prestito p = lista.get(0);
        assertEquals(u1, p.getUtente());
        assertEquals(l1, p.getLibro());
        
        // Le copie diminuiscono
        assertEquals(4, l1.getCopieDisponibili());
    }
    
    // Prestito non valido per copie esaurite
    @Test
    public void testAggiungPrestito2(){
        
        Exception e = assertThrows(Exception.class, () -> {
            gestore.aggiungiPrestito(u1, l2, LocalDate.now());
        });
        
        assertTrue(e.getMessage().toLowerCase().contains("copie"));
    }
        
    // Prestito non valido per 3 prestiti già attivi
    @Test
    public void testAggiungiPrestito3() throws Exception{
        
        gestore.aggiungiPrestito(u1, l1, LocalDate.now());
        gestore.aggiungiPrestito(u1, l1, LocalDate.now());
        gestore.aggiungiPrestito(u1, l1, LocalDate.now());

        assertEquals(3, gestore.getPrestiti().size());

        assertThrows(Exception.class, () -> {
            gestore.aggiungiPrestito(u1, l3, LocalDate.now());
        });
    }
    
    @Test
    void testRestituisciLibro() throws Exception {

        gestore.aggiungiPrestito(u1, l3, LocalDate.now()); 
        Prestito p = gestore.getPrestiti().get(0);
        
        assertEquals(0, l3.getCopieDisponibili());

        gestore.restituisciLibro(p);

        assertEquals(0, gestore.getPrestiti().size());
        assertEquals(1, l3.getCopieDisponibili());
    }


    @Test
    void testHaPrestitiAttiviUtente() throws Exception {
        
        assertFalse(gestore.haPrestitiAttivi(u1)); 
        
        gestore.aggiungiPrestito(u1, l1, LocalDate.now());
        
        assertTrue(gestore.haPrestitiAttivi(u1)); 
        assertFalse(gestore.haPrestitiAttivi(u2)); 
    }

    @Test
    void testHaPrestitiAttiviLibro() throws Exception {
        
        assertFalse(gestore.haPrestitiAttivi(l1));
        
        gestore.aggiungiPrestito(u1, l1, LocalDate.now());
        
        assertTrue(gestore.haPrestitiAttivi(l1));
        assertFalse(gestore.haPrestitiAttivi(l3));
    }

    @Test
    void testGetOrdinati() throws Exception {
        
        LocalDate oggi = LocalDate.now();
        LocalDate domani = oggi.plusDays(1);
        LocalDate dopodomani = oggi.plusDays(2);

        gestore.aggiungiPrestito(u1, l1, domani); 
        gestore.aggiungiPrestito(u2, l1, dopodomani);  
        gestore.aggiungiPrestito(u1, l1, oggi);  

        List<Prestito> ordinati = gestore.getOrdinati();

        assertEquals(3, ordinati.size());
        
        assertEquals(oggi, ordinati.get(0).getDataRestituzione());
        assertEquals(domani, ordinati.get(1).getDataRestituzione());
        assertEquals(dopodomani, ordinati.get(2).getDataRestituzione());
    }
    
}
