package jpsave.airbnb.menu;

import jpsave.airbnb.utilisateurs.Personne;

import java.util.InputMismatchException;

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
                if(age < 18)
                    throw new NumberFormatException();
                Personne personne = new Personne(prenom, nom, age);
                personne.afficher();
                System.out.println(" a été ajouté comme hôte.");
                break;
            } catch (InputMismatchException e) {
                Menu.scanner.next();
                System.out.println("Nous n'avons pas compris votre saisie !");
            } catch (NumberFormatException e) {
                System.out.println("L'hôte doit être majeur pour s'enregister !");
            }
        }
    }

    private static void supprimerHote() {

    }

    static void listerHotes() {
        while(true) {
            System.out.println("----------------------------------------");
            System.out.println("Saisir une option :");
            System.out.println("1 : Ajouter un hôte");
            System.out.println("2 : Supprimer un hôte");
            System.out.println("3 : Retour");

            int valChoix = Menu.choix(3);
            if(valChoix == 1) {
                ajouterHote();
            } else if (valChoix == 2) {
                supprimerHote();
            } else {
                break;
            }
        }
        Menu.listerMenu();
    }
}
