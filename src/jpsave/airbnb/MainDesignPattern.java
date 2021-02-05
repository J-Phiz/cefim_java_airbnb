package jpsave.airbnb;

import jpsave.airbnb.enums.Possession;
import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
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
        Hote hote1 = new Hote("Vladimir", "Guez", 28, 12);
        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);

        // logements
        Maison maison1 = new Maison(hote1, 100, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        Maison maison2 = new Maison(hote2, 50, "Grand Place, 59000 Lille", 90, 4, 0, false);
        Maison maison3 = new Maison(hote1, 75, "12 Rue d'Auvergne, 37000 Tours", 112, 5, 950, true);
        Maison maison4 = new Maison(hote2, 77, "25 Rue de Chanteloup, 41000 Vendôme", 95, 2, 0, true);
        Maison maison5 = new Maison(hote1, 110, "45 Rue du coteau 37000 Tours", 43, 3, 800, true);
        Maison maison6 = new Maison(hote2, 55, "Place des oiseaux, 45000 Orleans", 80, 4, 300, false);
        Maison maison7 = new Maison(hote1, 49, "28 Rue des champs, 38000 Grenoble", 150, 7, 500, false);
        Maison maison8 = new Maison(hote2, 100, "1 Rue de je suis perdu, 12000 Rodez", 200, 8, 1000, true);
        Appartement appartement1 = new Appartement(hote1, 10, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        Appartement appartement2 = new Appartement(hote2, 20, "29 Avenue Le Corbusier, 59800 Lille", 42, 3, 1, 0);
        Appartement appartement3 = new Appartement(hote1, 21, "14 Rue du 14 Juillet, 58000 Nevers", 70, 3, 2, 2);
        Appartement appartement4 = new Appartement(hote2, 100, "32 Rue de la perdrix 42000 Saint-Etienne", 140, 7, 1, 20);
        Appartement appartement5 = new Appartement(hote1, 12, "2 Chemin de la noisette, 37400 Amboise", 33, 2, 3, 10);
        Appartement appartement6 = new Appartement(hote2, 23, "8 Route de Vézelay, 58800 Corbigny", 68, 3, 1, 0);
        Appartement appartement7 = new Appartement(hote1, 9, "19 Rue de Bordeaux, 37000 Tours", 15, 2, 5, 0);
        Appartement appartement8 = new Appartement(hote2, 19, "48 Avenue Le Corbusier, 59800 Lille", 55, 4, 6, 17);

        // Utilisation du Design Pattern factory
        // Sejours
        Sejour sejour1 = SejourFactory.getSejour(new MaDate("8/2/21"), 4, maison1, 3);
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
        airBnBData.logements.add(appartement3);
        airBnBData.logements.add(appartement4);
        airBnBData.logements.add(appartement5);
        airBnBData.logements.add(appartement6);
        airBnBData.logements.add(appartement7);
        airBnBData.logements.add(appartement8);
        airBnBData.logements.add(maison1);
        airBnBData.logements.add(maison2);
        airBnBData.logements.add(maison3);
        airBnBData.logements.add(maison4);
        airBnBData.logements.add(maison5);
        airBnBData.logements.add(maison6);
        airBnBData.logements.add(maison7);
        airBnBData.logements.add(maison8);
        Search recherche;

        appartement1.afficherCourt();
        appartement2.afficherCourt();
        appartement3.afficherCourt();
        appartement4.afficherCourt();
        appartement5.afficherCourt();
        appartement6.afficherCourt();
        appartement7.afficherCourt();
        appartement8.afficherCourt();
        maison1.afficherCourt();
        maison2.afficherCourt();
        maison3.afficherCourt();
        maison4.afficherCourt();
        maison5.afficherCourt();
        maison6.afficherCourt();
        maison7.afficherCourt();
        maison8.afficherCourt();

        recherche = (new Search.SearchBuilder(4)).build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 1 (pers > 3) :");
        recherche.result().forEach(Logement::afficherCourt);

        recherche = (new Search.SearchBuilder(1).possedeBalcon(Possession.Yes)).build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 2 (avec balcon) :");
        recherche.result().forEach(Logement::afficherCourt);

        recherche = (new Search.SearchBuilder(1)
                .possedeBalcon(Possession.Yes))
                .possedePiscine(Possession.Yes)
                .build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 3 (avec balcon et piscine) :");
        recherche.result().forEach(Logement::afficherCourt);

        recherche = (new Search.SearchBuilder(1)
                .possedeJardin(Possession.Yes))
                .possedePiscine(Possession.Yes)
                .build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 4 (avec jardin et piscine):");
        recherche.result().forEach(Logement::afficherCourt);

        recherche = (new Search.SearchBuilder(1)
                .tarifMaxParNuit(58))
                .build();
        System.out.println();
        System.out.println();
        System.out.println("Résultat de la recherche 5 (prix < 58€):");
        recherche.result().forEach(Logement::afficherCourt);
    }
}
