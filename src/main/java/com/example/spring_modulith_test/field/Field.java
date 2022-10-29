package com.example.spring_modulith_test.field;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Field extends AbstractAggregateRoot<Field> {

    @Id
    @UuidGenerator
    @Column(nullable = false)
    private UUID id;

    private String name;

    @Transactional
    public Field createField() {
        registerEvent(new FieldCreatedEvent(this));
        return this;
    }
}
