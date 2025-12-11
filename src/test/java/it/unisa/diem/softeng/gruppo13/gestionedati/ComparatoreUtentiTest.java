/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionedati;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Daniel
 */
public class ComparatoreUtentiTest {
    
    private ComparatoreUtenti comparatore;
    
    private Utente u1;
    private Utente u2;

    
    @BeforeEach
    void setUp() {
        comparatore = new ComparatoreUtenti();    
    }

    // Cognomi diversi
    @Test
    void testCompare1() {
        
        u1 = new Utente("Mario", "Rossi", "01","rossi@gmail.com");
        u2 = new Utente("Luca", "verdi", "02","verdil@gmail.com");
        int risultato = comparatore.compare(u1, u2);
        assertTrue(risultato < 0);
    }

    // Cognomi uguali, nomi diversi
    @Test
    void testCompare2() {
        u1 = new Utente("Marco", "Verdi", "03","verdim@gmail.com");
        u2 = new Utente("Luca", "verdi", "02","verdil@gmail.com");
        int risultato = comparatore.compare(u1, u2);
        assertTrue(risultato > 0);
    }
    
    // Cognomi e nomi uguali
    @Test
    void testCompare3(){
        u1 = new Utente("Marco", "Verdi", "08","verdim@gmail.com"); 
        u2 = new Utente("Marco", "Verdi", "03","verdim@gmail.com");
        int risultato = comparatore.compare(u2, u1);
        assertTrue(risultato<0);
    }

   
}
