package com.mjc813.studyjava.lib;

import java.lang.Math;

//- 계산기 클래스를 설계하여 라이브러리를 만들어서 옆사람에게 전달해주세요 (pom.xml 사용)
//- 라이브러리(pom.xml 사용)를 받은 옆사람은 라이브러리에 있는 계산기 클래스의 객체를 생성하고
//  모든 메소드를 사용해 보세요

public class Calculate {
    //- 사칙연산 가능 (+, -, *, /, %)
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
    public int div(int a, int b) {
        return a / b;
    }
    public int mod(int a, int b) {
        return a % b;
    }

    //- 제곱연산 기능 (n^m)
    public int square(int a, int b) {
        return (int)Math.pow(a,b);
    }

    //- 배열의 합을 구하는 기능 (int[] 배열값을 모두 더한 합을 리턴하는 메소드)
    public int sumarray(int[] a) {
        int sum = 0;
        for(int num : a){
            sum += num;
        }
        return sum;
    }

}
