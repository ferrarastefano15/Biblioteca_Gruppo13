/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo13.elementi;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class Libro {
    
    private String titolo;
    private List<String> autori;
    private int anno;
    private String isbn;
    private int copieDisponibili;

    public Libro(String titolo, List<String> autori, int anno, String isbn, int copieDisponibili) {
        this.titolo = titolo;
        this.autori = autori;
        this.anno = anno;
        this.isbn = isbn;
        this.copieDisponibili = copieDisponibili;
    }
    
    

    public String getTitolo() {
        return titolo;
    }

    public List<String> getAutori() {
        return autori;
    }

    public int getAnno() {
        return anno;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }
    
    
    public void decrementaCopie() { this.copieDisponibili--; }
    public void incrementaCopie() { this.copieDisponibili++; }
    
    @Override
    public String toString(){
        return null;
    }
    
}
