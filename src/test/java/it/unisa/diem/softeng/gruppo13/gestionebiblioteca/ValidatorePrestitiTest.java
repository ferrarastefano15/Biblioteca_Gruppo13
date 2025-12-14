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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidatorePrestitiTest {
    
    private ValidatorePrestiti validatore = new ValidatorePrestiti();
    
    private Utente utente;
    private Libro libro;
    private LocalDate scadenza = LocalDate.of(2026, 6, 11);
    private Prestito prestito;
    
    private List<Prestito> prestitiAttuali = new ArrayList(); 
    
    @BeforeEach
    void setUp() throws Exception {
        
        utente = new Utente("Mario", "Rossi", "1", "mario.rossi@email.it");
        libro = new Libro("Il Signore degli Anelli", Arrays.asList("J.R.R. Tolkien"), 1954, "2222222222222", 3);
        
        prestito = new Prestito(libro, utente, scadenza); 
    }
    
    // utente, libro o scadenza nulli
    @Test
    void testValidaPrestito1() {
        
        libro = null;
        
        prestitiAttuali.add(prestito);
        
        assertThrows(Exception.class, () -> {
            validatore.validaPrestito(utente, libro, scadenza, prestitiAttuali);
        });
      
    }
    
    // data di scadenza antecedente alla data odierna
    @Test
    void testValidaPrestito2() {
        
        scadenza = LocalDate.of(2022, 1, 1);
               
        prestitiAttuali.add(prestito);
        
        assertThrows(Exception.class, () -> {
            validatore.validaPrestito(utente, libro, scadenza, prestitiAttuali);
        });
      
    }
    
    // copie disponibili <= 0
    @Test
    void testValidaPrestito3() {
        
        libro.setCopieDisponibili(0);
                
        prestitiAttuali.add(prestito);
        
        assertThrows(Exception.class, () -> {
            validatore.validaPrestito(utente, libro, scadenza, prestitiAttuali);
        });
      
    }
    
    // Numero di prestiti per utente >= 3
    @Test
    void testValidaPrestito4() throws Exception {
       
        prestitiAttuali.add(prestito);
        prestitiAttuali.add(prestito);
        prestitiAttuali.add(prestito);
        
        assertThrows(Exception.class, () -> {
            validatore.validaPrestito(utente, libro, scadenza, prestitiAttuali);
        });
      
    }
}
