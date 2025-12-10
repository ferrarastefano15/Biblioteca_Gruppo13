/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.gestionefile;

import it.unisa.diem.softeng.gruppo13.dati.Libro;
import it.unisa.diem.softeng.gruppo13.dati.Prestito;
import it.unisa.diem.softeng.gruppo13.dati.Utente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class GestoreFile
 * @brief Gestione del salvataggio dei dati.
 * 
 * La classe `GestoreFileOBJ` è responsabile per l'implementazione del salvataggio 
 * e caricamento dei dati relativi a libri, utenti e prestiti in file esterno con
 * formato obj. 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreFile implements InterfacciaFile {
  
    
    private final String nomeFile;
    
    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
    
    /**
     * @throws java.io.IOException
     * @brief Salva i dati dei libri, degli utenti e dei prestiti un file .obj
     * 
     * @see InterfacciaFile
     */
    @Override
    public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomeFile)))){
                    
            oos.writeObject(libri);
            oos.writeObject(utenti);
            oos.writeObject(prestiti);
            
            System.out.println("Salvataggio completato con successo su: " + nomeFile);
            
        } catch (IOException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    /**
     * @brief Carica i dati dei libri, degli utenti e dei prestiti da un file .obj
     * 
     * @see InterfacciaDati
     */
    @Override
    public void caricaDati(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        
        File f = new File(nomeFile);

        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            
            List<Libro> libriLetti = (List<Libro>) ois.readObject();
            List<Utente> utentiLetti = (List<Utente>) ois.readObject();
            List<Prestito> prestitiLetti = (List<Prestito>) ois.readObject();

            if (libriLetti != null) {
                libri.clear();
                libri.addAll(libriLetti);
            }
            
            if (utentiLetti != null) {
                utenti.clear();
                utenti.addAll(utentiLetti);
            }
            
            if (prestitiLetti != null) {
                prestiti.clear();
                prestiti.addAll(prestitiLetti);
            }

        } catch (IOException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, "Errore di I/O durante il caricamento", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, "Classe non trovata durante il caricamento", ex);
        }
        
    }
        
        
    
    
    
}
