package jpsave.airbnb.menu;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.outils.MaDate;
import jpsave.airbnb.reservations.Reservation;
import jpsave.airbnb.reservations.Sejour;
import jpsave.airbnb.reservations.SejourCourt;
import jpsave.airbnb.reservations.SejourLong;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scanner;
    static ArrayList<Hote> hotes;
    static ArrayList<Voyageur> voyageurs;
    static ArrayList<Logement> logements;
    static ArrayList<Sejour> sejours;
    static ArrayList<Reservation> reservations;

    private static void init() {
        hotes = new ArrayList<Hote>();
        voyageurs = new ArrayList<Voyageur>();
        logements = new ArrayList<Logement>();
        sejours = new ArrayList<Sejour>();
        reservations = new ArrayList<Reservation>();

        // hotes
        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);
        hotes.add(hote1);
        hotes.add(hote2);

        // logements
        Maison maison1 = new Maison(hote1, 50, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        Maison maison2 = new Maison(hote2, 100, "Grand Place, 59000 Lille", 90, 4, 0, false);
        Appartement appartement1 = new Appartement(hote1, 10, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        Appartement appartement2 = new Appartement(hote2, 20, "29 Avenue Le Corbusier, 59800 Lille", 42, 3, 1, 0);
        logements.add(maison1);
        logements.add(maison2);
        logements.add(appartement1);
        logements.add(appartement2);

        // Voyageurs
        Voyageur voyageur1 = new Voyageur("Maxime", "Albert", 29);
        Voyageur voyageur2 = new Voyageur("Jacques", "Célère", 35);
        voyageurs.add(voyageur1);
        voyageurs.add(voyageur2);

        // Sejours
        SejourCourt sejour1 =  new SejourCourt(new MaDate("5/2/21"), 4, maison1, 3);
        SejourCourt sejour2 =  new SejourCourt(new MaDate("27/03/21"), 1, appartement1, 1);
        SejourLong sejour3 =  new SejourLong(new MaDate("12/04/2021"), 7, maison2, 4);
        SejourLong sejour4 =  new SejourLong(new MaDate("30/05/2021"), 20, appartement2, 2);
        sejours.add(sejour1);
        sejours.add(sejour2);
        sejours.add(sejour3);
        sejours.add(sejour4);

        // Reservations
        Reservation reservation1 = new Reservation(sejour1, voyageur1, new MaDate(3, 1, 2021));
        Reservation reservation2 = new Reservation(sejour2, voyageur2, new MaDate(4, 1, 2021));
        Reservation reservation3 = new Reservation(sejour3, voyageur1, new MaDate(5, 1, 2021));
        Reservation reservation4 = new Reservation(sejour4, voyageur2, new MaDate(6, 1, 2021));
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        reservations.add(reservation4);
    }

    static void listerMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Saisir une option :");
        System.out.println("1 : Liste des hôtes");
        System.out.println("2 : Liste des logements");
        System.out.println("3 : Liste des voyageurs");
        System.out.println("4 : Liste des reservations");
        System.out.println("5 : Fermer le programme");

        switch (Menu.choix(5)) {
            case 1:
                GestionHotes.listerHotes();
                break;
            case 3:
//                GestionVoyageurs.listerVoyageurs();
                break;
            default:
            case 5:
                System.out.println("A bientôt");
                break;
        }
    }

    static int choix(int maxValue) {
        int valChoix = 0;

        while(true) {
            try {
                valChoix = scanner.nextInt();
                if(valChoix >= 1 && valChoix <= maxValue) {
                    return valChoix;
                }
            } catch(Exception e) {
                System.out.println("Nous n'avons pas compris votre choix !");
                scanner.next();
            }
            System.out.println("Faites un choix compris entre 1 et " + maxValue +  ".");
        }
    }

    public static void main(String[] args) {
        init();

        System.out.println("Bienvenue chez AirBnB");
        scanner = new Scanner(System.in);

        listerMenu();

        scanner.close();
    }
}
