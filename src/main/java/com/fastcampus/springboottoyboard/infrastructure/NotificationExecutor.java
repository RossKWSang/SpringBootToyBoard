package com.fastcampus.springboottoyboard.infrastructure;

import com.fastcampus.springboottoyboard.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {
    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail");
    }

    @Override
    public void sendKakao(String phoneNumber, String description) {
        log.info("sendKakao");
    }

    @Override
    public void sendSms(String PhoneNumber, String description) {
        log.info("sendSms");
    }
}
