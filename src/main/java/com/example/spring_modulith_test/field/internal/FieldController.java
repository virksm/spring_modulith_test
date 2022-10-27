package com.example.spring_modulith_test.field.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
public class FieldController {

    private final CreateField createField;

    @GetMapping("fields")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createField(@RequestParam String name) {
        createField.handle(name);
    }
}
