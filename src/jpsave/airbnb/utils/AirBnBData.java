package jpsave.airbnb.utils;

import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.ArrayList;

public class AirBnBData {

    private static final AirBnBData INSTANCE = new AirBnBData();

    private AirBnBData() {
        // Pour ne pas avoir le constructeur par défaut
        hotes = new ArrayList<>();
        logements = new ArrayList<>();
        voyageurs = new ArrayList<>();
    }

    public static AirBnBData getInstance() {
        return INSTANCE;
    }

    public final ArrayList<Hote> hotes;
    public final ArrayList<Logement> logements;
    public final ArrayList<Voyageur> voyageurs;

}
