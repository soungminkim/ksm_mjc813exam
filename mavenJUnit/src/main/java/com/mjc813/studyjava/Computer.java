package com.mjc813.studyjava;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Computer extends Machine implements Comparable<Computer>, Comparator<Computer> {
    private String name;
    private ECpu cpu;
    private ERam ram;
    private EStorage storage;
    private EGraphicCard graphicCard;
    private Mouse mouse = new Mouse();
    private Integer price;
    private Integer qty;

    public Computer() {
        this("Computer", null, null, null, null, "");
    }

    public Computer(String name) {
        this(name, null, null, null, null, "");
    }

    public Computer(String name, ECpu cpu) {
        this(name, cpu, null, null, null, "");
    }

    public Computer(String name, ECpu cpu, ERam ram) {
        this(name, cpu, ram, null, null, "");
    }

    public Computer(String name, ECpu cpu, ERam ram, EStorage storage) {
        this(name, cpu, ram, storage, null, "");
    }

    public Computer(String name, ECpu cpu, ERam ram, EStorage stor, EGraphicCard graphic, String model) {
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

    @Override
    public int hashCode() {
        return Objects.hash(cpu, ram, storage, graphicCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer other = (Computer) o;

        return this.cpu == other.cpu && this.ram == other.ram && this.storage == other.storage && this.graphicCard == other.graphicCard;
    }

    @Override
    public String toString() {
        return String.format(
                "Computer 정보\n" +
                        "이름 :              %s\n" +
                        "CPU :              %s\n" +
                        "RAM :              %s\n" +
                        "Storage :          %s\n" +
                        "GraphicCare :      %s",
                this.name != null ? this.name : "미정",
                this.cpu != null ? this.cpu : "조립중",
                this.ram != null ? this.ram : "조립중",
                this.storage != null ? this.storage : "조립중",
                this.graphicCard != null ? this.graphicCard : "조립중"
        );
    }

    @Override
    public int compareTo(Computer other) {
        if (this.cpu == null || other.cpu == null) {
            System.out.println("미정");
            return 0;
        }
        int result = this.cpu.ordinal() - other.cpu.ordinal();

        if (result < 0) {
            System.out.println("현재 컴퓨터의 CPU 성능이 더 낮습니다.");
        } else if (result > 0) {
            System.out.println("현재 컴퓨터의 CPU 성능이 더 높습니다.");
        } else {
            System.out.println("두 컴퓨터의 CPU 성능이 같습니다.");
        }
        return result;
    }

    @Override
    public int compare(Computer c1, Computer c2) {
        if (c1.ram == null || c2.ram == null) {
            System.out.println("RAM 정보가 없습니다.");
            return 0;
        }

        int result = c1.ram.ordinal() - c2.ram.ordinal();

        if (result < 0) {
            System.out.println("첫 번째 컴퓨터의 RAM이 더 작습니다.");
        } else if (result > 0) {
            System.out.println("첫 번째 컴퓨터의 RAM이 더 큽니다.");
        } else {
            System.out.println("두 컴퓨터의 RAM 크기는 같습니다.");
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Computer> set = new HashSet<>();
        Map<Computer, String> map = new TreeMap<>();
        Computer c1 = new Computer("PC1", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_1000GB, EGraphicCard.GTX_1660, "M1");
        Computer c2 = new Computer("PC2", ECpu.Gen9_i7, ERam.RAM_16GB, EStorage.SSD_1000GB, EGraphicCard.GTX_1660, "M2");

        set.add(c1);
        set.add(c2);

        System.out.println("HashSet 저장 결과:");
        for (Computer c : set) {
            System.out.println(c.getName());
        }
        System.out.println("HashSet 크기: " + set.size());  // 1이 출력되어야 함

        Computer c3 = new Computer("LowPC", ECpu.Gen9_i5, ERam.RAM_8GB, EStorage.HDD_500GB, EGraphicCard.Intel_A770, "M3");
        Computer c4 = new Computer("HighPC", ECpu.Gen9_i9, ERam.RAM_32GB, EStorage.SSD_2000GB, EGraphicCard.RTX_4080, "M4");

        map.put(c4, "고성능");
        map.put(c1, "중간성능");
        map.put(c3, "저성능");

        System.out.println("\nTreeMap 저장 결과 (CPU 성능 기준 정렬):");
        for (Map.Entry<Computer, String> entry : map.entrySet()) {
            System.out.printf("%s → %s\n", entry.getKey().getName(), entry.getValue());
        }

        List<Computer> list = new ArrayList<>();

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(new Computer("OfficePC", ECpu.Gen9_i7, ERam.RAM_8GB, EStorage.SSD_1000GB, EGraphicCard.GTX_1660, "M5"));

        list.get(0).setPrice(500000);
        list.get(0).setQty(5);
        list.get(1).setPrice(1000000);
        list.get(1).setQty(3);
        list.get(2).setPrice(2500000);
        list.get(2).setQty(2);
        list.get(3).setPrice(400000);
        list.get(3).setQty(7);
        list.get(4).setPrice(800000);
        list.get(4).setQty(4);

        int totalStockValue = list.stream()
                .mapToInt(c -> c.getPrice() * c.getQty())
                .sum();
        System.out.println("Computer 총 금액: " + totalStockValue);



        ECpu minCpu = list.stream()
                .map(Computer::getCpu)
                .min(Comparator.naturalOrder())
                .orElse(null);

        int minCpuQtyTotal = list.stream()
                .filter(c -> c.getCpu() == minCpu)
                .mapToInt(Computer::getQty)
                .sum();

        System.out.println("가장 낮은 cpu: "+ minCpu + "\n재고 수량: " + minCpuQtyTotal + "개");
    }
}
