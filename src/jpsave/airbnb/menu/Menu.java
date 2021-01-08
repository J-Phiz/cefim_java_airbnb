package jpsave.airbnb.menu;

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

        switch (Menu.choix(5)) {
            case 1:
                GestionHotes.listerHotes();
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
        System.out.println("Bienvenue chez AirBnB");
        scanner = new Scanner(System.in);

        listerMenu();

        scanner.close();
    }
}
