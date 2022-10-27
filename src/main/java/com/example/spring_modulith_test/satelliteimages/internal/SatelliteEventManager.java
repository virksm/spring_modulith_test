package com.example.spring_modulith_test.satelliteimages.internal;

import com.example.spring_modulith_test.field.FieldCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class SatelliteEventManager {

    private final CreateSatelliteImage createSatelliteImage;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void on(FieldCreatedEvent fieldCreatedEvent) {
        createSatelliteImage.handle(fieldCreatedEvent.field());
    }
}
