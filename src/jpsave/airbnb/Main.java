package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.outils.Utile;
import jpsave.airbnb.reservations.Reservation;
import jpsave.airbnb.reservations.Sejour;
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
        Sejour sejour1 =  new Sejour(Utile.creerDate("05/02/21"), 4, maison1, 3);
        Sejour sejour2 =  new Sejour(Utile.creerDate("27/03/21"), 1, appartement1, 1);
        Sejour sejour3 =  new Sejour(Utile.creerDate("12/04/21"), 7, maison2, 4);
        Sejour sejour4 =  new Sejour(Utile.creerDate("30/05/21"), 20, appartement2, 2);

        // Reservations
        Reservation reservation1 = new Reservation(sejour1, voyageur1, Utile.creerDate(3, 1, 2021));
        Reservation reservation2 = new Reservation(sejour2, voyageur2, Utile.creerDate(4, 1, 2021));
        Reservation reservation3 = new Reservation(sejour3, voyageur1, Utile.creerDate(5, 1, 2021));
        Reservation reservation4 = new Reservation(sejour4, voyageur2, Utile.creerDate(6, 1, 2021));

        // Affichage
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
