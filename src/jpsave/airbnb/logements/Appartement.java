package jpsave.airbnb.logements;

import jpsave.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {
    private final int numeroEtage;
    private final int superficieBalcon;

    public Appartement(Hote hote,
                       int tarifParNuit,
                       String adresse,
                       int superficie,
                       int nbVoyageursMax,
                       int numeroEtage,
                       int superficieBalcon) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.numeroEtage = numeroEtage;
        this.superficieBalcon = superficieBalcon;
    }

    public boolean isPossedeBalcon() {
        return superficieBalcon > 0;
    }

    public int getSuperficieTotal() {
        return this.getSuperficie() + superficieBalcon;
    }

    public void afficher() {
        String numEtageString = "";
        if(numeroEtage == 1)
            numEtageString = "1er";
        else
            numEtageString = String.format("%dème", numeroEtage);

        this.getHote().afficher();
        System.out.print(".\nLe logement est un appartement situé " + this.getAdresse() + " au " + numEtageString + " étage.");
        System.out.print("\nSuperficie : " + getSuperficie() + "m2");
        if(superficieBalcon > 0)
            System.out.print("\nBalcon : Oui (" + superficieBalcon + "m2)");
        else
            System.out.print("\nBalcon : Non");
        System.out.print("\nSuperficie Totale : " + getSuperficieTotal() + "m2");
    }
}
