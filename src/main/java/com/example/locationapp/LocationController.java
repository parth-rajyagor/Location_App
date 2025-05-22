package com.example.locationapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PincodeRepository pincodeRepository;

    @Autowired
    private LocationSelectionRepository locationSelectionRepository;

    @GetMapping("/")
    public String showForm(Model model, @RequestParam(value = "success", required = false) String success) {
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("success", success != null);
        return "index";
    }

    @ResponseBody
    @GetMapping("/states")
    public List<State> getStates(@RequestParam("countryId") Long countryId) {
        return stateRepository.findByCountryId(countryId);
    }

    @ResponseBody
    @GetMapping("/districts")
    public List<District> getDistricts(@RequestParam("stateId") Long stateId) {
        return districtRepository.findByStateId(stateId);
    }

    @ResponseBody
    @GetMapping("/cities")
    public List<City> getCities(@RequestParam("districtId") Long districtId) {
        return cityRepository.findByDistrictId(districtId);
    }

    @ResponseBody
    @GetMapping("/pincodes")
    public List<Pincode> getPincodes(@RequestParam("cityId") Long cityId) {
        return pincodeRepository.findByCityId(cityId);
    }
/*
    @PostMapping("/submit-location")
    public String submitLocation(
        @RequestParam Long country,
        @RequestParam Long state,
        @RequestParam Long district,
        @RequestParam Long city,
        @RequestParam Long pincode
    ) {
        LocationSelection selection = new LocationSelection();
        selection.setCountry(countryRepository.findById(country).orElse(null));
        selection.setState(stateRepository.findById(state).orElse(null));
        selection.setDistrict(districtRepository.findById(district).orElse(null));
        selection.setCity(cityRepository.findById(city).orElse(null));
        selection.setPincode(pincodeRepository.findById(pincode).orElse(null));

        locationSelectionRepository.save(selection);
        return "redirect:/?success";
    }
    */
   @PostMapping("/submit-location")
    public String submitLocation(
        @RequestParam Long country,
        @RequestParam Long state,
        @RequestParam Long district,
        @RequestParam Long city,
        @RequestParam Long pincode
    ) {
        LocationSelection selection = new LocationSelection();

        selection.setCountryName(countryRepository.findById(country).map(Country::getName).orElse("Unknown"));
        selection.setStateName(stateRepository.findById(state).map(State::getName).orElse("Unknown"));
        selection.setDistrictName(districtRepository.findById(district).map(District::getName).orElse("Unknown"));
        selection.setCityName(cityRepository.findById(city).map(City::getName).orElse("Unknown"));
        selection.setPincodeValue(pincodeRepository.findById(pincode).map(Pincode::getPincode).orElse("Unknown"));

        locationSelectionRepository.save(selection);
        return "redirect:/?success=true";
    }
}
