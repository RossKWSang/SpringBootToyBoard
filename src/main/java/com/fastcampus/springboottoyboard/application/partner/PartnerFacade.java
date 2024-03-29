package com.fastcampus.springboottoyboard.application.partner;

import com.fastcampus.springboottoyboard.domain.notification.NotificationService;
import com.fastcampus.springboottoyboard.domain.partner.PartnerCommand;
import com.fastcampus.springboottoyboard.domain.partner.info.PartnerCacheInfo;
import com.fastcampus.springboottoyboard.domain.partner.info.PartnerInfo;
import com.fastcampus.springboottoyboard.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. partnerService registration
        PartnerInfo partnerInfo = partnerService.registerPartner(command);
        // 2. send email
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
        return partnerInfo;
    }

    public List<PartnerCacheInfo> getAllRegisteredPartners() {
        return partnerService.getAllPartnerCacheInfos();
    }
}
