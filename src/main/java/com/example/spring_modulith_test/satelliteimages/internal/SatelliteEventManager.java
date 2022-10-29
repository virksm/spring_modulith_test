package com.example.spring_modulith_test.satelliteimages.internal;

import com.example.spring_modulith_test.field.FieldCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SatelliteEventManager {

    private final CreateSatelliteImage createSatelliteImage;

    @EventListener
    public void on(FieldCreatedEvent fieldCreatedEvent) {
        createSatelliteImage.handle(fieldCreatedEvent.field());
    }
}
