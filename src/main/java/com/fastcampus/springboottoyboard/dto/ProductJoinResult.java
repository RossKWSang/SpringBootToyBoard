package com.fastcampus.springboottoyboard.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "ProductJoinResultMapping",
        classes = @ConstructorResult(
                targetClass = ProductJoinResult.class,
                columns = {
                        @ColumnResult(name = "productName"),
                        @ColumnResult(name = "memberId"),
                        @ColumnResult(name = "membershipLevel"),
                        @ColumnResult(name = "shipNationality")
                }
        )
)
public class ProductJoinResult {
    public String productName;
    public String memberId;
    public String membershipLevel;
    public String shipNationality;
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
