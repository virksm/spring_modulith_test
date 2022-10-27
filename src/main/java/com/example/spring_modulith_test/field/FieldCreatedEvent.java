package com.example.spring_modulith_test.field;

import org.jmolecules.event.types.DomainEvent;

public record FieldCreatedEvent(Field field) implements DomainEvent {

}
