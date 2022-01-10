package fr.lernejo.prediction;

import fr.lernejo.travelsite.Items;
import fr.lernejo.travelsite.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@RestController
public class TemperatureController {
    @GetMapping("/api/temperature")
    public Temperature getTemperature(@RequestParam String country){
        return new Temperature(country, Arrays.asList(
            new Items(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new TemperatureService().getTemperature(country)),
            new Items(new SimpleDateFormat("yyyy-MM-dd").format(LocalDateTime.now().minusDays(1)), new TemperatureService().getTemperature(country))
        ));

    }

}
