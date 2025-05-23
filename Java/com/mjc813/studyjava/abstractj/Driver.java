package com.mjc813.studyjava.abstractj;
//멤버변수 : String name, int age, Vehicle vehicle
//생성자 : 이름, 나이, Vehicle클래스데이터형
//멤버메소드 : void drive(); => Vehicle클래스데이터형 이 Truck 을 운전할때에는
//"운전수{이름}은 {wheelCount}개의 바퀴의 트럭{이름}을 운전한다." 출력한다.
// Vehicle클래스데이터형 이 Bicycle 을 운전할때에는 "운전수{이름}은 {wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 출력한다.
// void break(); => "운전수{이름}은 트럭/자전거{이름}을 정지한다." 출력한다.
public class Driver{
    String name;
    int age;
    Vehicle vehicle;

    Driver(String name, int age, Vehicle vehicle){
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }

    void driver(){
        if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle; // 다운캐스팅
            System.out.println(name + "은 " + truck.wheelCount + "개의 바퀴의 트럭" + truck.name + "을 운전한다.");
        }
        else if(vehicle instanceof Bicycle){
            Bicycle bicycle = (Bicycle) vehicle;
            System.out.println(name + "은 " + bicycle.wheelCount + "개의 바퀴의 자전거" + bicycle.name + "을 이동한다.");
        }
    }
    void breakk(){
        if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle;
            System.out.println(name + "은 " + truck.name + "을 정지한다.");
        }
        else if(vehicle instanceof Bicycle){
            Bicycle bicycle = (Bicycle) vehicle;
            System.out.println(name + "은 " + bicycle.name + "을 정지한다.");
        }
    }
}
