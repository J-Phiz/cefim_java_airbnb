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

    /**
     * Creation d'une reservation.
     * @param sejour le séjour a assoicer à cette réservation
     * @param voyageur le voyageur a associer à cette réservation
     * @param dateDeReservation la data a laquelle la réservation a été faite
     * @throws IllegalArgumentException si les parametres sont null
     */
    public Reservation(Sejour sejour, Voyageur voyageur, Date dateDeReservation) {
        if(sejour == null || voyageur == null || dateDeReservation == null) {
            throw new IllegalArgumentException();
        }
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
