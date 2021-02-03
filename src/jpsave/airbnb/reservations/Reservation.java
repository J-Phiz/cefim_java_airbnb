package jpsave.airbnb.reservations;

import jpsave.airbnb.outils.Utile;
import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private static int nbIdentifiants = 1;
    private int identifiant = 0;
    private final Sejour sejour;
    private final Voyageur voyageur;
    private boolean estValidee;
    private final Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur, Date dateDeReservation) {
        this.sejour = (Sejour)sejour.clone();
        this.voyageur = voyageur;
        this.dateDeReservation = (Date)dateDeReservation.clone();
        this.estValidee = false;
        this.identifiant = nbIdentifiants++;
    }

    public Sejour getSejour() {
        return (Sejour)sejour.clone();
    }

    public boolean isEstValidee() {
        return estValidee;
    }

    public void setEstValidee(boolean estValidee) {
        this.estValidee = estValidee;
    }

    public void afficher() {
        System.out.println("Réservation n°" + identifiant + " le " + dateDeReservation + " :");
        voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        sejour.afficher();
        System.out.println("");
    }
}
