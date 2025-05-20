package com.mjc.studyjava;

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
    private String graphic;

    private Mouse mouse = new Mouse();

    public Computer(){
        this.name = "Computer";
        this.cpu = null;
        this.ram = 0;
        this.storageType = null;
        this.graphic = null;
    }

    public Computer(String name){
        this.name = name;
        this.cpu = null;
        this.ram = 0;
        this.storageType = null;
        this.graphic = null;
    }

    public Computer(String name, String cpu){
        this.name = name;
        this.cpu = cpu;
        this.ram = 0;
        this.storageType = null;
        this.graphic = null;
    }

    public Computer(String name, String cpu, int ram){
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = null;
        this.graphic = null;
    }

    public Computer(String name, String cpu, int ram, String storageType){
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.graphic = null;
    }

    // 컴퓨터 에는 각각 부품들의 스펙이 정해짐
    public Computer(String name, String cpu, int ram, String storageType, String graphic) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.graphic = graphic;
    }

    // 컴퓨터 부팅시 이름 출력
    public void boot(){
        System.out.println(name + "가 커졌습니다.");
    }

    //부팅시 스펙 출력 하는 메소드 생성
    public void printSpecs(){
        System.out.println("이름 : " + (name == null ? "조립중입니다." : name));
        System.out.println("CPU : " + (cpu == null ? "조립중입니다." : cpu));
        System.out.println("RAM : " + (ram < 0 ? "조립중입니다." : ram+"GB"));
        System.out.println("Storage : " + (storageType == null ? "조립중입니다." : storageType+"GB"));
        System.out.println("Graphic : " + (graphic == null ? "조립중입니다." : graphic));
    }

    public void testLeftClick(int x, int y){
        mouse.moveMouse(x, y);
        mouse.clickLeftButton();
    }

    public void testRightClick(int x, int y){
        mouse.moveMouse(x, y);
        mouse.clickRightButton();
    }

    // 컴퓨터가 끄면 출력
    public void off(){
        System.out.println(name + "가 꺼집니다.\n");
    }
        public static void main(String[] args) {
            // 컴퓨터를 5대의 스펙은 자유롭게 생성.
            Computer[] computers = {
                    new Computer("mjc813Com_1", "Gen9_i5", 8,  "SSD_500",  "GTX_1660"),
                    new Computer("mjc813Com_2", "Gen9_i7", 16, "HDD_1000", "RTX_4080"),
                    new Computer("mjc813Com_3", "Gen9_i9", 32, "SSD_2000", "Intel_A770"),
                    new Computer("mjc813Com_4", "Gen9_i7", 8,  "HDD_500",  "GTX_1660"),
                    new Computer("mjc813Com_5", "Gen9_i5", 4,  "SSD_1000", "Intel_A770")
            };

            // 컴퓨터 computers[] 만큼 for 문으로 부팅 돌리기
            for (Computer computer : computers) {
                computer.boot();
                // 컴퓨터 5대 스팩 뽑기
                computer.printSpecs();
                // 컴퓨터에서 마우스 클릭
                computer.testLeftClick(200,400);
                computer.testRightClick(600,800);
                // 컴퓨터 5대 종료
                computer.off();
            }
            computers[0].testRightClick(200,400);
        }
}

//     com.mjc813.studyjava.Computer 클래스를 업그레이드 한다.
// 1. 기본생성자에서는 이름은 "Computer", CPU는null, RAM:null, 저장장치:null, 그래픽:null 초기화
// 2. 첫번째 비기본생성자는 이름을 매개변수로 받는다. 나머지 필드는 null 로 초기화
// 3. 두번째 비기본생성자는 이름,CPU를 매개변수로 받는다. 나머지 필드는 null 로 초기화
// 4. 세번째 비기본생성자는 이름,CPU,RAM를 매개변수로 받는다. 나머지 필드는 null 로 초기화
// 5. 네번째 비기본생성자는 이름,CPU,RAM,저장장치를 매개변수로 받는다. 나머지 필드는 null 로 초기화
// 6. 다섯번째 비기본생성자는 이름,CPU,RAM,저장장치,그래픽를 매개변수로 받는다.
// 7. 정보를 출력할때 멤버변수의 값이 null 이 아닌 변수만 출력한다. null 이면 "조립중입니다" 출력한다.
//             예를 들면
//     이름 : Samsung NT530
//     CPU : Gen9_i7
//     RAM : 32GB
//     Storage : 조립중입니다
//     Graphic : 조립중입니다

// 12. Computer 클래스는 Mouse 객체를 하나 가진다.
// 13. Computer 클래스에서 Mouse 를 200, 400 좌표로 움직여서
//  왼쪽 버튼을 클릭하면 아래와 같이 출력되는 메소드를 생성한다.
//             "마우스(200, 400) 왼쪽버튼 클릭됨"
//             14. Computer 클래스에서 Mouse 를 600, 800 좌표로 움직여서
//     오른쪽 버튼을 클릭하면 아래와 같이 출력된다.
//             "마우스(600, 800) 오른쪽버튼 클릭됨"
