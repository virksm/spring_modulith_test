package com.example.spring_modulith_test.satelliteimages.internal;

import com.example.spring_modulith_test.field.Field;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateSatelliteImage {

    private final SatelliteImageRepository satelliteImageRepository;

    public void handle(Field field) {
        log.info("Created new image for field");
        SatelliteImage satelliteImage = new SatelliteImage();
        satelliteImage.setField(field);
        satelliteImageRepository.save(satelliteImage);
        log.info("Created new image for field");
    }
}
