package com.fastcampus.springboottoyboard.domain.partner;

import com.fastcampus.springboottoyboard.domain.partner.info.PartnerCacheInfo;
import com.fastcampus.springboottoyboard.domain.partner.info.PartnerInfo;

import java.util.List;

public interface PartnerService {
    // Command, Criteria --- Info

    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);
    List<PartnerCacheInfo> getAllPartnerCacheInfos();
}
