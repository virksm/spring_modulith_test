package com.example.spring_modulith_test;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.model.ApplicationModules;

import java.nio.file.Paths;

@Modulithic
class SpringModulithTestApplicationTests {

    ApplicationModules modules = ApplicationModules.of(SpringModulithTestApplicationTests.class);

    @Test
    void verifiesModularStructure() {
        modules.verify();
    }

    @Test
    void createModuleDocumentation() {
        new Documenter(modules).withOutputFolder(Paths.get("modulithDocu")
            .toAbsolutePath()
            .toString()).writeDocumentation();
    }
}
