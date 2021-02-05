package jpsave.airbnb.logements;

import jpsave.airbnb.enums.Possession;
import jpsave.airbnb.utils.AirBnBData;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {
    private int nbVoyageurs;
    private int tarifMinParNuit;
    private int tarifMaxParNuit;
    private Possession possedePiscine;
    private Possession possedeJardin;
    private Possession possedeBalcon;

    public Search(int nbVoyageurs, int tarifMinParNuit, int tarifMaxParNuit, Possession possedePiscine, Possession possedeJardin, Possession possedeBalcon) {
        this.nbVoyageurs = nbVoyageurs;
        this.tarifMinParNuit = tarifMinParNuit;
        this.tarifMaxParNuit = tarifMaxParNuit;
        this.possedePiscine = possedePiscine;
        this.possedeJardin = possedeJardin;
        this.possedeBalcon = possedeBalcon;
    }

    public ArrayList<Logement> result() {
        return (ArrayList<Logement>) AirBnBData.getInstance().logements.stream()
                .filter(predicateNbVoyageurs())
                .filter(predicateTarif())
                .filter(predicateBalcon().and(predicatePiscine()).and(predicateJardin()))
                .sorted()
                .collect(Collectors.toList());
    }

    private Predicate<Logement> predicateNbVoyageurs() {
        return new Predicate<Logement>() {
            @Override
            public boolean test(Logement logement) {
                return nbVoyageurs <= logement.getNbVoyageursMax();
            }
        };
    }

    private Predicate<Logement> predicateTarif() {
        return l -> l.getTarifParNuit() <= tarifMaxParNuit || l.getTarifParNuit() >= tarifMinParNuit;
    }

    private Predicate<Logement> predicateBalcon() {
        return l -> (possedeBalcon == Possession.UnKnown) ||
                (possedeBalcon == Possession.Yes && l instanceof Appartement && ((Appartement) l).isPossedeBalcon()) ||
                (possedeBalcon == Possession.No && l instanceof Appartement && !((Appartement) l).isPossedeBalcon()) ||
                (possedeBalcon == Possession.No && l instanceof Maison);
    }

    private Predicate<Logement> predicatePiscine() {
        return l -> (possedePiscine == Possession.UnKnown) ||
                (possedePiscine == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedePiscine()) ||
                (possedePiscine == Possession.No && l instanceof Maison && !((Maison) l).isPossedePiscine()) ||
                (possedePiscine == Possession.No && l instanceof Appartement);
    }

    private Predicate<Logement> predicateJardin() {
        return l -> (possedeJardin == Possession.UnKnown) ||
                (possedeJardin == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedeJardin()) ||
                (possedeJardin == Possession.No && l instanceof Maison && !((Maison) l).isPossedeJardin()) ||
                (possedeJardin == Possession.No && l instanceof Appartement);
    }

    public static class SearchBuilder {

        private int nbVoyageurs;
        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private Possession possedePiscine;
        private Possession possedeJardin;
        private Possession possedeBalcon;

        public SearchBuilder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
            this.tarifMinParNuit = 0;
            this.tarifMaxParNuit = 9999;
            this.possedePiscine = Possession.UnKnown;
            this.possedeJardin = Possession.UnKnown;
            this.possedeBalcon = Possession.UnKnown;
        }

        public SearchBuilder tarifMinParNuit(int tarifMinParNuit) {
            this.tarifMinParNuit = tarifMinParNuit;
            return this;
        }

        public SearchBuilder tarifMaxParNuit(int tarifMaxParNuit) {
            this.tarifMaxParNuit = tarifMaxParNuit;
            return this;
        }

        public SearchBuilder possedePiscine(Possession possedePiscine) {
            this.possedePiscine = possedePiscine;
            return this;
        }

        public SearchBuilder possedeJardin(Possession possedeJardin) {
            this.possedeJardin = possedeJardin;
            return this;
        }

        public SearchBuilder possedeBalcon(Possession possedeBalcon) {
            this.possedeBalcon = possedeBalcon;
            return this;
        }

        public Search build() {
            return new Search(
                    this.nbVoyageurs,
                    this.tarifMinParNuit,
                    this.tarifMaxParNuit,
                    this.possedePiscine,
                    this.possedeJardin,
                    this.possedeBalcon
            );
        }
    }
}
