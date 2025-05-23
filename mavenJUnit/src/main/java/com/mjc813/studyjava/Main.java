package com.mjc813.studyjava;

public class Main {
    public static void main(String[] args) {
        Computer[] coms = new Computer[5];
        for( int i = 0; i < coms.length; i++ ) {
            coms[i] = new Computer("com" + (i+1), ECpu.Gen9_i5
                    , ERam.RAM_8GB, EStorage.SSD_500GB, EGraphicCard.Intel_A770, "LG");
        }
        for( Computer com : coms ) {
            com.booting();
            com.print();
            com.clickMouseLeftButton(200, 400);
            com.clickMouseRightButton(600, 800);
            com.powerOff();
        }
        Computer com = new Computer("a", null, null, null, null, "Sambo");
        com.printModel();
        Machine m = com;
        ((Machine)com).printModel();

        Machine m2 = new Machine("Samsung");
        m2.printModel();
        Computer c2 = (Computer)m;  // 처음부터 자식객체로 탄생(new)한 객체인 com 을 Machine 인 m 으로 변환했다가
                        // 다시 Computer c2 로 변환하는거는 가능
        c2.printModel();

        Computer m3 = new Computer();
        Machine cc3 = m3;
        cc3.printModel();
    }
}
