package it.unibs.luigi_francesco_zaccone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArnaldoWestMain {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);

        int numGiocatori;
        
     // Ciclo fino a quando l'utente non inserisce un numero valido di giocatori
        do {
            System.out.println("Benvenuto a Arnaldo West! Quanti giocatori vogliono partecipare (da 4 a 7)?");
            while (!scanner.hasNextInt() || (numGiocatori = scanner.nextInt()) < 4 || numGiocatori > 7) {
                System.out.println("Inserisci un numero valido compreso tra 4 e 7!");
                scanner.nextLine(); // Pulisce il buffer di input
            }
        } while (numGiocatori < 4 || numGiocatori > 7);
        
       
        
       // Crea una nuova partita con il numero di giocatori specificato
        Partita partita = new Partita(numGiocatori);
        
        // Stampare i giocatori con i rispettivi ruoli
        partita.stampaGiocatoriConRuoli();
        for (Giocatore giocatore : partita.getGiocatori()) {
        partita.assegnaCarte(giocatore);
        }
        partita.stampaCarteDeiGiocatori();

    }
}

