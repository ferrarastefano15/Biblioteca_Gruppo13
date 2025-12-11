/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionefile;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class GestoreFileTest {


    private GestoreFile gestoreFile;
    private final String FILE_TEST = "test_archivio_temp.bin";

    private List<Libro> libri;
    private List<Utente> utenti;
    private List<Prestito> prestiti;

    @BeforeEach
    void setUp() {
        gestoreFile = new GestoreFile(FILE_TEST);
        
        libri = new ArrayList<>();
        utenti = new ArrayList<>();
        prestiti = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        File f = new File(FILE_TEST);
        if (f.exists()) {
            f.delete();
        }
    }

    @Test
    void testSalvaFile() {
        System.out.println("SalvaFile");

        Utente u = new Utente("Mario", "Rossi", "123456789", "mariorossi@gmail.com");
        Libro l = new Libro("Il Talismano", Arrays.asList("Autore"), 1984, "9788878240087", 2);
        Prestito p = new Prestito(l, u, LocalDate.now());

        libri.add(l);
        utenti.add(u);
        prestiti.add(p);

        gestoreFile.salvaFile(libri, utenti, prestiti);

        File f = new File(FILE_TEST);
        
        // Il file deve esistere
        assertTrue(f.exists());
        // Il file non deve essere vuoto 
        assertTrue(f.length() > 0);
    }

    @Test 
    void testCaricaDati() { 
        System.out.println("CaricaDati");

        Utente u = new Utente("Mario", "Rossi", "123456789", "mariorossi@gmail.com");
        Libro l = new Libro("Il Talismano", Arrays.asList("Autore"), 1984, "9788878240087", 2);
    
        libri.add(l);
        utenti.add(u);

        gestoreFile.salvaFile(libri, utenti, prestiti);

        List<Libro> libriCaricati = new ArrayList<>();
        List<Utente> utentiCaricati = new ArrayList<>();
        List<Prestito> prestitiCaricati = new ArrayList<>();

        try {
            gestoreFile.caricaDati(libriCaricati, utentiCaricati, prestitiCaricati);
        } catch (Exception e) {
            fail("Il caricamento ha lanciato un'eccezione inattesa: " + e.getMessage());
        }

        assertEquals(1, libriCaricati.size());
    
        assertEquals(1, utentiCaricati.size()); 

        Libro lCaricato = libriCaricati.get(0);
        Utente uCaricato = utentiCaricati.get(0);

        assertEquals("Il Talismano", lCaricato.getTitolo());
        assertEquals("9788878240087", lCaricato.getIsbn());
        assertEquals("Mario", uCaricato.getNome());
        assertEquals("Rossi", uCaricato.getCognome());
    }
}