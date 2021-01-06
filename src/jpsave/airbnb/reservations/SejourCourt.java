package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {
    private int tarif;

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       super(dateArrivee, nbNuits, logement, nbVoyageurs);
       tarif = logement.getTarifParNuit() * nbNuits;
    }

    public boolean beneficiePromotion() {
        return false;
    }

    public int getTarif() {
       return tarif;
    }

    public void afficher() {
        super.afficher();
        System.out.print("\nLe prix de ce séjour est de " + tarif + "€.");
    }
}
