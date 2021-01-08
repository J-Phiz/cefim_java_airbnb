package jpsave.airbnb.menu;

import jpsave.airbnb.logements.Appartement;

import java.util.InputMismatchException;

public class GestionLogements {

    private static void ajouterAppartement() throws InputMismatchException, NumberFormatException {
        System.out.println("----------------------------------------");
        System.out.print("Saisir l'index de l'hôte : ");
        int hoteId = Menu.scanner.nextInt();
        if (hoteId < 0 || hoteId >= Menu.hotes.size())
            throw new NumberFormatException();

        System.out.print("Saisir l'adresse l'adresse du logement : ");
        String adresse = Menu.scanner.next();

        System.out.print("Saisir le numéro d'étage du logement : ");
        int etage = Menu.scanner.nextInt();
        if (etage < 0)
            throw new NumberFormatException();

        System.out.print("Saisir la superficie du logement : ");
        int superficie = Menu.scanner.nextInt();
        if (superficie < 0)
            throw new NumberFormatException();

        System.out.print("Saisir la superficie du balcon : ");
        int balcon = Menu.scanner.nextInt();
        if (balcon < 0)
            throw new NumberFormatException();

        System.out.print("Saisir le nombre max de voyageurs autorisés : ");
        int maxVoyageurs = Menu.scanner.nextInt();
        if (maxVoyageurs < 0)
            throw new NumberFormatException();

        System.out.print("Saisir le tarif pour une nuit : ");
        int tarif = Menu.scanner.nextInt();
        if (tarif < 0)
            throw new NumberFormatException();

        Appartement appartement = new Appartement(Menu.hotes.get(hoteId),tarif, adresse, superficie, maxVoyageurs, etage, balcon);
        Menu.logements.add(appartement);
        appartement.afficher();
        System.out.println(" a été ajouté comme logement.");
    }

    private static void ajouterMaison() throws InputMismatchException, NumberFormatException {
        System.out.println("----------------------------------------");
        System.out.print("Saisir l'index de l'hôte : ");
        int hoteId = Menu.scanner.nextInt();
        if (hoteId < 0 || hoteId >= Menu.hotes.size())
            throw new NumberFormatException();

        System.out.print("Saisir l'adresse l'adresse du logement : ");
        String adresse = Menu.scanner.next();

        System.out.print("Saisir la superficie du logement : ");
        int superficie = Menu.scanner.nextInt();
        if (superficie < 0)
            throw new NumberFormatException();

        System.out.print("Saisir la superficie du jardin : ");
        int jardin = Menu.scanner.nextInt();
        if (jardin < 0)
            throw new NumberFormatException();

        System.out.print("Le logement possède-t-il une piscine ? (oui=1/non=0) : ");
        int piscine = Menu.scanner.nextInt();
        if (piscine < 0 || piscine > 1)
            throw new NumberFormatException();

        System.out.print("Saisir le nombre max de voyageurs autorisés : ");
        int maxVoyageurs = Menu.scanner.nextInt();
        if (maxVoyageurs < 0)
            throw new NumberFormatException();

        System.out.print("Saisir le tarif pour une nuit : ");
        int tarif = Menu.scanner.nextInt();
        if (tarif < 0)
            throw new NumberFormatException();

        Appartement appartement = new Appartement(Menu.hotes.get(hoteId),tarif, adresse, superficie, maxVoyageurs, jardin, piscine);
        Menu.logements.add(appartement);
        appartement.afficher();
        System.out.println(" a été ajouté comme logement.");
    }

    private static void supprimerLogement() throws IndexOutOfBoundsException {
        System.out.println("----------------------------------------");

        System.out.print("Saisir le numéro du logement à supprimer : ");
        int idx = Menu.scanner.nextInt();
        if (idx < 1 || idx >= Menu.logements.size())
            throw new IndexOutOfBoundsException();

        Menu.logements.remove(idx);
        System.out.println("Le logement n°" + idx + " à été supprimé.");
    }

    static void listerLogements() {
        while(true) {
            System.out.println("----------------------------------------");
            for (int i = 0; i < Menu.logements.size(); i++) {
                System.out.print(i + " : ");
                Menu.logements.get(i).afficher();
                System.out.println();
            }
            System.out.println();
            System.out.println("Saisir une option :");
            System.out.println("1 : Ajouter un logement de type appartement");
            System.out.println("2 : Ajouter un logement de type maison");
            System.out.println("3 : Supprimer un logement");
            System.out.println("4 : Retour");

            int valChoix = Menu.choix(3);
            try {
                if(valChoix == 1) {
                    ajouterAppartement();
                } else if (valChoix == 2) {
                    ajouterMaison();
                } else if (valChoix == 3) {
                    supprimerLogement();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Votre valeur n'est pas valide !");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nous n'avons pas trouvé l'identifiant !");
            } catch (InputMismatchException e) {
                Menu.scanner.next();
                System.out.println("Nous n'avons pas compris votre saisie !");
            }
        }
        Menu.listerMenu();
    }
}
