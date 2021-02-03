package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return (nbNuits >= 1 && nbNuits < 6);
    }

    @Override
    public boolean verificationNombreDeNuits(int nbNuits) {
        return (nbNuits >= 1 && nbNuits < 6);
    }

    @Override
    public boolean beneficiePromotion() {
        return false;
    }

    @Override
    public int getTarif() {
       return tarif;
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = logement.getTarifParNuit() * nbNuits;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.print("\nLe prix de ce séjour est de " + tarif + "€.");
    }

    @Override
    public Object clone() {
        return new SejourCourt(
                this.getDateArrivee(),
                this.getNbNuits(),
                this.getLogement(),
                this.getNbVoyageurs());
    }
}
