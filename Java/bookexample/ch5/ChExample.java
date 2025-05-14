package bookexample.ch5;

import java.util.ArrayList;
import java.util.Scanner;

public class ChExample {
    public static void main(String[] args){
        ChExample obj = new ChExample();

        obj.example6();

        System.out.println(obj.example7());

        obj.example8();

        obj.example9();

    }

    // 6번 다음은 배열 길이를 출력하는 코등비니다. 실행결과를 작성해 보세요.
    int example6(){
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };
        System.out.println(array.length);
        System.out.println(array[2].length);
        return 0;
    }

    // 7번 주어진 배열 항목에서 최대값을 출력하는 코드를 작성해 보세요(for 문 이용).
    int example7(){
        int[] array = new int[] { 1, 5 ,3, 8, 2};
        int max = array[0];

        for (int i: array){
            if (max < i){
                max = i;
            }
        }
        return max;
    }

    // 8번 주어진 배열 항목의 전체 합과 평균을 구해 출력하는 코드를 작성해 보세요(중첩 for 문 이용).
    int example8(){
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };
        int sum = 0;
        double avg = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                sum += array[i][j];
                count++;
            }
        }
        avg = (double) sum / count;
        System.out.println("총합 = " + sum + "\n평균 = " + avg);
        return 0;
    }
    // 9번 학생들의 점수를 분석하는 프로그램을 만들려고 합니다. 키보드로부터 학생 수에 각 학생들의 점수를 입력받고 while 문과
    // Scanner의 nextLine() 메소드를 이용해서 최고 점수 및 평균 점수를 출력하는 코드를 작성해보세요.
    int example9(){
        Scanner sc = new Scanner(System.in);
        int select = 0;
        int student = 0;

        // 배열을 사용하지 않은이유 배열을 사용하면 select할떄 1번에서 배열 크기를 지정하고 2번에서 배열에 입력을 해야하는데 불가함
        // 그래서 동적 리스트를 사용하겠음.
        ArrayList<Integer> list = new ArrayList<>();

        while (true){
            System.out.println("-----------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("-----------------------------------------------------");
            System.out.print("선택> ");
            select = sc.nextInt();

            if(select == 1){
                System.out.print("학생수> ");
                student = sc.nextInt();
            }

            if(select == 2){
                if (student <= 0){
                    System.out.println("학생수 먼저 작성해주세요.");
                } else {
                    for (int i = 0; i < student; i++){
                        System.out.print("scores["+i+"]: ");
                        list.add(sc.nextInt());
                    }
                }
            }

            if(select == 3){
                if (student <= 0){
                    System.out.println("학생수 먼저 작성해주세요.");
                }

                if (list.size() <= 0) {
                    System.out.println("점수를 먼저 입력해주세요.");
                }

                for (int i = 0; i < student; i++){
                    System.out.println("scores["+i+"]: "+list.get(i));
                }
            }

            if(select == 4){
                int count = 0;
                if (student <= 0){
                    count ++;
                    System.out.println("학생수 먼저 작성해주세요.");
                }

                if (list.size() <= 0) {
                    count ++;
                    System.out.println("점수를 먼저 입력해주세요.");
                }

                int sum = 0;
                double avg = 0;
                int max = 0;

                for (int i = 0; i < list.size(); i++){
                    sum += list.get(i);
                    if (max < list.get(i)){
                        max = list.get(i);
                    }
                }
                if (count == 0) {
                    avg = (double) sum / list.size();
                    System.out.println("최고 점수: " + max);
                    System.out.println("평균 점수: " + avg);
                }
            }
            if(select == 5){
                System.out.print("프로그램 종료");
                break;
            }
        }
        sc.close();
        return 0;
    }
}
