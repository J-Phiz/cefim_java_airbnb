package jpsave.airbnb.reservations;

import jpsave.airbnb.outils.Utile;
import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private static int nbIdentifiants = 0;
    private int identifiant = 0;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur, Date dateDeReservation) {
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.dateDeReservation = dateDeReservation;
        this.estValidee = false;
        this.identifiant = nbIdentifiants++;
    }

    public void afficher() {
        System.out.print("Le " + Utile.afficheDate(dateDeReservation) + ", ");
        voyageur.afficher();
        System.out.print(" a fait une réservation (id=" + identifiant + ") chez ");
        sejour.afficher();
        System.out.println("");
    }
}
