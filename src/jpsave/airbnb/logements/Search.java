package jpsave.airbnb.logements;

import jpsave.airbnb.Possession;
import jpsave.airbnb.utils.AirBnBData;

import java.util.ArrayList;

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

        logements.removeIf(l -> nbVoyageurs > l.getNbVoyageursMax());
        logements.removeIf(l -> l.getTarifParNuit() > tarifMaxParNuit);
        logements.removeIf(l -> l.getTarifParNuit() < tarifMinParNuit);
        if(possedeBalcon != Possession.UnKnown) {
            logements.removeIf(l -> l instanceof Maison);
            logements.removeIf(l -> possedeBalcon == Possession.Yes && !((Appartement) l).isPossedeBalcon());
            logements.removeIf(l -> possedeBalcon == Possession.No && ((Appartement) l).isPossedeBalcon());
        } else if(possedePiscine != Possession.UnKnown || possedeJardin != Possession.UnKnown) {
            logements.removeIf(l -> l instanceof Appartement);
            logements.removeIf(l -> possedePiscine == Possession.Yes && !((Maison) l).isPossedePiscine());
            logements.removeIf(l -> possedePiscine == Possession.No && ((Maison) l).isPossedePiscine());
            logements.removeIf(l -> possedeJardin == Possession.Yes && !((Maison) l).isPossedeJardin());
            logements.removeIf(l -> possedeJardin == Possession.No && ((Maison) l).isPossedeJardin());
        }
        return logements;
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
