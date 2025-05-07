package com.mjc.studyjava;
public class MyMathMathic {
    // 이것이 자바다 연산자 챕터
    // 문제 3번 534 자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고,
    // 마지막에 몇 개가 남는지를 구하는 코드입니다. () 에 들어갈 알맞은 코드를 차례대로 작성해 보세요.

    //int pencils = 534;
    //int students = 30;

    //int pencilsPerStudent = pencils / students; // (pencils / students)
    //System.out.println(pencilsPerStudent);

    //int pencilsLeft = pencils % students; // (pencils % students)
    //System.out.println(pencilsLeft);
    //산술연산 하는 멤버메소드 5개 생성
    public int add(int a,int b){
        return a + b;
    }
    public int sub (int a,int b){
        return a - b;
    }
    public int mul(int a,int b){
        return a * b;
    }
    public int divM(int a,int b){
        return a / b;
    }
    public int divN(int a,int b){
        return a % b;
    }
    //비교연산 하는 멤버메소드 4개 생성
    boolean same(int a,int b){
        return a == b;
    }
    boolean same(String a,String b){
        return a.equals(b);
    }
    boolean notSame(int a, int b){
        return a != b;
    }
    boolean big(int a, int b){
        return a > b;
    }
    boolean small(int a, int b){
        return a < b;
    }
    //기타연산 하는 멤버메소드
    int shiftLeft(int a, byte b){
        return a << b;
    }
    int shiftRight(int a, byte b){
        return a >> b;
    }
    int shiftRight0(int a, byte b){
        return a >>> b;
    }
    long square(int a, byte b){
        long square = 1;
        for (int i = 0; i < b; i++){
            square *= a;
        }
        return square;
    }
    int absolute(int a){
        return (a >= 0) ? a : -a;
    }
    String toHex(int a){
        return Integer.toHexString(a);
    }
    String toBin(int a){
        return Integer.toBinaryString(a);
    }
    String toOct(int a){
        return Integer.toOctalString(a);
    }
    int toDec(String a){
        return Integer.parseInt(a,10);
    }
}
