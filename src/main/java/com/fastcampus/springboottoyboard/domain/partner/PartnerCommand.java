package com.fastcampus.springboottoyboard.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PartnerCommand {
    private final String partnerName;
    private final String businessNumber;
    private final String email;

    public Partner toEntity() {
    return Partner.builder()
            .partnerName(partnerName)
            .businessNumber(businessNumber)
            .email(email)
            .build();
    }
}
