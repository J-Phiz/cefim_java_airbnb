package jpsave.airbnb.menu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    static Scanner scanner;

    static void listerMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Saisir une option :");
        System.out.println("1 : Liste des hôtes");
        System.out.println("2 : Liste des logements");
        System.out.println("3 : Liste des voyageurs");
        System.out.println("4 : Liste des reservations");
        System.out.println("5 : Fermer le programme");
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue chez AirBnB");

        scanner = new Scanner(System.in);

        int choix = 0;
        do {
            listerMenu();
            choix = scanner.nextInt();

            if (choix < 1 || choix > 5)
                System.out.println("Erreur dans votre choix");
        } while (choix < 1 || choix > 5);

        System.out.println("Votre choix est : " + choix);

        scanner.close();
    }
}
