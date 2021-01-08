package jpsave.airbnb.menu;

import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.InputMismatchException;

public class GestionVoyageurs {

    private static void ajouterVoyageur() throws InputMismatchException, NumberFormatException {
        System.out.println("----------------------------------------");
        System.out.print("Saisir le nom du voyageur : ");
        String nom = Menu.scanner.next();

        System.out.print("Saisir le prénom du voyageur : ");
        String prenom = Menu.scanner.next();

        System.out.print("Saisir l'âge du voyageur : ");
        int age = Menu.scanner.nextInt();
        if (age < 1)
            throw new NumberFormatException();

        Voyageur voyageur = new Voyageur(prenom, nom, age);
        Menu.voyageurs.add(voyageur);
        voyageur.afficher();
        System.out.println(" a été ajouté comme voyageur.");
    }

    private static void supprimerVoyageur() throws IndexOutOfBoundsException {
        System.out.println("----------------------------------------");

        System.out.print("Saisir le numéro du voyageur à supprimer : ");
        int idx = Menu.scanner.nextInt();
        if (idx < 1 || idx >= Menu.voyageurs.size())
            throw new IndexOutOfBoundsException();

        Menu.voyageurs.remove(idx);
        System.out.println("Le voyageur n°" + idx + " à été supprimé.");
    }

    static void listerVoyageurs() {
        while(true) {
            System.out.println("----------------------------------------");
            for (int i = 0; i < Menu.voyageurs.size(); i++) {
                System.out.print(i + " : ");
                Menu.voyageurs.get(i).afficher();
                System.out.println();
            }
            System.out.println();
            System.out.println("Saisir une option :");
            System.out.println("1 : Ajouter un voyageur");
            System.out.println("2 : Supprimer un voyageur");
            System.out.println("3 : Retour");

            int valChoix = Menu.choix(3);
            if(valChoix == 1) {
                try {
                    ajouterVoyageur();
                } catch (NumberFormatException e) {
                    System.out.println("Votre age doit être > 1 !");
                } catch (InputMismatchException e) {
                    Menu.scanner.next();
                    System.out.println("Nous n'avons pas compris votre saisie !");
                }
            } else if (valChoix == 2) {
                try {
                    supprimerVoyageur();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nous n'avons pas trouvé l'identifiant du voyageur !");
                } catch (InputMismatchException e) {
                Menu.scanner.next();
                System.out.println("Nous n'avons pas compris votre saisie !");
                }
            } else {
                break;
            }
        }
        Menu.listerMenu();
    }
}
