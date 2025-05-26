package com.mjc813.studyjava.interfacej;

import lombok.Getter;
import lombok.Setter;
//멤버변수 : String name, int age, IVehicle ivehicle
//생성자 : 이름, 나이, IVehicle구현클래스 인스턴스객체
//멤버메소드 : void drive(); => Vehicle클래스데이터형 이 Truck 을 운전할때에는
//"운전수{이름}은 {wheelCount}개의 바퀴의 트럭{이름}을 운전한다." 출력한다. Vehicle클래스데이터형 이 Bicycle 을 운전할때에는
//"운전수{이름}은 {wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 출력한다. void breakk(); => "운전수{이름}은 트럭/자전거{이름}을 정지한다." 출력한다.
@Getter
@Setter
public class Driver {
    private String name;
    private int age;
    private IVehicle ivehicle;

    public Driver(String name, int age, IVehicle ivehicle) {
        this.name = name;
        this.age = age;
        this.ivehicle = ivehicle;
    }

    public void drive() {
        if(ivehicle instanceof Truck) {
            Truck truck = (Truck) ivehicle;
            System.out.println("운전수" + name + "은 " + truck.drive());
        }
        else if(ivehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) ivehicle;
            System.out.println("운전수" + name + "은 " + bicycle.drive());
        }
    }
    public void breakk() {
        if(ivehicle instanceof Truck) {
            Truck truck = (Truck) ivehicle;
            System.out.println("운전수" + name + "은 " + truck.breakk());
        }
        else if(ivehicle instanceof Bicycle) {
            Bicycle bicycle = (Bicycle) ivehicle;
            System.out.println("운전수" + name + "은 " + bicycle.breakk());
        }
    }
}
