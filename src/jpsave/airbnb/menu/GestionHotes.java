package jpsave.airbnb.menu;

import jpsave.airbnb.outils.MaDate;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Personne;

import java.util.Scanner;

public class GestionHotes {

    private static void ajouterHote() {
        String nom = "";
        String prenom = "";
        int age = 0;

        while(true) {
            try {
                System.out.println("----------------------------------------");
                System.out.print("Saisir le nom de l'hôte : ");
                nom = Menu.scanner.next();
                System.out.print("Saisir le prénom de l'hôte : ");
                prenom = Menu.scanner.next();
                System.out.print("Saisir l'âge de l'hôte : ");
                age = Menu.scanner.nextInt();
                Personne personne = new Personne(prenom, nom, age);
                personne.afficher();
                System.out.println(" a été ajouté comme hôte.");
                break;
            } catch (Exception e) {
                System.out.println("Nous n'avons pas compris votre saisie !");
                Menu.scanner.next();
            }
        }
    }

    private static void supprimerHote() {

    }

    static void listerHotes() {
        System.out.println("----------------------------------------");
        System.out.println("Saisir une option :");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        switch (Menu.choix(3)) {
            case 1:
                ajouterHote();
                break;
            case 2:
                supprimerHote();
                break;
            case 3:
                Menu.listerMenu();
                break;
        }
    }
}
