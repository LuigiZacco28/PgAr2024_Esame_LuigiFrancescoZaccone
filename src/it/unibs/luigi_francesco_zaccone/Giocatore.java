package it.unibs.luigi_francesco_zaccone;


import java.util.ArrayList;
import java.util.List;

public class Giocatore {
    private String nome;
    private Ruolo ruolo;
    private List<Carta> carteInMano;

    public Giocatore(String nome, Ruolo ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.carteInMano = new ArrayList<>();
    }

    // Metodi getter e setter per il nome e il ruolo

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
    
    public void setCarte(Carta carta) {
        carteInMano.add(carta);
    }
    
// Altri metodi getter e setter
    
    public List<Carta> getCarteInMano() {
        return carteInMano;
    }

    public void setCarteInMano(List<Carta> carteInMano) {
        this.carteInMano = carteInMano;
    }
    
    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", ruolo=" + ruolo +
                '}';
    }
}

