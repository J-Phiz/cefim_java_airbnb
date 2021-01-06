package jpsave.airbnb;

import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.reservations.Reservation;
import jpsave.airbnb.reservations.Sejour;
import jpsave.airbnb.utilisateurs.Personne;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    
    public static void main(String[] args)throws Exception {

        Reservation reservation = creerReservation();
        reservation.afficher();
        Reservation reservation1 = creerReservation();
        reservation1.afficher();
    }

    private static Reservation creerReservation() throws Exception {
        Personne hote = new Personne("Peter", "Bardu", 28);
        Logement logement = new Logement(hote, 40, "81 Rue Colbert, 37000 Tours", 140, 5);

        Date dateSejour = dateFormat.parse("05/12/21");
        Sejour sejour =  new Sejour(dateSejour, 4, logement, 3);

//        Date dateReservation = dateFormat.parse("03/01/21");
        Date dateReservation = new Date();
        Personne voyageur = new Personne("Maxime", "Albert", 29);
        return new Reservation(sejour, voyageur, dateReservation);
    }
}
