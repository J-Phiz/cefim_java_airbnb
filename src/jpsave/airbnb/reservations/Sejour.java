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
        this.dateArrivee = (Date)dateArrivee.clone();
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        miseAJourDuTarif();
    }

    public Date getDateArrivee() {
        return (Date)dateArrivee.clone();
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = (Date)dateArrivee.clone();
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }

    public void setNbVoyageurs(int nbVoyageurs) {
        this.nbVoyageurs = nbVoyageurs;
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public void setNbNuits(int nbNuits) {
        this.nbNuits = nbNuits;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
    /* Même si cette fct est demandée par l'interface
     * comme la classe Sejour est abstraite
     * il suffit que les enfants définisse la fonction
     */
    //public abstract boolean verificationNombreDeNuits();

    @Override
    public boolean verificationDateArrivee() {
        return dateArrivee.after(new Date());
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return (nbVoyageurs <= logement.getNbVoyageursMax());
    }

    public abstract void miseAJourDuTarif();

    @Override
    public void afficher() {
        logement.afficher();
        System.out.print(".\nLa date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
    }
}
