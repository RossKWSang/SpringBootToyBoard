package com.fastcampus.springboottoyboard.dto;

public class ProductJoinResult {
    private String productName;
    private String memberId;
    private String membershipLevel;
    private String shipNationality;
    public ProductJoinResult(
            String productName,
            String memberId,
            String membershipLevel,
            String shipNationality
    ) {
        this.productName = productName;
        this.memberId = memberId;
        this.membershipLevel = membershipLevel;
        this.shipNationality = shipNationality;
    }
}
