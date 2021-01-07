package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    public boolean verificationNombreDeNuits() {
        return (nbNuits >= 1 && nbNuits < 6);
    }

    public boolean beneficiePromotion() {
        return false;
    }

    public int getTarif() {
       return tarif;
    }

    public void miseAJourDuTarif() {
        tarif = logement.getTarifParNuit() * nbNuits;
    }

    public void afficher() {
        super.afficher();
        System.out.print("\nLe prix de ce séjour est de " + tarif + "€.");
    }
}
