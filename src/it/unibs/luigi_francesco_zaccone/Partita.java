package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partita {
	
	private int PF = 4 ;
	private int SceriffoPF = 5 ;
	
    private List<Giocatore> giocatori;
    private Mazzo mazzo;

    public Partita(int numGiocatori) {
        this.giocatori = new ArrayList<>();
        creaGiocatoriConRuoliCasuali(numGiocatori);
    }
    
    public List<Giocatore> getGiocatori() {
        return this.giocatori;
    }

    // Metodo per creare giocatori e assegnare loro ruoli casualmente
    private void creaGiocatoriConRuoliCasuali(int numGiocatori) {
        List<Ruolo> ruoliDisponibili = new ArrayList<>();
        this.mazzo = new Mazzo();
        // Assegna il ruolo di Sceriffo
        Ruolo sceriffo = new Ruolo("Sceriffo", SceriffoPF, "Eliminare tutti i Fuorilegge e il Rinnegato");
        Giocatore nuovoGiocatore = new Giocatore("Giocatore 1", sceriffo);
        giocatori.add(nuovoGiocatore);

        // Aggiungi i ruoli in base al numero di giocatori
        switch (numGiocatori) {
            case 4:
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato",PF, "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                break;
            case 5:
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato",PF, "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice",PF, "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                break;
            case 6:
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato",PF, "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice",PF, "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                break;
            case 7:
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Fuorilegge",PF, "Eliminare lo Sceriffo e gli altri Fuorilegge per incassare le taglie"));
                ruoliDisponibili.add(new Ruolo("Rinnegato",PF, "Diventare il nuovo Sceriffo eliminando tutti gli altri"));
                ruoliDisponibili.add(new Ruolo("Vice",PF, "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
                ruoliDisponibili.add(new Ruolo("Vice",PF, "Aiutare e proteggere lo Sceriffo, perseguendo i suoi stessi obiettivi"));
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
    
    public void assegnaCarte(Giocatore giocatore) {
        int quantitaCarte = giocatore.getRuolo().getPuntiVita();
        List<Carta> carteAssegnate = mazzo.distribuisci(quantitaCarte);
        giocatore.setCarteInMano(carteAssegnate);
     // Rimuovi le carte assegnate dal mazzo
        mazzo.getCarte().removeAll(carteAssegnate);
    }
    
    public void stampaGiocatoriConRuoli() {
        for (Giocatore giocatore : giocatori) {
            System.out.println(giocatore.getNome() + ": " + giocatore.getRuolo().getNome()
                    + "\nObiettivo: " + giocatore.getRuolo().getObiettivo());
        }
    }
    
    public void stampaCarteDeiGiocatori() {
        for (Giocatore giocatore : giocatori) {
            System.out.println("Carte di " + giocatore.getNome() + ":");
            List<Carta> carteInMano = giocatore.getCarteInMano();
            for (Carta carta : carteInMano) {
                System.out.println("- " + carta.getTipo());
            }
            System.out.println(); // Aggiungi una riga vuota per separare i giocatori
        }
    }
    
    
}

