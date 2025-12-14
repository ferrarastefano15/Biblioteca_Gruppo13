package it.unisa.diem.softeng.gruppo13.gestionefile;

import it.unisa.diem.softeng.gruppo13.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo13.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo13.gestionedati.Utente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class GestoreFile
 * @brief Gestione del salvataggio dei dati.
 * 
 * La classe `GestoreFile` è responsabile per l'implementazione del salvataggio 
 * e caricamento dei dati relativi a libri, utenti e prestiti in file esterni con
 * formato obj. 
 * @author Daniel, Andrea, Stefano, Daniele
 */
public class GestoreFile implements InterfacciaFile {
    
    private final String cartella;
    
    private static final String FILE_LIBRI = "libri.obj";
    private static final String FILE_UTENTI = "utenti.obj";
    private static final String FILE_PRESTITI = "prestiti.obj";

    
    /**
    * @brief Costruttore della classe GestoreFile.
    * 
    * Inizializza il gestore dei file con il nome della cartella specificata.
    * Se la cartella non esiste, provvede a crearla automaticamente.
    * 
    * @param[in] cartella Il nome della cartella in cui salvare e caricare i file.
    */
    public GestoreFile(String cartella) {
        this.cartella = cartella;
        File dir = new File(cartella);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * @brief Salva i dati dei libri, degli utenti e dei prestiti in tre file .obj
     * 
     * @see InterfacciaFile.salvaFile
     */
    @Override
    public void salvaFile(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {
        
        if (libri.isEmpty() && utenti.isEmpty() && prestiti.isEmpty()) {
            throw new IllegalArgumentException("Impossibile salvare: non sono presenti dati da salvare.");
        }
        
        salvaLista(FILE_LIBRI, libri);
        salvaLista(FILE_UTENTI, utenti);
        salvaLista(FILE_PRESTITI, prestiti);
        
        System.out.println("Salvataggio completato nella cartella: " + cartella);
    }

    /**
     * @brief Carica i dati dei libri, degli utenti e dei prestiti da tre file .obj
     * 
     * @see InterfacciaFile.caricaDati
     */
    @Override
    public void caricaDati(List<Libro> libri, List<Utente> utenti, List<Prestito> prestiti) {

        List<Libro> tmpLibri = (List<Libro>) caricaLista(FILE_LIBRI);
        List<Utente> tmpUtenti = (List<Utente>) caricaLista(FILE_UTENTI);
        List<Prestito> tmpPrestiti = (List<Prestito>) caricaLista(FILE_PRESTITI);

        if (tmpLibri != null) {
            libri.clear();
            libri.addAll(tmpLibri);
        }
        
        if (tmpUtenti != null) {
            utenti.clear();
            utenti.addAll(tmpUtenti);
        }

        if (tmpPrestiti != null) {
            List<Prestito> prestitiRicollegati = ricollegaPrestiti(libri, utenti, tmpPrestiti);
            
            prestiti.clear();
            prestiti.addAll(prestitiRicollegati);
        }
    }

    /**
     * @brief Ricollega i riferimenti dei prestiti agli oggetti originali.
     * 
     * Questo metodo ricrea la lista dei prestiti assicurandosi che
     * puntino agli oggetti Libro e Utente presenti effettivamente in memoria
     * nelle liste principali, evitando duplicati.
     * 
     * @param[in] libri Lista dei libri caricati.
     * @param[in] utenti Lista degli utenti caricati.
     * @param[in] prestitiGrezzi Lista dei prestiti letta dal file.
     * @return Lista di prestiti con i riferimenti aggiornati.
     */
    private List<Prestito> ricollegaPrestiti(List<Libro> libri, List<Utente> utenti, List<Prestito> prestitiGrezzi) {
        
        List<Prestito> nuoviPrestiti = new ArrayList<>();

        for (Prestito p : prestitiGrezzi) {
            
            Libro libroVero = p.getLibro(); 
            for (Libro l : libri) {
                if (l.equals(p.getLibro())) {
                    libroVero = l;
                    break; 
                }
            }

            Utente utenteVero = p.getUtente(); 
            for (Utente u : utenti) {
                if (u.equals(p.getUtente())) {
                    utenteVero = u;
                    break; 
                }
            }

            try {
                Prestito nuovo = new Prestito(libroVero, utenteVero, p.getDataRestituzione());
                nuoviPrestiti.add(nuovo);
                
            } catch (Exception ex) {
                Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, "Errore nella ricostruzione del prestito: " + ex.getMessage());
            }
        }
        return nuoviPrestiti;
    }

    
    /**
     * @brief Salva una lista generica su un file specifico.
     * 
     * Questo metodo di supporto scrive l'intera lista passata come parametro
     * nel file indicato all'interno della cartella di salvataggio.
     * 
     * @param[in] nomeFile Il nome del file in cui salvare.
     * @param[in] lista La lista di oggetti da salvare.
     */
    private void salvaLista(String nomeFile, List<?> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(cartella, nomeFile))))) {
            oos.writeObject(lista);
        } catch (IOException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, "Errore salvataggio " + nomeFile, ex);
        }
    }

    /**
     * @brief Carica una lista generica da un file specifico.
     * 
     * Questo metodo di supporto legge un oggetto dal file indicato e lo restituisce.
     * Restituisce null se il file non esiste o si verifica un errore.
     * 
     * @param[in] nomeFile Il nome del file da leggere.
     * @return L'oggetto letto dal file, oppure null in caso di errore.
     */
    private Object caricaLista(String nomeFile) {
        File f = new File(cartella, nomeFile);
        if (!f.exists()) return null;
        
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GestoreFile.class.getName()).log(Level.SEVERE, "Errore caricamento " + nomeFile, ex);
            return null;
        }
    }
}