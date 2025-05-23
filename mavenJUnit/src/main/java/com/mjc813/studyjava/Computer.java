package com.mjc813.studyjava;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Computer extends Machine {
    private String name;
    private ECpu cpu;
    private ERam ram;
    private EStorage storage;
    private EGraphicCard graphicCard;
    private Mouse mouse = new Mouse();

    public Computer() {
        this("Computer", null, null, null, null, "");
    }
    public Computer( String name ) {
        this(name, null, null, null, null, "");
    }
    public Computer( String name, ECpu cpu ) {
        this(name, cpu, null, null, null, "");
    }
    public Computer( String name, ECpu cpu, ERam ram ) {
        this(name, cpu, ram, null, null, "");
    }
    public Computer( String name, ECpu cpu, ERam ram, EStorage storage ) {
        this(name, cpu, ram, storage, null, "");
    }
    public Computer(String name, ECpu cpu, ERam ram, EStorage stor, EGraphicCard graphic, String model ) {
        super(model);
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = stor;
        this.graphicCard = graphic;
    }
//3. Computer 에는 CPU(Gen9_i5, Gen9_i7, Gen9_i9), RAM 크기 (4,8,16,32GB)
//            , 저장장치는 SSD, HDD 종류로 용량은 500GB, 1000GB, 2000GB 가 존재한다.
//	, 그래픽카드는 GTX_1660, RTX_4080, Intel_A770 가 존재한다.

    public void print() {
        System.out.printf("이름 : %s\n", this.name);
        System.out.printf("CPU : %s\n", this.cpu == null ? "조립중입니다" : this.cpu);
        System.out.printf("RAM : %s\n", this.ram == null ? "조립중입니다" : this.ram);
        System.out.printf("Storage : %s\n", this.storage == null ? "조립중입니다" : this.storage);
        System.out.printf("Graphic : %s\n", this.graphicCard == null ? "조립중입니다" : this.graphicCard);
//        CPU : Gen9_i7
//        RAM : 16GB
//        Storage : HDD 500GB
//        Graphic : GTX_1660
    }
    public void booting() {
        System.out.printf("%s 켜졌습니다.\n", this.name);
    }
    public void powerOff() {
        System.out.printf("%s 가 꺼집니다.\n", this.name);
    }

    public void clickMouseLeftButton(int x, int y) {
        this.mouse.moveMouse(x, y);
        this.mouse.clickLeftButton();
    }

    public void clickMouseRightButton(int x, int y) {
        this.mouse.moveMouse(x, y);
        this.mouse.clickRightButton();
    }

    @Override
    public void printModel() {
        System.out.println("Model : " + super.model);
    }
}
