package bookexample.ch4;

import java.util.Scanner;

public class ChExample {
    public static void main(String[] args) {
        // 객체 생성
        ChExample obj = new ChExample();

        //2번 문제 호출
        obj.example2();

        //3번 문제 호출
        obj.example3();

        //4번 문제 호출
        obj.example4();

        //5번 문제 호출
        obj.example5();

        //6번 문제 호출
        obj.example6();

        //7번 문제 호출
        obj.example7();

    }
    int example2() { // 2번 문제 스위치문을 펴햔식으로 변경하기
        String grade = "B";
        int score1 = 0;
        switch (grade) {
            case "A" -> {
                score1 = 100;
            }
            case "B" -> {
                int result = 100 - 20;
                score1 = result;
            }
            default -> {
                score1 = 60;
            }
        }
        System.out.println(grade);
        return 0;
    }
    
    int example3(){ // 3번 for 문을 이용해서 1부터 100 까지의 정수중에서 3의 배수의 총합을 출력하는 코드를 작성해 보세요.
        for (int i = 0; i < 101; i++){
            if (i % 3 == 0){
                System.out.println("3의 배수" + i);
            }
        }
        return 0;
    }

    int example4(){ // while문과 랜덤 메소드를 이용해서 두개의 주사위를 던졌을떄 나오는 눈을 출력하고 합이 5가 아니면 주사위를 계속 던지고
        //합이 5가 되는 경우 실행을 멈추는 코드를 작성해보세요.
        int dice1 = 0;
        int dice2 = 0;
        while (dice1 + dice2 != 5){
            dice1 = (int)(Math.random() * 5) + 1;
            dice2 = (int)(Math.random() * 5) + 1;
            System.out.println("현재 주사위 눈은: " + dice1 + "," + dice2);
        }
        return 0;
    }
    
    int example5() { // 중첩 for 문 사용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x , y) 형태로 출력하는 코드를 작성해보세요.
        // 단 x와 y는 10 이하의 자연수입니다.
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(4 * i + 5 * j == 60){
                    System.out.println("(x , y) = " + i + "," + j);
                }
            }
        }
        return 0;
    }
    
    int example6() { // 6번문제 for 문을 이용하여 직각삼각형의 실행결과가 별로 출력되는 코드를 작성하세요.
        for (int i = 0; i < 5; i++){
            for(int j = 0; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        return 0;
    }
    
    int example7() {
        int deposit = 0;
        int withdrawal = 0;
        int balance = 0;

        int select = 0;
        int money = 0;

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("-----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("------------------------------------");
            System.out.print("선택> ");

            select = sc.nextInt();

            if(select == 1){
                System.out.print("예금액>");
                int temp = sc.nextInt();
                money += temp;
            }

            if(select == 2){
                System.out.print("출금액>");
                int temp = sc.nextInt();
                if(temp > money){
                    System.out.println("현재 통장잔고에 그만큼 돈이 없습니다.");
                }
                else {
                    money -= temp;
                }
            }
            if(select == 3){
                System.out.println("잔고>" + money);
            }
            if(select == 4){
                System.out.print("프로그램 종료");
                break;
            }
        }
        return 0;
    }
}


