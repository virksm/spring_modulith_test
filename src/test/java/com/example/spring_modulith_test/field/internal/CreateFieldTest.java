package com.example.spring_modulith_test.field.internal;

import com.example.spring_modulith_test.PostgresContainer;
import com.example.spring_modulith_test.field.Field;
import com.example.spring_modulith_test.field.FieldCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.PublishedEvents;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ApplicationModuleTest
@Testcontainers
class CreateFieldTest {

    @Container
    public static PostgreSQLContainer<PostgresContainer> postgreSQLContainer = PostgresContainer.getInstance();
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private FieldEventManager fieldEventManager;

    private CreateField cut;

    @BeforeEach
    void setUp() {
        cut = new CreateField(fieldRepository, fieldEventManager);
    }

    @Test
    void publishesOrderCompletion(PublishedEvents events) {
        Field field = cut.handle("field");
        var createdEvents = events.ofType(FieldCreatedEvent.class).matching(ev -> ev.field().equals(field));
        assert createdEvents.iterator().hasNext();
    }
}