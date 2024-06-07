package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
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
        List<Ruolo> ruoliDisponibili = new ArrayList<>();

        // Assegna il ruolo di Sceriffo
        Ruolo sceriffo = new Ruolo("Sceriffo", "Eliminare tutti i Fuorilegge e il Rinnegato");
        Giocatore nuovoGiocatore = new Giocatore("Giocatore 1", sceriffo);
        giocatori.add(nuovoGiocatore);

        // Aggiungi i ruoli in base al numero di giocatori
        switch (numGiocatori) {
            case 4:
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                break;
            case 5:
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                break;
            case 6:
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                break;
            case 7:
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge", "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato", "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                ruoliDisponibili.add(new Ruolo("Vice", "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                break;
            default:
                throw new IllegalArgumentException("Numero di giocatori non supportato");
        }

        // Mescola la lista dei ruoli disponibili
        Collections.shuffle(ruoliDisponibili);

        // Assegna i ruoli casuali ai restanti giocatori
        for (int i = 1; i < numGiocatori; i++) {
            Ruolo ruoloAssegnato = ruoliDisponibili.remove(0);
            nuovoGiocatore = new Giocatore("Giocatore " + (i + 1), ruoloAssegnato);
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

