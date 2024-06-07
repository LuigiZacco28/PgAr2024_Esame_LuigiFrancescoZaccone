package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
	
	private List<Carta> carte;
	private final String BORDO_B = "Bordo Blu";
    private final String BORDO_M = "Bordo Marrone";
	public Mazzo() {
        this.carte = new ArrayList<>();
        
        // Aggiungi le carte equipaggiabili
        aggiungiCarteEquipaggiabili("Schofield", 3, 2); // 3 Schofield con distanza 2
        aggiungiCarteEquipaggiabili("Remington", 1, 3); // 1 Remington con distanza 3
        aggiungiCarteEquipaggiabili("Rev. Carabine", 1, 4); // 1 Rev. Carabine con distanza 4
        aggiungiCarteEquipaggiabili("Winchester", 1, 5); // 1 Winchester con distanza 5
        
        // Aggiungi le carte Gioca e Scarta
        aggiungiCarteGiocaEScarta("Bang", 50);
        aggiungiCarteGiocaEScarta("Mancato", 24);
    }
	private void aggiungiCarteEquipaggiabili(String tipo, int quantita, int distanza) {
        for (int i = 0; i < quantita; i++) {
            carte.add(new CartaEquipaggiabile(tipo, distanza));
        }
    }
	
	private void aggiungiCarteGiocaEScarta(String tipo, int quantita) {
        for (int i = 0; i < quantita; i++) {
            carte.add(new CartaGiocaEScarta(tipo));
        }
    }
	
    public List<Carta> getCarte() {
        return carte;
    }

    public void setCarte(List<Carta> carte) {
        this.carte = carte;
    }

    public void mescola() {
        Collections.shuffle(carte);
    }

    public List<Carta> distribuisci(int numeroCarte) {
        List<Carta> carteDistribuite = new ArrayList<>();
        for (int i = 0; i < numeroCarte && !carte.isEmpty(); i++) {
            carteDistribuite.add(carte.remove(0));
        }
        return carteDistribuite;
    }
}
