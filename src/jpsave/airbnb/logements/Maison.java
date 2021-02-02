package jpsave.airbnb.logements;

import jpsave.airbnb.utilisateurs.Hote;

public class Maison extends Logement {
    private final int superficieJardin;
    private final boolean possedePiscine;

    public Maison(Hote hote,
                  int tarifParNuit,
                  String adresse,
                  int superficie,
                  int nbVoyageursMax,
                  int superficieJardin,
                  boolean possedePiscine) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    public int getSuperficieTotal() {
        return this.getSuperficie() + superficieJardin;
    }

    public void afficher() {
        this.getHote().afficher();
        System.out.print(".\nLe logement est une maison située " + this.getAdresse() + ".");
        System.out.print("\nSuperficie : " + getSuperficie() + "m2");
        if(superficieJardin > 0)
            System.out.print("\nJardin : Oui (" + superficieJardin + "m2)");
        else
            System.out.print("\nJardin : Non");
        System.out.print("\nPiscine : " + (possedePiscine ? "Oui" : "Non"));
        System.out.print("\nSuperficie Totale : " + getSuperficieTotal() + "m2");
    }
}
