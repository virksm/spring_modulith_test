package com.example.spring_modulith_test.field.internal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.spring_modulith_test.field.Field;
import com.example.spring_modulith_test.field.FieldCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class CreateFieldTest {

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