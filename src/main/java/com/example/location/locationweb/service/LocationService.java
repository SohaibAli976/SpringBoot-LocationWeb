package com.example.location.locationweb.service;

import com.example.location.locationweb.entities.Location;

import java.util.List;

public interface LocationService {
    Location saveLocation(Location location);
    Location updateLocation(Location location);
    Location getLocationById(int id);
    List<Location> getAllLocations();
    void deleteLocationById(int id);
}
