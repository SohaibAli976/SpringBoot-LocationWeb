package com.example.location.locationweb.Location;

import com.example.location.locationweb.Repository.LocationRepository;
import com.example.location.locationweb.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations() {
        return new ArrayList<Location>(locationRepository.findAll());
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable int id) {
        return locationRepository.findById(id).get();
    }
}
