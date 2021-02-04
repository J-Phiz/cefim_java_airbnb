package jpsave.airbnb;

import jpsave.airbnb.enums.Possession;
import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.logements.Search;
import jpsave.airbnb.outils.MaDate;
import jpsave.airbnb.reservations.Sejour;
import jpsave.airbnb.reservations.SejourFactory;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utils.AirBnBData;

public class MainDesignPattern {
    public static void main(String[] args) {
        // hotes
        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);

        // logements
        Maison maison1 = new Maison(hote1, 50, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        Maison maison2 = new Maison(hote2, 100, "Grand Place, 59000 Lille", 90, 4, 0, false);
        Appartement appartement1 = new Appartement(hote1, 10, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        Appartement appartement2 = new Appartement(hote2, 20, "29 Avenue Le Corbusier, 59800 Lille", 42, 3, 1, 0);

        // Utilisation du Design Pattern factory
        // Sejours
        Sejour sejour1 = SejourFactory.getSejour(new MaDate("5/2/21"), 4, maison1, 3);
        Sejour sejour2 = SejourFactory.getSejour(new MaDate("27/03/21"), 1, appartement1, 1);
        Sejour sejour3 = SejourFactory.getSejour(new MaDate("12/04/2021"), 7, maison2, 4);
        Sejour sejour4 = SejourFactory.getSejour(new MaDate("30/05/2021"), 20, appartement2, 2);

        System.out.println("Sejour1 est du type : " + sejour1.getClass());
        System.out.println("Sejour2 est du type : " + sejour2.getClass());
        System.out.println("Sejour3 est du type : " + sejour3.getClass());
        System.out.println("Sejour4 est du type : " + sejour4.getClass());


        // Utilisation du Design Pattern Singleton
        AirBnBData airBnBData = AirBnBData.getInstance();

        airBnBData.hotes.add(new Hote("Vladimir", "Guez", 28, 12));
        airBnBData.hotes.add(new Hote("Agathe", "Feeling", 55, 1));

        System.out.println();
        System.out.println();
        airBnBData.hotes.forEach(Hote::afficher);
        System.out.println();


        // Utilisation du Design Pattern Builder
        airBnBData.logements.add(appartement1);
        airBnBData.logements.add(appartement2);
        airBnBData.logements.add(maison1);
        airBnBData.logements.add(maison2);
        Search recherche;

        recherche = (new Search.SearchBuilder(4)).build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 1 :");
        recherche.result().forEach(logement -> System.out.println(logement.getAdresse()));

        recherche = (new Search.SearchBuilder(1).possedeBalcon(Possession.Yes)).build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 2 :");
        recherche.result().forEach(logement -> System.out.println(logement.getAdresse()));
    }
}
