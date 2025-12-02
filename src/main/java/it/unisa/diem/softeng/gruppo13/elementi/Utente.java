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
public class Utente {
    
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private List<Prestito> prestitiAttivi;

    public Utente(String nome, String cognome, String matricola, String email, List<Prestito> prestitiAttivi) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
        this.prestitiAttivi = prestitiAttivi;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getEmail() {
        return email;
    }

    public List<Prestito> getPrestitiAttivi() {
        return prestitiAttivi;
    }
    
    @Override
    public String toString(){
        return null;
    }
    
}
