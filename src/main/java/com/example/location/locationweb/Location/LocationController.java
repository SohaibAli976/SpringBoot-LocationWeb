package com.example.location.locationweb.Location;

import com.example.location.locationweb.Repository.LocationRepository;
import com.example.location.locationweb.entities.Location;
import com.example.location.locationweb.service.LocationService;
import com.example.location.locationweb.util.EmailUtil;
import com.example.location.locationweb.util.ReportUtil;
import jakarta.servlet.ServletContext;
import org.hibernate.sql.model.ModelMutationLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext servletContext;

    @GetMapping("/showCreate")
    String showCreate()
    {return "createLocation";}

    @PostMapping("/saveLoc")
    String saveLocation(@ModelAttribute Location location, ModelMap modelMap)
    {
        locationService.saveLocation(location);
        String msg="Location save with id "+location.getId()+" successfully";
        modelMap.addAttribute("msg",msg);
        emailUtil.EMailUtil("abbasisohaib976@gmail.com","Location Saved","Location saved successfully");
        return "createLocation";
    }

    @GetMapping("/displayLocations")
    String displayLocations(ModelMap modelMap)
    {
    List<Location> locations= locationService.getAllLocations();
    if(!locations.isEmpty()) {
        modelMap.addAttribute("locations", locations);
    }
    return "displayLocations";
    }

    @GetMapping("/deleteLocation")
    String deleteLocation(@RequestParam int id, ModelMap modelMap)
    {
        locationService.deleteLocationById(id);
        List<Location> locations= locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
    @GetMapping("/showUpdate")
    String showUpdate(@RequestParam int id, ModelMap modelMap)
    {
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @PostMapping("/updateLoc")
    String updateLocation(ModelMap modelMap, @ModelAttribute Location location)
    {
        locationService.updateLocation(location);
        //modelMap.addAttribute("location", location);
        List<Location> locations= locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
    @GetMapping("/generateReport")
    public String generateReport() throws IOException {
        String path=servletContext.getRealPath("/");
        List<Object[]> data=locationRepository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path,data);
        return "report";
    }
}
