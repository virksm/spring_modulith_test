package com.example.spring_modulith_test.field.internal;

import com.example.spring_modulith_test.field.Field;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateField {

    private final FieldRepository fieldRepository;
    private final FieldEventManager fieldEventManager;

    @Transactional
    public Field handle(String name) {
        Field field = new Field();
        field.setName(name);
        fieldRepository.save(field.createField());
        // alternative fieldEventManager.fieldCreated(field);
        return field;
    }
}
