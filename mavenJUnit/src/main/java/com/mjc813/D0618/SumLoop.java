package com.mjc813.D0618;

import java.util.concurrent.*;

public class SumLoop {
    public static void main(String[] args) {
        Long ms = System.currentTimeMillis();
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
                    System.out.printf("[%s] 1~%d = %d\n"
                           , Thread.currentThread().getName()
                           , idx
                           , sum
                    );
                }
            });
        }
        executorService.shutdown();
        try{
            if (executorService.awaitTermination(10, TimeUnit.MINUTES)) {
                long elapsed = System.currentTimeMillis() - ms;
                System.out.printf("모든 작업에서 소요시간: %d ms\n", elapsed);
            } else {
                System.out.printf("시간 내에 작업이 종료되지 않았습니다.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
