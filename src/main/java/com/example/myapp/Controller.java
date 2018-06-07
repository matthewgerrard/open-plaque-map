package com.example.myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@RestController
public class Controller {

    private BluePlaqueDatabase bluePlaqueDatabase;

    public Controller(BluePlaqueDatabase bluePlaqueDatabase) {
        this.bluePlaqueDatabase = bluePlaqueDatabase;
    }

    @GetMapping("/geolocated")
    public List<BluePlaques.BluePlaque> getAllGeolocated() {
        return bluePlaqueDatabase.getBluePlaques().bluePlaques()
                .stream()
                .filter(p -> p.isGeolocated())
                .collect(Collectors.toList());
    }

    @GetMapping("/numberGeolocated")
    public int getNumberGeolocated() {
        return bluePlaqueDatabase.getBluePlaques().bluePlaques()
                .stream()
                .filter(p -> p.isGeolocated())
                .collect(Collectors.toList())
                .size();
    }
}
