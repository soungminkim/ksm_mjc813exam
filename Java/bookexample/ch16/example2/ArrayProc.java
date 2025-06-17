package bookexample.ch16.example2;

import java.util.ArrayList;
import java.util.List;

public class ArrayProc {
    public static void sum(List<Integer> inputList) {

        IArrayProc proc = (list -> {
            Long sum = 0L;
            for (Integer integer : list) {
                sum += integer;
            }
            return sum;
        });
        // List<Integer> numbers = List.of(10,20,30,40);
        Long sum = proc.process(inputList);
        System.out.printf("합은 {%d} 입니다. \n", sum);
    }

    public static void avg(List<Integer> inputList) {
        IArrayProc proc = (list -> {
            Long avg = 0L;
            for (Integer integer : list) {
                avg += integer;
            }
            return avg / list.size();
        });
        Long avg = proc.process(inputList);
        System.out.printf("평균은 {%d} 입니다.\n", avg);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        sum(list);
        avg(list);
    }
}
