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
public class UtenteTest {
    
    private Utente utente;
    
    @BeforeEach
    public void setUp(){
        utente = new Utente("Mario", "Rossi", "123456789", "mariorossi@gmail.com");
    }
    
    public UtenteTest(){
        
    }
    
    @Test
    public void testGetNome(){
        
        System.out.println("getNome");
        String expResult = "Mario";
        String result = utente.getNome();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCognome(){
        
        System.out.println("getCognome");
        String expResult = "Rossi";
        String result = utente.getCognome();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetMatricola(){
        
        System.out.println("getMatricola");
        String expResult = "123456789";
        String result = utente.getMatricola();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmail(){
        
        System.out.println("getEmail");
        String expResult = "mariorossi@gmail.com";
        String result = utente.getEmail();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetNome(){
        
        System.out.println("setNome");
        String nome = "Luca";
        utente.setNome(nome);
        String expResult = "Luca";
        assertEquals(expResult, utente.getNome());
        
    }
    
    @Test
    public void testSetCognome(){
        
        System.out.println("setVerdi");
        String cognome = "Verdi";
        utente.setCognome(cognome);
        String expResult = "Verdi";
        assertEquals(expResult, utente.getCognome());
        
    }
    
    @Test
    public void testSetMatricola(){
        
        System.out.println("setMatricola");
        String matricola = "123";
        utente.setMatricola(matricola);
        String expResult = "123";
        assertEquals(expResult, utente.getMatricola());
    }
    
    @Test
    public void testSetEmail(){
        
        System.out.println("setEmail");
        String email = "lucav@libero.it";
        utente.setEmail(email);
        String expResult = "lucav@libero.it";
        assertEquals(expResult, utente.getEmail());
    }
    
    @Test
    public void testEquals(){
        
        System.out.println("Equals");
        Utente utente2 = new Utente("Mario", "Rossi", "123456789", "mariorossi@gmail.com");
        assertTrue(utente.equals(utente2));
        Utente utente3 = new Utente("Marco", "Rossi", "123456788", "mariorossi2@gmail.com");
        assertFalse(utente.equals(utente3));
        
    }
    
    
}
