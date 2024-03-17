package com.fastcampus.springboottoyboard.domain.partner.info;

import com.fastcampus.springboottoyboard.domain.partner.Partner;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PartnerCacheInfo implements Serializable {
    private final String email;
    private final String partnerToken;

    public PartnerCacheInfo (
            Partner partner
    ) {
        this.email = partner.getEmail();
        this.partnerToken = partner.getPartnerToken();
    }
}
