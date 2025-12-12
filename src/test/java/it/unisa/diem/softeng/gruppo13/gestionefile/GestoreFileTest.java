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
        File dir = new File(FILE_TEST);
        
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            
            dir.delete();
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

        File cartella = new File(FILE_TEST);
        assertTrue(cartella.exists(), "La cartella deve esistere");
        assertTrue(cartella.isDirectory(), "Deve essere una directory");

        File fileLibri = new File(cartella, "libri.obj");
        File fileUtenti = new File(cartella, "utenti.obj");
        File filePrestiti = new File(cartella, "prestiti.obj");

        assertTrue(fileLibri.exists(), "File libri.obj mancante");
        assertTrue(fileLibri.length() > 0, "File libri vuoto");

        assertTrue(fileUtenti.exists(), "File utenti.obj mancante");
        assertTrue(fileUtenti.length() > 0, "File utenti vuoto");

        assertTrue(filePrestiti.exists(), "File prestiti.obj mancante");
        assertTrue(filePrestiti.length() > 0, "File prestiti vuoto");
    }

    @Test 
    void testCaricaDatiConRiferimenti() { 
        System.out.println("CaricaDati Completo (con verifica Riferimenti)");

        Utente u = new Utente("Mario", "Rossi", "123456789", "mariorossi@gmail.com");
        Libro l = new Libro("Il Talismano", Arrays.asList("King"), 1984, "9788878240087", 2);
        
        Prestito p = new Prestito(l, u, LocalDate.now());
    
        libri.add(l);
        utenti.add(u);
        prestiti.add(p); 

        gestoreFile.salvaFile(libri, utenti, prestiti);

        List<Libro> libriCaricati = new ArrayList<>();
        List<Utente> utentiCaricati = new ArrayList<>();
        List<Prestito> prestitiCaricati = new ArrayList<>();

        try {
            gestoreFile.caricaDati(libriCaricati, utentiCaricati, prestitiCaricati);
        } catch (Exception e) {
            fail("Eccezione inattesa: " + e.getMessage());
        }

        assertEquals(1, libriCaricati.size());
        assertEquals(1, utentiCaricati.size());
        assertEquals(1, prestitiCaricati.size());

        Libro lCaricato = libriCaricati.get(0);
        Prestito pCaricato = prestitiCaricati.get(0);

        assertEquals("Il Talismano", lCaricato.getTitolo());
        
        
        assertSame(lCaricato, pCaricato.getLibro(), "Errore: Il libro nel prestito è una copia, non l'oggetto originale!");
            
        assertSame(utentiCaricati.get(0), pCaricato.getUtente(), "Errore: L'utente nel prestito è una copia, non l'oggetto originale!");
    }
}