package fr.lernejo.travelsite;

public record Inscription(String userName, String userEmail, String userCountry,
                          String weatherExpectation, Integer minimumTemperatureDistance) {
}
