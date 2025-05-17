package com.mjc.studyjava;

    //    5월15일 문제
    //한글로 표현하는 문제를 Java 소스로 구현하세요.
public class Computer {

    // 1. Computer 에는 각각 이름이 존재한다.
    // 2. Computer 를 부팅하면 Console 에 이름을 출력하면서 "가 켜졌습니다." 출력한다. 예를 들면 "mjc813Com 켜졌습니다."
    // 3. Computer 에는 CPU(Gen9_i5, Gen9_i7, Gen9_i9), RAM 크기 (4,8,16,32GB), 저장장치는 SSD, HDD 종류로
        // 용량은 500GB, 1000GB, 2000GB 가 존재한다. 그래픽카드는 GTX_1660, RTX_4080, Intel_A770 가 존재한다.
    // 4. 컴퓨터를 5대의 스펙은 자유롭게 생성 하고 5대를 부팅하세요.
    // 5. 컴퓨터의 스펙을 Console 에 출력하는 메소드를 구현 하세요.
    //    예를 들면
    //    CPU : Gen9_i7
    //    RAM : 16GB
    //    Storage : HDD 500GB
    //    Graphic : GTX_1660
    //6. 컴퓨터 5대 스펙을 출력하세요.
    //7. 컴퓨터를 끄면 "가 꺼집니다." 출력한다.
    //8. 컴퓨터 5대 Power 를 끄세요.

    private String name;
    private String cpu;
    private int ram;
    private String storageType;
    private int storageSize;
    private String graphic;

    // 컴퓨터 에는 각각 부품들의 스펙이 정해짐
    public Computer(String name, String cpu, int ram, String storageType, int storageSize, String graphic) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphic = graphic;
    }

    // 컴퓨터 부팅시 이름 출력
    public void boot(){
        System.out.println(name + "가 커졌습니다.");
    }

    //부팅시 스펙 출력 하는 메소드 생성
    public void printSpecs(){
        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram + "GB");
        System.out.println("Storage : " + storageType + "_" + storageSize + "GB");
        System.out.println("Graphic : " + graphic);
    }

    // 컴퓨터가 끄면 출력
    public void off(){
        System.out.println(name + "가 꺼집니다.\n");
    }

}
class ComputerSpace {
    public static void main(String[] args) {
        // 컴퓨터를 5대의 스펙은 자유롭게 생성.
        Computer[] computers = {
            new Computer("mjc813Com_1", "Gen9_i5", 8,  "SSD", 500,  "GTX_1660"),
            new Computer("mjc813Com_2", "Gen9_i7", 16, "HDD", 1000, "RTX_4080"),
            new Computer("mjc813Com_3", "Gen9_i9", 32, "SSD", 2000, "Intel_A770"),
            new Computer("mjc813Com_4", "Gen9_i7", 8,  "HDD", 500,  "GTX_1660"),
            new Computer("mjc813Com_5", "Gen9_i5", 4,  "SSD", 1000, "Intel_A770")
        };
        
        // 컴퓨터 computers[] 만큼 for 문으로 부팅 돌리기
        for (Computer computer : computers) {
            computer.boot();
            // 컴퓨터 5대 스팩 뽑기
            computer.printSpecs();
            // 컴퓨터 5대 종료
            computer.off();
        }
    }
}