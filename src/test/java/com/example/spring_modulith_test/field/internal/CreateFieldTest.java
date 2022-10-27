package com.example.spring_modulith_test.field.internal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.spring_modulith_test.PostgresContainer;
import com.example.spring_modulith_test.field.Field;
import com.example.spring_modulith_test.field.FieldCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ApplicationModuleTest
@Testcontainers
class CreateFieldTest {

    @Container
    public static PostgreSQLContainer<PostgresContainer> postgreSQLContainer = PostgresContainer.getInstance();
    @MockBean
    private ApplicationEventPublisher publisher;
    @Autowired
    private FieldRepository fieldRepository;
    private CreateField cut;

    @BeforeEach
    void setUp() {
        cut = new CreateField(fieldRepository, new FieldEventManager(publisher));
    }

    @Test
    void publishesOrderCompletion() {

        Field field = cut.handle("field");
        verify(publisher, times(1)).publishEvent(new FieldCreatedEvent(field));
    }
}