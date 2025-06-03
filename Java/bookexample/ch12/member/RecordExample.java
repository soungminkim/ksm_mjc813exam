package bookexample.ch12.member;

public class RecordExample {
    public static void main(String[] args) {
        Member m = new Member("winter", "눈송이", 25);
        System.out.println(m.id());   // get 붙혀서 사용 불가
        System.out.println(m.name()); // get 붙혀서 사용 불가
        System.out.println(m.age());  // get 붙혀서 사용 불가
        System.out.println(m.toString());
        System.out.println();

        Member m1 = new Member("winter","눈송이", 25);
        Member m2 = new Member("winter","눈송이", 25);

        System.out.println("m1.hashCode(): " + m1.hashCode());
        System.out.println("m2.hashCode(): " + m2.hashCode());
        System.out.println(m1.equals(m2));
    }
}
