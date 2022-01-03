package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @PostMapping("/api/inscription")
    public void postInscription(@RequestBody Inscription data) {
    }
    @GetMapping("/api/travels")
    public Iterable<Destination> getTravels(@RequestParam String userName){
        return null;
    }
    @GetMapping("/api/temperature")
    public Iterable<Temperature> getTemperature(@RequestParam String country){
        return null;
    }
}
