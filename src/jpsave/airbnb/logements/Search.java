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
        ArrayList<Logement> logements = new ArrayList<>(AirBnBData.getInstance().logements);

//        logements.removeIf(l -> nbVoyageurs > l.getNbVoyageursMax());
//        logements.removeIf(l -> l.getTarifParNuit() > tarifMaxParNuit);
//        logements.removeIf(l -> l.getTarifParNuit() < tarifMinParNuit);
//        if(possedeBalcon != Possession.UnKnown) {
//            logements.removeIf(l -> l instanceof Maison);
//            logements.removeIf(l -> possedeBalcon == Possession.Yes && !((Appartement) l).isPossedeBalcon());
//            logements.removeIf(l -> possedeBalcon == Possession.No && ((Appartement) l).isPossedeBalcon());
//        } else if(possedePiscine != Possession.UnKnown || possedeJardin != Possession.UnKnown) {
//            logements.removeIf(l -> l instanceof Appartement);
//            logements.removeIf(l -> possedePiscine == Possession.Yes && !((Maison) l).isPossedePiscine());
//            logements.removeIf(l -> possedePiscine == Possession.No && ((Maison) l).isPossedePiscine());
//            logements.removeIf(l -> possedeJardin == Possession.Yes && !((Maison) l).isPossedeJardin());
//            logements.removeIf(l -> possedeJardin == Possession.No && ((Maison) l).isPossedeJardin());
//        }
//        return logements;

        return (ArrayList<Logement>) logements.stream()
                .filter(predicateNbVoyageurs())
                .filter(predicateTarif())
                .filter(predicateBalcon().and(predicatePiscine()).and(predicateJardin()))
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

//    private Predicate<Logement> predicateBalcon() {
//        return l -> (possedeBalcon == Possession.Yes && l instanceof Appartement && ((Appartement) l).isPossedeBalcon()) ||
//                (possedeBalcon == Possession.No && l instanceof Appartement && !((Appartement) l).isPossedeBalcon()) ||
//                (possedeBalcon != Possession.Yes && l instanceof Maison);
//    }
    private Predicate<Logement> predicateBalcon() {
        return new Predicate<Logement>() {
            @Override
            public boolean test(Logement l) {
                System.out.print(l.getTarifParNuit() + "Début Balcon : ");
                System.out.print((possedeBalcon == Possession.Yes && l instanceof Appartement && ((Appartement) l).isPossedeBalcon()) + " ");
                System.out.print((possedeBalcon == Possession.No && l instanceof Appartement && !((Appartement) l).isPossedeBalcon()) + " ");
                System.out.print((possedeBalcon != Possession.Yes && l instanceof Maison) + " ");
                System.out.println("Fin");
                return (possedeBalcon == Possession.UnKnown) ||
                       (possedeBalcon == Possession.Yes && l instanceof Appartement && ((Appartement) l).isPossedeBalcon()) ||
                       (possedeBalcon == Possession.No && l instanceof Appartement && !((Appartement) l).isPossedeBalcon()) ||
                       (possedeBalcon == Possession.No && l instanceof Maison);
            }
        };
    }

    private Predicate<Logement> predicatePiscine() {
        return new Predicate<Logement>() {
            @Override
            public boolean test(Logement l) {
                System.out.print(l.getTarifParNuit() + "Début Piscine : ");
                System.out.print((possedePiscine == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedePiscine()) + " ");
                System.out.print((possedePiscine == Possession.No && l instanceof Maison && !((Maison) l).isPossedePiscine()) + " ");
                System.out.print((possedePiscine != Possession.Yes && l instanceof Appartement) + " ");
                System.out.println("Fin");
                return (possedePiscine == Possession.UnKnown) ||
                        (possedePiscine == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedePiscine()) ||
                        (possedePiscine == Possession.No && l instanceof Maison && !((Maison) l).isPossedePiscine()) ||
                        (possedePiscine == Possession.No && l instanceof Appartement);
            }
        };
    }
    private Predicate<Logement> predicateJardin() {
        return new Predicate<Logement>() {
            @Override
            public boolean test(Logement l) {
                System.out.print(l.getTarifParNuit() + "Début Jardin : ");
                System.out.print((possedeJardin == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedeJardin()) + " ");
                System.out.print((possedeJardin == Possession.No && l instanceof Maison && !((Maison) l).isPossedeJardin()) + " ");
                System.out.print((possedeJardin != Possession.Yes && l instanceof Appartement) + " ");
                System.out.println("Fin");
                return (possedeJardin == Possession.UnKnown) ||
                        (possedeJardin == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedeJardin()) ||
                        (possedeJardin == Possession.No && l instanceof Maison && !((Maison) l).isPossedeJardin()) ||
                        (possedeJardin == Possession.No && l instanceof Appartement);
            }
        };
    }
//    private Predicate<Logement> predicatePiscine() {
//        return l -> (possedePiscine == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedePiscine()) ||
//                (possedePiscine == Possession.No && l instanceof Maison && !((Maison) l).isPossedePiscine()) ||
//                (possedePiscine != Possession.Yes && l instanceof Appartement);
//    }

//    private Predicate<Logement> predicateJardin() {
//        return l -> (possedeJardin == Possession.Yes && l instanceof Maison && ((Maison) l).isPossedeJardin()) ||
//            (possedeJardin == Possession.No && l instanceof Maison && !((Maison) l).isPossedeJardin()) ||
//            (possedeJardin != Possession.Yes && l instanceof Appartement);
//    }

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
