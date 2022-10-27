package com.example.spring_modulith_test.field.internal;

import com.example.spring_modulith_test.field.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FieldRepository extends JpaRepository<Field, UUID> {

}
