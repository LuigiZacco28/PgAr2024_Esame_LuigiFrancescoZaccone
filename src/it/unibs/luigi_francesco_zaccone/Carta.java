package it.unibs.luigi_francesco_zaccone;

public class Carta {
    private String tipo;
    private int valore;

    public Carta(String tipo, int valore) {
        this.tipo = tipo;
        this.valore = valore;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public void usaCarta() {
        // Logica per usare la carta
    }
}

