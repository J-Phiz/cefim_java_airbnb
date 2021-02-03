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
        setDateArrivee(dateArrivee);
        setNbNuits(nbNuits);
        setLogement(logement);
        setNbVoyageurs(nbVoyageurs);
        miseAJourDuTarif();
    }

    public Date getDateArrivee() {
        return (Date)dateArrivee.clone();
    }

    /**
     * Change la date d'arrivée du séjour
     * @param dateArrivee date à laquelle le séjour commence
     * @throws IllegalArgumentException si la date d'arrivée est dans le passé
     */
    public void setDateArrivee(Date dateArrivee) {
        Date oldDateArrivee = this.dateArrivee;
        this.dateArrivee = (Date)dateArrivee.clone();
        if(!verificationDateArrivee()) {
            this.dateArrivee = oldDateArrivee;
            throw new IllegalArgumentException();
        }
    }

    public Logement getLogement() {
        return logement;
    }

    /**
     * Change le logement associé a ce sejour
     * @param logement Nouveau logement a associer
     * @throws IllegalArgumentException si le logement ne peut pas accueillir l'ensemble des voyageurs du séjour
     */
    public void setLogement(Logement logement) {
        Logement oldLogement = this.logement;
        this.logement = logement;
        if(!verificationNombreDeVoyageurs()) {
            this.logement = oldLogement;
            throw new IllegalArgumentException();
        }
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }

    /**
     * Change le nombre de voyageurs pour le séjour
     * @param nbVoyageurs nombre de voyageurs pour le séjour
     * @throws IllegalArgumentException si le logement ne peut pas accueillir l'ensemble des voyageurs
     */
    public void setNbVoyageurs(int nbVoyageurs) {
        int oldNbVoyageurs = this.nbVoyageurs;
        this.nbVoyageurs = nbVoyageurs;
        if(!verificationNombreDeVoyageurs()) {
            this.nbVoyageurs = oldNbVoyageurs;
            throw new IllegalArgumentException();
        }
    }

    public int getNbNuits() {
        return nbNuits;
    }

    /**
     * Change le nombre de nuits pour le séjour
     * @param nbNuits nombre de nuits pour le séjour
     * @throws IllegalArgumentException si le type de séjour est incompatible avec le nombre de nuits
     */
    public void setNbNuits(int nbNuits) {
        if(!verificationNombreDeNuits(nbNuits)) {
            throw new IllegalArgumentException();
        } else {
            this.nbNuits = nbNuits;
        }
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
