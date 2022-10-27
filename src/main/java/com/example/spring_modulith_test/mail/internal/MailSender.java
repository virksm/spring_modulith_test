package com.example.spring_modulith_test.mail.internal;

import com.example.spring_modulith_test.field.Field;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSender {

    public void handle(Field field) {
        if (Math.random() > 0.5) {
            log.info("mail send error: " + field.getName());
            throw new RuntimeException();
        }
        log.info("mail sent successfully: " + field.getName());
    }
}
