package com.example.spring_modulith_test.field.internal;

import com.example.spring_modulith_test.field.Field;
import com.example.spring_modulith_test.field.FieldCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldEventManager {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void fieldCreated(Field field) {
        applicationEventPublisher.publishEvent(new FieldCreatedEvent(field));
    }
}
