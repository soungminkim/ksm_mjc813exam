package com.mjc.studyjava;

import java.math.*;
import java.util.Random;

//5월7일 문제 (계산기 클래스를 만들어 본다.)
public class MyMathMathic {
    //산술연산 하는 멤버메소드 5개 생성
    // 두수를 더해서 리턴
    public int add(int a,int b){
        return a + b;
    }

    // 두수를 뺸 결과 리턴
    public int sub (int a,int b){
        return a - b;
    }

    // 두수를 곱한 결과 리턴
    public int mul(int a,int b){
        return a * b;
    }
    // 두수를 나눈 몫 결과 리턴
    public int divM(int a,int b){
        return a / b;
    }

    // 두수를 나눈 나머지 결과 리턴
    public int divN(int a,int b){
        return a % b;
    }

    //비교연산 하는 멤버메소드 4개 생성
    // 두수가 같으면 true 리턴, 아니면 false 리턴
    boolean same(int a,int b){
        return a == b;
    }

    // 두 문자열이 같으면 true 리턴, 아니면 false 리턴
    boolean same(String a,String b){
        if (a == null || b == null){
            return false;
        }
        return a.equals(b);
        //boolean same(String a, String b) {
        //    return a != null && b != null && a.compareTo(b) == 0;
        //}
    }

    // 두수가 다르면 true 리턴, 아니면 false 리턴
    boolean notSame(int a, int b){
        return a != b;
    }

    // a가 b보다 크면 true 리턴, 아니면 false 리턴
    boolean big(int a, int b){
        return a > b;
    }

    // a가 b보다 작으면 true 리턴, 아니면 false 리턴
    boolean small(int a, int b){
        return a < b;
    }

    //기타연산 하는 멤버메소드
    // a를 b만큼 왼쪽 시프트 결과 값을 리턴
    int shiftLeft(int a, byte b){
        return a << b;
    }

    // a를 b만큼 오른쪽 시프트(부호유지) 결과값을 리턴
    int shiftRight(int a, byte b){
        return a >> b;
    }

    // a를 b만큼 오른쪽 시프트(부호를0으로) 결과 값을 리턴
    int shiftRight0(int a, byte b){
        return a >>> b;
    }

    // a를 b만큼 제곱한 결과 값을 리턴, *= 이용하여 코딩하세요.
    long square(int a, byte b){
        long square = 1;
        for (int i = 0; i < b; i++){
            square *= a;
        }
        return square;
    }

    // a의 절대값을 리턴
    int absolute(int a){
        return (a >= 0) ? a : -a;
    }

    // a 값을 16진수 문자열로 리턴
    String toHex(int a){
        return Integer.toHexString(a);
    }

    // a 값을 2신수 문자열로 리턴
    String toBin(int a){
        return Integer.toBinaryString(a);
    }

    // a 값을 8진수 문자열로 리턴
    String toOct(int a){
        return Integer.toOctalString(a);
    }

    // a 문자열을 10진수 정수로 리턴
    int toDec(String a){
        if(a == null){
            return 0;
        }
        return Integer.parseInt(a);
    }

    // 5월 9일 문제 (계산기 클래스를 업그레이드 한다.)
    // int 배열 array의 평균값을 리턴한다.
    int avg(int [] array){
        if(array == null){
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }

    // int 배열 array의 총합계값을 리턴한다.
    int sum(int [] array){
        if (array == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    // int 배열 array의 원소중에서 n의 배수인 값의 총합계값을 리턴한다.
    int sumOfNumber(int[] array, int number){
        if (array == null){
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] % number == 0){
                sum += array[i];
            }
        }
        return sum;
    }

    // a 부터 b 까지의 총합계값을 리턴한다. 루프제어를 사용한다.
    int sumOfLoop(int a, int b){
        int sum = 0;
        for (int i = a; i <= b; i++){
            sum += i;
        }
        return sum;
    }

    // a 부터 b 까지의 총합계값을 리턴한다. 재귀호출을 사용한다.
    static int sumOfFav(int a, int b){
        if (a > b){
            return 0;
        }   else {
            return a + sumOfFav(a + 1, b);
        }
    }

    // 정수 n 값과 소수 s 값인 BigDecimal 데이터형을 리턴하세요.
    BigDecimal getBigDecimal(int n, int s){
        String str = String.valueOf(n) + "." + String.valueOf(s);
        BigDecimal result = new BigDecimal(str);
        return result;
    }

    // int[] 배열을 Integer[] 로 변환해서 리턴
    Integer[] getIntegerArray(int[] array){
        if (array == null){
            return null;
        }

        Integer[] integers = new Integer[array.length];
        for(int i = 0; i < array.length; i++){
            integers[i] = array[i];
        }
        return integers;
    }

    // n 개의 랜덤한 int 값을 가지는 int[] 로 변환해서 리턴
    int[] makeRandomIntArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = (int)(Math.random() * 100) + 1;
        }
        return array;
    }

    // text 문자열의 각 한 문자를 n 번째 배수 인덱스에 배치하는 랜덤 문자열을 리턴하세요.
    String makeEncryptString(String text, int n){
        if (text == null) {
            return "";
        }

        Random rand = new Random(); // 랜덤 객체 생성
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 사용할 수 있는 문자 집함

        int length = (text.length() - 1) * n + 1;// 결과 문자열의 길이
        char[] result = new char[length]; // 결과 문자열을 담을 문자 배열

        int textIndex = 0; // text 문자열에서 현재 넣을 문자의 위치

        // 한 글자씩 넣기
        for (int i = 0; i < length; i++){
            // 현재 인덱스가 n의 배수이고 textIndex가 아직 범위를 벗어나지 않음
            if (i % n == 0 && textIndex < text.length()){
                // text의 현재 문자를 리턴할 문자열 배열에 입력
                result[i] = text.charAt(textIndex++);
            } else { // 랜덤 문자 집합에서 무작위로 하나 선택후 삽입 charAt로 사용가능한 문자열에 랜덤 함수를 굴려 랜덤으로 뽑음
                result[i] = chars.charAt(rand.nextInt(chars.length()));
            }
        }
        return new String(result);
    }

    // code 문자열에서 n번째 배수 인덱스 문자를 뽑아서 하나의 문자열로 리턴하세요.
    String makeDecryptString(String code, int n){
        if (code == null) {
            return "";
        }
        String DecryptString = "";

        for (int i = 0; i < code.length(); i++){
            if (i % n == 0){
                DecryptString = DecryptString + code.charAt(i);
            }
        }
        return DecryptString;
    }
}