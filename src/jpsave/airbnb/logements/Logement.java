package jpsave.airbnb.logements;

import jpsave.airbnb.utilisateurs.Hote;

import java.lang.invoke.StringConcatFactory;

public abstract class Logement implements Comparable<Logement> {
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

    public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getTarifParNuit() { return tarifParNuit; }
    public Hote getHote() { return hote; }
    public String getAdresse() { return adresse; }
    public int getSuperficie() { return superficie; }
    public int getNbVoyageursMax() { return nbVoyageursMax; }

    public abstract int getSuperficieTotal();

    public abstract void afficher();

    public abstract void afficherCourt();

    @Override
    public int compareTo(Logement logement) {
        if (logement == null) throw new NullPointerException();
        int reponse = this.tarifParNuit - logement.getTarifParNuit();
        if(reponse == 0)
            reponse = this.superficie - logement.getSuperficie();
        if(reponse == 0)
            reponse = this.nbVoyageursMax - logement.getNbVoyageursMax();
        return reponse;
    }
}
