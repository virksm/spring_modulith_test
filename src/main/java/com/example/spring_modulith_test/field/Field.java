package com.example.spring_modulith_test.field;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class Field {

    @Id
    @UuidGenerator
    @Column(nullable = false)
    private UUID id;

    private String name;

}
