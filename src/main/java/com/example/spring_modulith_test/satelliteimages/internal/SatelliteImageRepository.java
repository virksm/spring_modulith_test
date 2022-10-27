package com.example.spring_modulith_test.satelliteimages.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SatelliteImageRepository extends JpaRepository<SatelliteImage, UUID> {

}
