package com.fastcampus.springboottoyboard.infrastructure.partner;

import com.fastcampus.springboottoyboard.common.exception.EntityNotFoundException;
import com.fastcampus.springboottoyboard.domain.partner.Partner;
import com.fastcampus.springboottoyboard.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReaderImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;
    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }


}
