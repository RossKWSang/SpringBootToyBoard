package com.fastcampus.springboottoyboard.domain.partner.info;

import com.fastcampus.springboottoyboard.domain.partner.Partner;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PartnerInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNumber;
    private final String email;
    private final Partner.Status status;

    public PartnerInfo(
        Partner partner
    ) {
        this.id = partner.getId();
        this.partnerToken = partner.getPartnerToken();
        this.partnerName = partner.getPartnerName();
        this.businessNumber = partner.getBusinessNumber();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
