package bookexample.ch15;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("JAVA");
        set.add("JDBC");
        set.add("JSP");
        set.add("JAVA");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("JSP")) {
                //가져온 객체 컬렉션에서 제거
                iterator.remove();
            }
        }
        System.out.println();

        set.remove("JDBC");
        for (String element : set) {
            System.out.println(element);
        }

        int size = set.size();
        System.out.println("총 객체 수: "+size);
    }
}
