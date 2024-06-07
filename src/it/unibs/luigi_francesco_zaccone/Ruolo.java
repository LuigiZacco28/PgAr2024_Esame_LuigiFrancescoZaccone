package it.unibs.luigi_francesco_zaccone;

import java.util.Arrays;
import java.util.List;

public class Ruolo {
    private String nome;
    private String obiettivo;
    private int puntiVita;

    public Ruolo(String nome,int puntiVita, String obiettivo) {
        this.nome = nome;
        this.obiettivo = obiettivo;
        this.puntiVita = puntiVita;
    }

    // Metodi getter e setter per il nome e l'obiettivo

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObiettivo() {
        return obiettivo;
    }

    public void setObiettivo(String obiettivo) {
        this.obiettivo = obiettivo;
    }
    
    public String descriviRuolo() {
        return "Ruolo: " + nome + "\nObiettivo: " + obiettivo;
    }
    
    public int getPuntiVita() {
        return puntiVita;
    }
    
    public void setpuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }
}
