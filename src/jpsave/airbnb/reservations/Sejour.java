package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        logement.afficher();
        System.out.print("\nLa date d'arrivée est le " + dateFormat.format(dateArrivee) + " pour " + nbNuits + " nuits.");
        System.out.print("\nLe prix de ce séjour est de " + nbNuits * logement.getTarifParNuit() + "€.");
    }
}
