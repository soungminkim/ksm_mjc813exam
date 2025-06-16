package bookexample.ch15;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class VectorExample {
    public static void main(String[] args) {
        // 백터로 할시 멀티 스레드에서 2000개 객체가 확실히 나옴
        // List<Board> list = new Vector<>();
        // ArrayList로 사용시 지맘대로 나옴 1912 출력됨
        List<Board> list = new ArrayList<>();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(new Board("제목"+i,"내용"+i,"글쓴이"+i));
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(new Board("제목"+i,"내용"+i,"글쓴이"+i));
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        }catch (InterruptedException e) {
        }

        int size = list.size();
        System.out.println("총 객체 수 :"+size);
    }
}
