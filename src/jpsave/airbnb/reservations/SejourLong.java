package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {
    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    public boolean verificationNombreDeNuits() {
        return (nbNuits >= 6 && nbNuits <= 31);
    }

    public boolean beneficiePromotion() {
        return true;
    }

    public int getTarif() {
        return tarif;
    }

    public void miseAJourDuTarif(int tarifParNuit) {
        tarif = tarifParNuit * nbNuits;
        promotion = tarif > 0 ? 20 * tarif / 100 : 0;
        tarif -= promotion;
    }

    public void afficher() {
        super.afficher();
        System.out.print("\nLe prix de ce séjour est de " + tarif + "€ (" + promotion + "€ de promotion).");
    }
}
