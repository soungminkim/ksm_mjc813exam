package bookexample.ch4;

public class Recursion {
    // 재귀 함수
    public static void main(String[] args) {
        System.out.println(sumOfFav(1,10));
    }
    static int sumOfFav(int a, int b){
        if (a > b){
            return 0;
            // a가 b보다 커지면 연산에 영향을 주지 않도록 0 을 반환함
        }   else {
            return a + sumOfFav(a + 1, b);
            // a + 하고 함수호출 설명하자면 1,10을 호출하면
            // 1 + sumofFav(2 , 10)
            // 1 + (2 + (sumofFav(3 , 10)) 반복 즉 return a + 안에서 함수를 호출 했기에 연산에 영향이 없도록 a > b 가 0이 되어야 함
        }
    }
}
