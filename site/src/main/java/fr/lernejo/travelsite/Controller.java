package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final ArrayList<Inscription> inscriptions;
    private final Service service;

    public Controller( Service service) {
        this.inscriptions = new ArrayList<>();
        this.service = service;
    }

    @PostMapping("/api/inscription")
    public void postInscription(@RequestBody Inscription data) {
        this.inscriptions.add(data);
    }
    @GetMapping("/api/travels")
    public List<Destination> getTravels(@RequestParam String userName){
        for (Inscription inscription : inscriptions) {
            if (inscription.userName().equals(userName))
                return service.getTravel(inscription);
        }
        return null;
    }

}

