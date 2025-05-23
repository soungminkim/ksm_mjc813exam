package com.mjc.studyjava;

import java.math.BigDecimal;
import java.util.Arrays;

public class MyMathMathic {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public long mul(int a, int b) {
        return a * b;
    }
    public int divM(int a, int b) {
        return a / b;
    }
    public int divN(int a, int b) {
        return a % b;
    }
    public boolean same(int a,int b) {
        return a == b;
    }
    public boolean same(String a, String b) {
        if(a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
    public boolean notsame(int a, int b) {
        return a != b;
    }
    public boolean big(int a,int b) {
        return a > b;
    }
    public boolean small(int a,int b) {
        return a < b;
    }
    public int shiftLeft(int a,byte b) {
        return a << b;
    }
    public int shiftRight(int a, byte b) {
        return a >> b;
    }
    public int shiftRight0(int a, byte b) {
        return a >>> b;
    }
    public long square(int a, byte b) {
        long result = 1L;
        for( int i = 0; i < b; i++ ) {
            result *= a;
        }
        return result;
    }
    public int absolute(int a) {
        return Math.abs(a);
    }
    public String toHex(int a) {
        return Integer.toHexString(a);
    }
    public String toBin(int a) {
        return Integer.toBinaryString(a);
    }
    public String toOct(int a) {
        return Integer.toOctalString(a);
    }
    public int toDec(String a) {
        if(a == null) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int avg(int [] array) {
        if(array == null) {
            return 0;
        }
        return sum(array) / array.length;
    }
    public int sum(int [] array) {
        if(array == null) {
            return 0;
        }
        int sum = 0;
        for( int i : array ) {
            sum += i;
        }
        return sum;
    }
    public int sumOfNumber(int [] array, int number) {
        if(array == null) {
            return 0;
        }
        int sum = 0;
        for( int i : array ) {
            if ( i % number == 0 ) {
                sum += i;
            }
        }
        return sum;
    }
    public int sumOfLoop(int a, int b) {
        int sum = 0;
        for ( int i = a, j = b; i <= j; i++, j-- ) {
            if ( i == j ) {
                sum += i;
            } else {
                sum += i + j;
            }
        }
        return sum;
    }
    public int sumOfFav(int a, int b) {
        if ( a < b ) {
            return a + sumOfFav(a+1, b-1) + b;
        } else if ( a == b ) {
            return a;
        } else {
            return 0;
        }
    }
    public BigDecimal getBigDecimal(int n, int s) {
        return new BigDecimal(n + "." + s);
    }
    public Integer[] getIntegerArray(int[] array) {
        if(array == null) {
            return null;
        }
//        Integer[] result = new Integer[array.length];
//        for ( int i = 0; i < array.length; i++ ) {
//            result[i] = array[i];
//        }
//        return result;
        Integer[] result = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return result;
    }
    public int[] makeRandomIntArray(int n) {
        int[] array = new int[n];
        for ( int i = 0; i < array.length; i++ ) {
            array[i] = (int)(Math.random() * 10000000);
        }
        return array;
    }
    public String makeEncryptString(String text, int n) {
        if ( text == null ) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // String 을 계속 연결하는 경우에 속도도 빠르고 메모리 공간도 절약하는 StringBuilder 클래스 이다.
        int nIndex = n;
        sb.append(this.getRandomString(1));
        for ( int i = 0; i < text.length(); i++ ) {
            sb.append(this.getRandomString(n-1));
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
    public String makeDecryptString(String code, int n) {
        if ( code == null ) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // String 을 계속 연결하는 경우에 속도도 빠르고 메모리 공간도 절약하는 StringBuilder 클래스 이다.
        for ( int i = 1; i < code.length(); i++ ) {
            if ( i % n == 0 ) {
                sb.append(code.charAt(i));
            }
        }
        return sb.toString();
    }
    private String getRandomString(int size) {
        StringBuilder sb = new StringBuilder();
        // String 을 계속 연결하는 경우에 속도도 빠르고 메모리 공간도 절약하는 StringBuilder 클래스 이다.
        int n = 0;
        while ( n < size ) {
            int m = (int)(Math.random() * 3);
            switch (m) {
                case 0:
                    sb.append(this.getRandomOneNumber());
                    break;
                case 1:
                    sb.append(this.getRandomOneUpperAlpha());
                    break;
                case 2:
                    sb.append(this.getRandomOneLowerAlpha());
                    break;
            }
            n++;
        }
        return sb.toString();
    }
    public String getRandomOneNumber() {
        char ch = '0';
        ch += (char)(Math.random() * 10);
        return Character.toString(ch);
    }
    public String getRandomOneUpperAlpha() {
        char ch = 'A';
        ch += (char)(Math.random() * 26);
        return Character.toString(ch);
    }
    public String getRandomOneLowerAlpha() {
        char ch = 'a';
        ch += (char)(Math.random() * 26);
        return Character.toString(ch);
    }
    public String getRandomCharacter(char ch, int untilN) {
        ch += (char)(Math.random() * untilN);
        return Character.toString(ch);
    }
}