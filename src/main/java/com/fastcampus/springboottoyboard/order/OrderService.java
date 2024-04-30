package com.fastcampus.springboottoyboard.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}

