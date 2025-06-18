package com.mjc813.D0618;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumLoop {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ISumLoop sumPrinter = new ISumLoop() {
            @Override
            public void print(Long sum) {
                System.out.println("리턴값" +sum);
            }
        };

        for (int i = 1; i < 100000; i++) {
            final int idx = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long sum = 0;
                    for (int j = 1; j <= idx; j++) {
                        sum += j;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("{" + thread.getName() + "} 1~" + idx + " 합 계산 완료");
                    sumPrinter.print(sum);
                }
            });
        }
        executorService.shutdown();
    }
}
