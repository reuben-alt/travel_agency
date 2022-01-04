package fr.lernejo.travelsite;

import java.util.ArrayList;

public class Temperature {
    public final String country;
    public final ArrayList<Items> temperatures;

    public Temperature(String country, ArrayList<Items> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }
}
