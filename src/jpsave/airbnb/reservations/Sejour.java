package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public abstract class Sejour implements SejourInterface {
    private Date dateArrivee;
    protected Logement logement;
    private int nbVoyageurs;
    protected int nbNuits;
    protected int tarif;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        miseAJourDuTarif();
    }

    /* Même si cette fct est demandée par l'interface
     * comme la classe Sejour est abstraite
     * il suffit que les enfants définisse la fonction
     */
    //public abstract boolean verificationNombreDeNuits();

    public boolean verificationDateArrivee() {
        return dateArrivee.after(new Date());
    }

    public boolean verificationNombreDeVoyageurs() {
        return (nbVoyageurs <= logement.getNbVoyageursMax());
    }

    public abstract void miseAJourDuTarif();

    public void afficher() {
        logement.afficher();
        System.out.print(".\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
    }
}
