package com.mjc.studyjava.ch17;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void StreamExample() {
        List<Product> list = new ArrayList<>();
        for( int i = 0; i < 10; i++ ) {
            Product p = new Product(i+1, "상품"+i, "회사", (int)(100000 * Math.random()));
            list.add(p);
        }
        for (Product p : list) {
            System.out.println(p.toString());
        }

        // 상품 가격의 총합을 구해보세요 stream().map(Product) -> price 를 합계
        int total = list.stream()
                .map(Product::getPrice)
                .reduce(0, Integer::sum);
                // .mapToInt(Product::getPrice) 가격만 추출하는 코드 여기서는 mapTOint를 사용도 가능
                // .sum();

        System.out.println("총합: " + total);

        // 상품 가격의 평균을 구해보세요 stream().map(Product) -> price 를 평균

        double average = list.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
        System.out.println("평균: " + average);
    }

    public static void main(String[] args) {
        StreamExample();
    }
}
