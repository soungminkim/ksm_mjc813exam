package com.mjc813.studyjava.interfacej;

public class Main {
    public static void main(String[] args) {
        Truck myTruck = new Truck("볼보", 6);
        Bicycle myBike = new Bicycle("삼천리", 2);

        Driver driver1 = new Driver("홍길동", 35, myTruck);
        driver1.drive();
        driver1.breakk();

        Driver driver2 = new Driver("이순신", 28, myBike);
        driver2.drive();
        driver2.breakk();
    }
}