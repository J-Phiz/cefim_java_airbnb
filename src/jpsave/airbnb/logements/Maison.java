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

    public boolean isPossedePiscine() {
        return possedePiscine;
    }

    public boolean isPossedeJardin() {
        return superficieJardin > 0;
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

    @Override
    public void afficherCourt() {
        String resultat = String.format("type=%s ; tarif=%3d ; superficie=%3d ; maxpers=%3d ; balcon=%d ; jardin=%d ; piscine=%d ; adresse=%s",
                "Maison", getTarifParNuit(), getSuperficie(), getNbVoyageursMax(), 0,
                isPossedeJardin() ? 1 : 0,
                isPossedePiscine() ? 1 : 0,
                getAdresse());
        System.out.println(resultat);
    }

}
