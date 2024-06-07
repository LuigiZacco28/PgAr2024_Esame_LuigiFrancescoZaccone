package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import java.util.*;



public class Partita {
	
	private static final String MENU = "Scegliere opzione: ";
	private static final String[] SCELTA_AZIONE = {"passa il turno", "gioca una o più carte"};
	private int PF = 4 ;
	private int SceriffoPF = 5 ;
	private final static int CARTE_INIZIO_TURNO = 2 ;
    private List<Giocatore> giocatori;
    private Mazzo mazzo;
    int scelta;
    private int numGiocatoriAttuali;
    
    public Partita(int numGiocatori) {
        this.giocatori = new ArrayList<>();
        creaGiocatoriConRuoliCasuali(numGiocatori);
    }
    
    public List<Giocatore> getGiocatori() {
        return this.giocatori;
    }

    // Metodo per creare giocatori e assegnare loro ruoli casualmente
    private void creaGiocatoriConRuoliCasuali(int numGiocatori) {
    	numGiocatoriAttuali=numGiocatori;
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
        mazzo.mescola(); // Chiamata al metodo mescola()
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
    
    public void pescaCarte(Giocatore giocatore, int quantitaCarte) {
        List<Carta> carteAssegnate = mazzo.distribuisci(quantitaCarte);
        giocatore.setCarteInMano(carteAssegnate);
     // Rimuovi le carte assegnate dal mazzo
        mazzo.getCarte().removeAll(carteAssegnate);
    }
    
    public int ottieniDistanzaArma(String nomeArma) {
        for (Carta carta : mazzo.getCarte()) {
            if (carta instanceof CartaEquipaggiabile && carta.getTipo().equalsIgnoreCase(nomeArma)) {
                return ((CartaEquipaggiabile) carta).getDistanza();
            }
        }
        return -1; // Ritorna un valore di default se l'arma non è trovata
    }
    
    public int selezionaArma(Giocatore giocatore) {
        List<Carta> carteInMano = giocatore.getCarteInMano();
        for (Carta carta : carteInMano) {
            if (carta instanceof CartaEquipaggiabile) {
                return ((CartaEquipaggiabile) carta).getDistanza();
            }
        }
        return -1; // Ritorna un valore di default se nessuna arma è trovata
    }
    
    public List<Integer> calcolaGiocatoriRaggiungibili(int posizioneCorrente, int distanza) {
        List<Integer> giocatoriRaggiungibili = new ArrayList<>();
        
        // Giocatori raggiungibili in avanti
        for (int i = 1; i <= distanza; i++) {
            int indice = (posizioneCorrente + i) % numGiocatoriAttuali;
            giocatoriRaggiungibili.add(indice);
        }
        
        // Giocatori raggiungibili indietro
        for (int i = 1; i <= distanza; i++) {
            int indice = (posizioneCorrente - i + numGiocatoriAttuali) % numGiocatoriAttuali;
            giocatoriRaggiungibili.add(indice);
        }
        
        return giocatoriRaggiungibili;
    }
    
    public void giocaBang(Giocatore giocatore) {
    List<Carta> carteInMano = giocatore.getCarteInMano();
    for (Carta carta : carteInMano) {
    	if (carta.getTipo().equalsIgnoreCase("Bang")) {
    		scegliBersaglio(selezionaArma(giocatore));  		
        }else {
            System.out.println("Non hai neanche una carta 'Bang'!");
            break;
        }
    }
    System.out.println(); // Aggiungi una riga vuota per separare i giocatori
    }
    
    public void turnoGiocatore(Giocatore giocatore) {
        pescaCarte(giocatore, CARTE_INIZIO_TURNO);
        MyMenu menu = new MyMenu(MENU, SCELTA_AZIONE);
    	
        do {
            scelta = menu.scegli();
            
            switch(scelta) {
                case 1: // passa il turno
                	
                    break;
                case 2: // gioca carta
                	giocaBang();
                    break;
                default:
                    System.out.println("Inserire un valore corretto");
                    break;
            }
        } while(scelta == 1 && scelta == 2);
    }
    
    public void stampaGiocatoriConRuoli() {
        for (Giocatore giocatore : giocatori) {
            System.out.println(giocatore.getNome() + ": " + giocatore.getRuolo().getNome()
                    + "\nObiettivo: " + giocatore.getRuolo().getObiettivo());
        }
    }
    
    public void stampaCarteDeiGiocatori(Giocatore giocatore) {
        
            System.out.println("Carte di " + giocatore.getNome() + ":");
            List<Carta> carteInMano = giocatore.getCarteInMano();
            for (Carta carta : carteInMano) {
            	int i =0;
                System.out.println(i+ ". " + carta.getTipo());
                i++;
            }
            System.out.println(); // Aggiungi una riga vuota per separare i giocatori
        
    }
    
 
}

