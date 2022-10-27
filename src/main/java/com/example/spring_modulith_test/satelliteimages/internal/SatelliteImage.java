package com.example.spring_modulith_test.satelliteimages.internal;

import com.example.spring_modulith_test.field.Field;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class SatelliteImage {

    @Id
    @UuidGenerator
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    private Field field;

}
