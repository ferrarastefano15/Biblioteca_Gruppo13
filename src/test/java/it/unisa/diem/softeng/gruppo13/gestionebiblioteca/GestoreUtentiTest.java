/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel
 */
public class GestoreUtentiTest {
    
    private GestoreUtenti gestore;
    private Utente u1;
    private Utente u2;
    private Utente u3;

    @BeforeEach
    void setUp() {
        gestore = new GestoreUtenti();

        u1 = new Utente("Mario", "Rossi", "1", "mario.rossi@email.it");
        u2 = new Utente("Luca", "Bianchi", "2", "luca.bianchi@email.it");
        u3 = new Utente("Giulia", "Verdi", "3", "giulia.verdi@email.it");
    }

    // Utente valido
    @Test
    void testAggiungiUtente1() {
        
        System.out.println("aggiungiUtente1");

        gestore.aggiungiUtente(u1);

        List<Utente> lista = gestore.getUtenti(); 
        assertEquals(1, lista.size());
        assertTrue(lista.contains(u1));
    }

    // Utente duplicato
    @Test
    void testAggiungiUtente2() {
        
        System.out.println("aggiungiUtente2");

        gestore.aggiungiUtente(u1); 

        Utente clone = new Utente("Mario", "Rossi", "1", "mario.rossi@email.it");

        assertThrows(IllegalArgumentException.class, () -> {
            gestore.aggiungiUtente(clone);
        });
    }

    // Utente null
    @Test
    void testAggiungiUtente3() {
        
        System.out.println("aggiungiUtente3");
        gestore.aggiungiUtente(null);
        assertTrue(gestore.getUtenti().isEmpty());
    }


    @Test
    void testRimuoviUtente() {
        
        System.out.println("rimuoviUtente");
        
        gestore.aggiungiUtente(u1);
        gestore.aggiungiUtente(u2);

        gestore.rimuoviUtente(u1);

        assertEquals(1, gestore.getUtenti().size());
        assertFalse(gestore.getUtenti().contains(u1));
        assertTrue(gestore.getUtenti().contains(u2));
    }


    @Test
    void testModificaUtente() {
        
        System.out.println("modificautente");
      
        gestore.aggiungiUtente(u1); 

        Utente uModificato = new Utente("Mario", "Rossi-Verdi", "1", "nuova.email@email.it");

        gestore.modificaUtente(u1, uModificato);

        Utente trovato = gestore.getUtenti().get(0);
        assertEquals("Rossi-Verdi", trovato.getCognome());
        assertEquals("nuova.email@email.it", trovato.getEmail());
    }

    @Test
    void testRicercaUtente() {
        
        System.out.println("ricercaUtenti");
        
        gestore.aggiungiUtente(u1); 
        gestore.aggiungiUtente(u2); 
        gestore.aggiungiUtente(u3); 

        assertEquals(3, gestore.getUtenti().size());

        List<Utente> resCognome = gestore.cercaUtenti("Rossi");
        assertEquals(1, resCognome.size());

        assertEquals("1", resCognome.get(0).getMatricola()); 

        List<Utente> resMatricola = gestore.cercaUtenti("2");
        assertEquals(1, resMatricola.size());
        assertEquals("2", resMatricola.get(0).getMatricola());

        List<Utente> resVuoto = gestore.cercaUtenti("NonEsisto");
        assertTrue(resVuoto.isEmpty());
    }
    
}
