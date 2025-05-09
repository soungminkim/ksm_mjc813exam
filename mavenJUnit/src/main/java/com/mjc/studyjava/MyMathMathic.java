package com.mjc.studyjava;

public class MyMathMathic {
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
        //boolean same(String a, String b) {
        //    return a != null && b != null && a.compareTo(b) == 0;
        //}
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
        return Integer.parseInt(a);
    }
}