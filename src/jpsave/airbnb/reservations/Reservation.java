package jpsave.airbnb.reservations;

import jpsave.airbnb.utilisateurs.Personne;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private static int nbIdentifiants = 0;
    private int identifiant = 0;
    private Sejour sejour;
    private Personne voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Personne voyageur, Date dateDeReservation) {
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.dateDeReservation = dateDeReservation;
        this.estValidee = false;
        this.identifiant = nbIdentifiants++;
    }

    public void afficher() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Le " + dateFormat.format(dateDeReservation) + ", ");
        voyageur.afficher();
        System.out.print(" a fait une réservation (" + identifiant + ") chez ");
        sejour.afficher();
        System.out.println("");
    }
}
