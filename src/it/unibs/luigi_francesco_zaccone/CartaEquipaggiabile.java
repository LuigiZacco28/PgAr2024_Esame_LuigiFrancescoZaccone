package it.unibs.luigi_francesco_zaccone;

public class CartaEquipaggiabile extends Carta {
    private int distanza;

    public CartaEquipaggiabile(String tipo, int distanza) {
        super(tipo);
        this.distanza = distanza;
    }

    public int getDistanza() {
        return distanza;
    }

    public void setDistanza(int distanza) {
        this.distanza = distanza;
    }
}