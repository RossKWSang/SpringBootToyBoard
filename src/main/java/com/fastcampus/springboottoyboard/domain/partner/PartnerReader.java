package com.fastcampus.springboottoyboard.domain.partner;

import java.util.List;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner(String partnerToken);
    List<Partner> getAllPartners();
}
