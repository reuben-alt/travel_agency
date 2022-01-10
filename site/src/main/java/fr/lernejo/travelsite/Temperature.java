package fr.lernejo.travelsite;

import java.util.List;

public class Temperature {
    public final String country;
    public final List<Items> temperatures;

    public Temperature(String country, List<Items> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }
}
