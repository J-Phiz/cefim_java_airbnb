package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {
    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return (nbNuits >= 6 && nbNuits <= 31);
    }

    @Override
    public boolean verificationNombreDeNuits(int nbNuits) {
        return (nbNuits >= 6 && nbNuits <= 31);
    }

    @Override
    public boolean beneficiePromotion() {
        return true;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = logement.getTarifParNuit() * nbNuits;
        promotion = tarif > 0 ? 20 * tarif / 100 : 0;
        tarif -= promotion;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.print("\nLe prix de ce séjour est de " + tarif + "€ (" + promotion + "€ de promotion).");
    }

    @Override
    public Object clone() {
        return new SejourLong(
                this.getDateArrivee(),
                this.getNbNuits(),
                this.getLogement(),
                this.getNbVoyageurs());
    }
}
