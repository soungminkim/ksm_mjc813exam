package bookexample.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);

        System.out.println("총 엔트리 수 : "+map.size());
        System.out.println();

        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        Set<String> keyset = map.keySet();
        Iterator<String> iterator = keyset.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            Integer v = map.get(k);
            System.out.println(k + ": " + v);
        }
        System.out.println();

        Set<Entry<String, Integer>> set = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = set.iterator();;
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
        System.out.println();

        map.remove("홍길동");
        System.out.println("총 엔트리 수 : " + map.size());
        System.out.println();
    }
}
