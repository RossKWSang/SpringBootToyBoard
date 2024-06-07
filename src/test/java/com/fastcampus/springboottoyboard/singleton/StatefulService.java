package com.fastcampus.springboottoyboard.singleton;

public class StatefulService {

    // private int price; // 상태를 유지하는 필드, 이런식으로 Stateful하게 설계를하면 안된다.

    public int order(int price) {
        return price;
    }
}
