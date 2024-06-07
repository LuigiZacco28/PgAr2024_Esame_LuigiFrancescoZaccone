package it.unibs.pgar2024_esame_luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Partita {
    private List<Giocatore> giocatori;
    private String stato;

    public Partita(int numGiocatori) {
        this.giocatori = new ArrayList<>();
        this.stato = "In attesa";
        creaGiocatoriConRuoliCasuali(numGiocatori);
    }

    // Metodo per creare giocatori e assegnare loro ruoli casualmente
    private void creaGiocatoriConRuoliCasuali(int numGiocatori) {
        // Ottieni una lista di ruoli disponibili
        List<Ruolo> ruoliDisponibili = new ArrayList<>(Arrays.asList(
            new Ruolo("Sceriffo", "Eliminare tutti i Fuorilegge e il Rinnegato"),
            new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"),
            new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"),
            new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri")
        ));
        // Mescola la lista dei ruoli disponibili
        Collections.shuffle(ruoliDisponibili);

        // Assegna un ruolo casuale a ciascun giocatore
        for (int i = 0; i < numGiocatori; i++) {
            Ruolo ruoloAssegnato = ruoliDisponibili.remove(0);
            Giocatore nuovoGiocatore = new Giocatore("Giocatore " + (i + 1), ruoloAssegnato);
            giocatori.add(nuovoGiocatore);
        }
    }

    public void stampaGiocatoriConRuoli() {
        for (Giocatore giocatore : giocatori) {
            System.out.println(giocatore.getNome() + ": " + giocatore.getRuolo().getNome() 
                    + "\nObiettivo: " + giocatore.getRuolo().getObiettivo());
        }
    }
}

