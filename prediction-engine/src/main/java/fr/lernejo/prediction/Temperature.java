package fr.lernejo.prediction;

import fr.lernejo.travelsite.Items;

import java.util.List;

public class Temperature {
    public final String country;
    public final List<fr.lernejo.travelsite.Items> temperatures;

    public Temperature(String country, List<Items> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }
}
