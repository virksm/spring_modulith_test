package com.example.spring_modulith_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.modulith.Modulith;

@Modulith
public class SpringModulithTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringModulithTestApplication.class, args);
    }

    @Bean
    FlywayMigrationStrategy cleanMigrationStrategy() {
        return (flyway) -> {
            flyway.clean();
            flyway.migrate();
        };
    }

}
