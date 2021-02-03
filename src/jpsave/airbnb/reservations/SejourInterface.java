package jpsave.airbnb.reservations;

public interface SejourInterface {
    boolean verificationDateArrivee();
    boolean verificationNombreDeNuits();
    boolean verificationNombreDeNuits(int nbNuits);
    boolean verificationNombreDeVoyageurs();
    void afficher();
}
