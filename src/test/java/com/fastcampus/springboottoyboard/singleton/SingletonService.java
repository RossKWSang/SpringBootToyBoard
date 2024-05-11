package com.fastcampus.springboottoyboard.singleton;

public class SingletonService {

    // 이 변수는 클래스의 모든 인스턴스에서 공유되며, 값을 변경할 수 없다.
    // static = 클래스 변수
    // final 변경하지 못하는 참조값
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 막아서 외부에서 new로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
}
