package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.outils.MaDate;
import jpsave.airbnb.reservations.Reservation;
import jpsave.airbnb.reservations.Sejour;
import jpsave.airbnb.reservations.SejourCourt;
import jpsave.airbnb.reservations.SejourLong;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Voyageur;


public class Main {

    public static void main(String[] args)throws Exception {
        creerReservation();
    }

    private static void creerReservation() throws Exception {
        // hotes
        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);

        // logements
        Maison maison1 = new Maison(hote1, 50, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        Maison maison2 = new Maison(hote2, 100, "Grand Place, 59000 Lille", 90, 4, 0, false);
        Appartement appartement1 = new Appartement(hote1, 10, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        Appartement appartement2 = new Appartement(hote2, 20, "29 Avenue Le Corbusier, 59800 Lille", 42, 3, 1, 0);

        // Voyageurs
        Voyageur voyageur1 = new Voyageur("Maxime", "Albert", 29);
        Voyageur voyageur2 = new Voyageur("Jacques", "Célère", 35);

        // Sejours
        SejourCourt sejour1 =  new SejourCourt(new MaDate("5/2/21"), 4, maison1, 3);
        SejourCourt sejour2 =  new SejourCourt(new MaDate("27/03/21"), 1, appartement1, 1);
        SejourLong sejour3 =  new SejourLong(new MaDate("12/04/2021"), 7, maison2, 4);
        SejourLong sejour4 =  new SejourLong(new MaDate("30/05/2021"), 20, appartement2, 2);

        // Reservations
        Reservation reservation1 = new Reservation(sejour1, voyageur1, new MaDate(3, 1, 2021));
        Reservation reservation2 = new Reservation(sejour2, voyageur2, new MaDate(4, 1, 2021));
        Reservation reservation3 = new Reservation(sejour3, voyageur1, new MaDate(5, 1, 2021));
        Reservation reservation4 = new Reservation(sejour4, voyageur2, new MaDate(6, 1, 2021));

        // Affichage
        System.out.println("Bienvenue chez AirBnB");
        System.out.println("-----------------------");
        reservation1.afficher();
        System.out.println("-----------------------");
        reservation2.afficher();
        System.out.println("-----------------------");
        reservation3.afficher();
        System.out.println("-----------------------");
        reservation4.afficher();
        System.out.println("-----------------------");
    }

}
