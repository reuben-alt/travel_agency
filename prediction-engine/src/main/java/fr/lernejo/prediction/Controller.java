package fr.lernejo.prediction;

import fr.lernejo.travelsite.Items;
import fr.lernejo.travelsite.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@RestController
public class Controller {
    @GetMapping("/api/temperature")
    public Temperature getTemperature(@RequestParam String country){
        return new Temperature(country, Arrays.asList(
            new Items(LocalDate.now().toString(), new TemperatureService().getTemperature(country)),
            new Items(LocalDate.now().minusDays(1).toString(), new TemperatureService().getTemperature(country))
        ));

    }

}
