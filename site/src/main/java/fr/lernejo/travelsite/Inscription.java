package fr.lernejo.travelsite;

public class Inscription {
    public final String userEmail;
    public final String userName;
    public final String userCountry;
    public final String weatherExpectation;
    public final Integer minimumTemperatureDistance;

    public Inscription(String userEmail, String userName, String userCountry, String weatherExpectation, Integer minimumTemperatureDistance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExpectation = weatherExpectation;
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }
}
