package com.mjc813.studyjava;

/**
 * Bird 클래스는 Animal 상속
 * 날개(wings) 멤버변수 추가
 * flap(), fly() 메서드 구현
 * reproduce 메서드 오버라이딩하여 Bird 객체 리턴
 */
public class Bird extends Animal {
    protected String wings;

    public Bird(String name, int age) {
        super(name, age);
        this.wings = "날개";  // 기본값 설정
    }

    public void flap() {
        System.out.println(name + " " + wings + " 날개짓한다.");
    }

    public void fly() {
        System.out.println(name + " " + wings + " 난다.");
    }

    @Override
    public Bird reproduce(String newName) {
        return new Bird(newName, 0);
    }
}
