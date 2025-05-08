package bookexample.ch3;
public class ChExample {
    public static void main(String[] args) {
        class Example1 {    //1. 다음 코드를 실행했을떄 출력 결과를 작성해 보세요.
            int x = 10;
            int y = 20;
            int z = (++x) + (y--);
            // 선위 연산자 -> 더하고 계산, 후위 연산자 -> 계산하고 빼기
        }
        // Example1 example1 = new Example1();
        // System.out.println(example1.z);
        class Example2 {    //2. 다음코드를 실행 했을 떄 출력 결과를 작성해 보세요.
            int score = 85;
            String result = (!(score>90))? "가" : "나";
            // 우선 score가 90 보다 크지 않음 -> 거짓 0
            // ! 연산자로 1로 변환
            // ? 연산자로 값이 참 이므로 "가"를 할당
        }
        // Example2 example2 = new Example2();
        // System.out.println(example2.result);
        class Example3 {    //3. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고,
            //마지막에 몇 개가 남는지를 구하는 코드입니다. ()에 들어갈 알맞은 코드를 차례대로 작성해 보세요.
            int pencils = 534;
            int students = 30;

            int pencilsPerStudent = pencils / students; // (pencils / students)

            int pencilsLeft = pencils % students; // (pencils % students)
        }
        // Example3 example3 = new Example3();
        // System.out.println(example3.pencilsPerStudent);
        // System.out.println(example3.pencilsLeft);
        class Example4 {    //4. 십의 자리 이하를 버리는 코드입니다. 변수 value의 값이 356 이라면 300이 나올 수 있도록 ()에 알맞은 코드를 작성하세요
            //산술연산자만 사용
            int value = 365;
            int resurlt = value - value % 100;
        }
        // Example4 example4 = new Example4();
        // System.out.println(example4.resurlt);
        class Example5 {    //5. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 정확히 소수 자릿수가 나올 수 있도록 ( ) 에
            // 들어갈 수 있는 코드를 모두 선택하세요.
            int lengthTop = 5;
            int lengthBottom = 10;
            int height = 7;

            // double area = (lengthTop + lengthBottom) * height / 2.0; 52.5
            // double area = (lengthTop + lengthBottom) * height * 1.0 / 2; 52.5
            // double area = (double) (lengthTop + lengthBottom) * height / 2; 52.5
            double area = (double) ((lengthTop + lengthBottom) * height / 2); // 해당 경우 52.0 출력
            // 우선 이유를 설명하면 나눗셈까지 우선순위로 넣어서 52.5가 아닌 정수형으로 52를 받고나서 double로 형변환함.
        }
        // Example5 example5 = new Example5();
        // System.out.println(example5.area);
        class Example6 {    //6. 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식 입니다. 연산식의 출력 결과를 작성해 보세요.
            int x = 10;
            int y = 5;
        }
        Example6 example6 = new Example6();
        // System.out.println( (example6.x > 7) && (example6.y <= 5) );
        // 우선 AND 연산자 둘다 참이여야 참 하나라도 거짓이면 거짓 둘다 거짓일시 거짓
        // 10>7 = 참 5 <= 5 =참 AND 연산시 true 출력
        // System.out.println( (example6.x % 3 == 2) || (example6.y % 2 != 1) );
        // 우선 OR 연산자 둘다 참이면 참 하나라도 참이여도 참 둘다 거짓이면 거짓
        // 10 % 3 = 1 == 2 거짓 5 % 2 = 1 != 1 거짓 OR 연산시 거짓 출력

        //7. 다음은 % 연산을 수행한 결과값에 10을 더하는 코드 이빈다. NaN 값을 검사해서 올바른 결과가 출력될 수 있도록 ( )에
        // 들어갈 코드를 작성해 보세요.
        double x = 5.0;
        double y = 0.0;
        double z = 5 % y;

        if(Double.isNaN(z)){
            System.out.println("0.0 으로 나눌 수 없습니다.");
        } else{
            double result = z + 10;
        }
    }
}
