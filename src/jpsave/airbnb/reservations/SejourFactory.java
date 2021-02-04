package jpsave.airbnb.reservations;

import jpsave.airbnb.logements.Logement;

import java.util.Date;

// La classe est final car on ne veut pas que quelqu'un puisse faire de l'héritage dessus
public final class SejourFactory {

    private SejourFactory() {
        // Pour ne pas pouvoir appeler le constructeur
    }

    public static Sejour getSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
       if(nbNuits <= 5) {
           return new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
       } else {
           return new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
       }
    }
}
