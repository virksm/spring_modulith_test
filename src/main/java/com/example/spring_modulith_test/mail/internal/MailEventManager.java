package com.example.spring_modulith_test.mail.internal;

import com.example.spring_modulith_test.field.FieldCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailEventManager {

    private final MailSender mailSender;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void on(FieldCreatedEvent fieldCreatedEvent) {
        mailSender.handle(fieldCreatedEvent.field());
    }
}
