package it.unibs.pgar2024_esame_luigi_francesco_zaccone;

import java.util.Arrays;
import java.util.List;

public class Ruolo {
    private String nome;
    private String obiettivo;

    public Ruolo(String nome, String obiettivo) {
        this.nome = nome;
        this.obiettivo = obiettivo;
    }
    
    // Metodo per creare una lista di ruoli predefinita
    public static List<Ruolo> creaRuoliPredefiniti() {
        return Arrays.asList(
            new Ruolo("Sceriffo", "Eliminare tutti i Fuorilegge e il Rinnegato"),
            new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"),
            new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"),
            new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri")
        );
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
}
