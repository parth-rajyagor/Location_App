package com.example.locationapp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByDistrictId(Long districtId);
}
