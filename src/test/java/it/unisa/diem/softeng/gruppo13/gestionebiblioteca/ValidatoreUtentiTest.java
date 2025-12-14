/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionebiblioteca;

import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidatoreUtentiTest {
    
    private ValidatoreUtenti validatore = new ValidatoreUtenti();
    
    private Utente utente;
    
    @BeforeEach
    void setUp() {
        
        utente = new Utente("Stefano", "Ferrara", "1", "stefano.ferrara@email.it");
        
    }
    
    // utente nullo
    @Test
    void testValidaUtente1() {
        
        utente = null;
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
    }
    
    // nome vuoto
    @Test
    void testValidaUtente2() {
        
        utente.setNome("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
    }
    
    // nome che contiene numeri
    @Test
    void testValidaUtente3() {
        
        utente.setNome("St3fano");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
        
    }
    
    // cognome vuoto
    @Test
    void testValidaUtente4() {
        
        utente.setCognome("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
        
    }
    
    // cognome che contiene numeri
    @Test
    void testValidaUtente5() {
        
        utente.setCognome("1234");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
        
    }
    
    // matricola vuota
    @Test
    void testValidaUtente6() {
        
        utente.setMatricola("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
        
    }
    
    // email vuota
    @Test
    void testValidaUtente7() {
        
        utente.setEmail("");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
        
    }
    
    //email senza @ o .
    @Test
    void testValidaUtente8() {
        
        utente.setEmail("abcd@email");
        
        assertThrows(Exception.class, () -> {
            validatore.validaUtente(utente);
        });
    }
}
