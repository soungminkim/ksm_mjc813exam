package bookexample.ch16.example1;




public class NumberProc{
    public static void printHuman(INumberProc inp){
        String str = "홍길동";
        Integer age = 30;
        inp.process(str, age);
    }

    public static void printCar(INumberProc inp){
        String str = "현대자동차";
        Integer age = 30;
        inp.process(str, age);
    }

    public static void main(String[] args){
        printHuman((str, age) -> System.out.println("{" + str + "}" + " 님의 나이는 " + "{" + age + "}"+ " 입니다."));

        printCar((str, age) -> System.out.println("자동차 " + "{" + str + "}" + " 의 년식은 " + "{" + age + "}"+ " 입니다."));
    }
}