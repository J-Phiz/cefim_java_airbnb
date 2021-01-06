package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.outils.Utile;
import jpsave.airbnb.reservations.Reservation;
import jpsave.airbnb.reservations.Sejour;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Personne;
import jpsave.airbnb.utilisateurs.Voyageur;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public static void main(String[] args)throws Exception {
        creerReservation();
    }

    private static void creerReservation() throws Exception {
        System.out.println("-----------------------");

        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
        Maison maison1 = new Maison(hote1, 40, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        Voyageur voyageur1 = new Voyageur("Maxime", "Albert", 29);
        Sejour sejour1 =  new Sejour(Utile.creerDate("05/12/21"), 4, maison1, 3);
        Reservation reservation1 = new Reservation(sejour1, voyageur1, Utile.creerDate(3, 1, 2021));
        reservation1.afficher();

        System.out.println("-----------------------");

        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);
        Appartement appartement1 = new Appartement(hote2, 20, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        Voyageur voyageur2 = new Voyageur("Jacques", "Célère", 35);
        Sejour sejour2 =  new Sejour(Utile.creerDate("27/03/21"), 7, appartement1, 2);
        Reservation reservation2 = new Reservation(sejour2, voyageur2, Utile.creerDate(4, 1, 2021));
        reservation2.afficher();

        System.out.println("-----------------------");
    }

}
