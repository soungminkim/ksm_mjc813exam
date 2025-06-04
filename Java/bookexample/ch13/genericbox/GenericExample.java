package bookexample.ch13.genericbox;

public class GenericExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>(); // String으로 제네릭 클래스 new 생성
        box1.content = "안녕하세요."; // Box value 에 String으로 들어감
        String str = box1.content;
        System.out.println(str);

        Box<Integer> box2 = new Box<>(); // Interger로 제네릭 클래스 new 생성
        box2.content = 100; // Box value에 Integer로 들어감
        int value = box2.content;
        System.out.println(value);

        Box<String> box3 = new Box<>();
        box3.content = "100";

        Box<String> box4 = new Box<>();
        box4.content = "100";

        boolean result1 = box3.compare(box4);
        System.out.println("result1: " + result1);
    }
}
