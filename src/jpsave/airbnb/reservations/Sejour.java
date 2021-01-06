package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.outils.Utile;

import java.util.Date;

public class Sejour {
    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }

    public void afficher() {
        logement.afficher();
        System.out.print(".\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
        System.out.print("\nLe prix de ce séjour est de " + nbNuits * logement.getTarifParNuit() + "€.");
    }
}
