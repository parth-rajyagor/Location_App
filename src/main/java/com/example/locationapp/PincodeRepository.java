package com.example.locationapp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PincodeRepository extends JpaRepository<Pincode, Long> {
    List<Pincode> findByCityId(Long cityId);
}
