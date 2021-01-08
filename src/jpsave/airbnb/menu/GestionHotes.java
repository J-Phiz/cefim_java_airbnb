package jpsave.airbnb.menu;

import jpsave.airbnb.utilisateurs.Hote;

import java.util.InputMismatchException;

public class GestionHotes {

    private static void ajouterHote() throws InputMismatchException, NumberFormatException {
        System.out.println("----------------------------------------");
        System.out.print("Saisir le nom de l'hôte : ");
        String nom = Menu.scanner.next();

        System.out.print("Saisir le prénom de l'hôte : ");
        String prenom = Menu.scanner.next();

        System.out.print("Saisir l'âge de l'hôte : ");
        int age = Menu.scanner.nextInt();
        if (age < 1)
            throw new NumberFormatException();

        Hote hote = new Hote(prenom, nom, age);
        Menu.hotes.add(hote);
        hote.afficher();
        System.out.println(" a été ajouté comme hôte.");
    }

    private static void supprimerHote() throws IndexOutOfBoundsException {
        System.out.println("----------------------------------------");
        System.out.print("Saisir le nom de l'hôte : ");
        String nom = Menu.scanner.next();

        System.out.print("Saisir le prénom de l'hôte : ");
        String prenom = Menu.scanner.next();

        Hote userHote = new Hote(prenom, nom, 1);

        for (int i = 0; i < Menu.hotes.size(); i++) {
            Hote currentHote = Menu.hotes.get(i);
            if (userHote.equals(currentHote)) {
                currentHote.afficher();
                Menu.hotes.remove(i);
                System.out.println(" a été supprimé.");
                return;
            }
        }
        throw new IndexOutOfBoundsException();
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
                try {
                    ajouterHote();
                } catch (NumberFormatException e) {
                    System.out.println("Votre age doit être > 1 !");
                } catch (InputMismatchException e) {
                    Menu.scanner.next();
                    System.out.println("Nous n'avons pas compris votre saisie !");
                }
            } else if (valChoix == 2) {
                try {
                    supprimerHote();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nous n'avons pas trouvé l'identifiant de l'hôte !");
                }
            } else {
                break;
            }
        }
        Menu.listerMenu();
    }
}
