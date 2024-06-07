package it.unibs.luigi_francesco_zaccone;

public class Giocatore {
    private String nome;
    private Ruolo ruolo;

    public Giocatore(String nome, Ruolo ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
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
    
    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", ruolo=" + ruolo +
                '}';
    }
}

