package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

public class SejourFactory {
    public static Sejour getSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       if(nbNuits <= 5) {
           return new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
       } else {
           return new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
       }
    }
}
