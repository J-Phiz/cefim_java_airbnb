package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public abstract class Sejour implements SejourInterface {
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

    public boolean verificationDateArrivee() {
        return dateArrivee.after(new Date());
    }

    public boolean verificationNombreDeNuits() {
        return (nbNuits >= 1 && nbNuits <= 31);
    }

    public boolean verificationNombreDeVoyageurs() {
        return (nbVoyageurs <= logement.getNbVoyageursMax());
    }

    public void afficher() {
        logement.afficher();
        System.out.print(".\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
    }
}
