package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private List<Carta> carte;

    public Mazzo() {
        this.carte = new ArrayList<>();
        // Aggiungi carte al mazzo
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
