package bookexample.ch6;

public class ChExample {
    public static void main(String[] args) {
        Member member = new Member();
        boolean result = member.login("hong", "12345");

        if (result) {
            System.out.println("로그인 되었습니다.");
            member.logout("hong");
        }
        else {
            System.out.println("id 또는 password가 올바르지 않습니다.");
        }
        
        Printer printer = new Printer();
        printer.println(10);
        printer.println(true);
        printer.println(5.7);
        printer.println("홍길동");

        ShopService obj1 = ShopService.getInstance();
        ShopService obj2 = ShopService.getInstance();

        if (obj1==obj2) {
            System.out.println("같은 ShopService 객체입니다.");
        }
        else {
            System.out.println("다른 ShopService 객체입니다.");
        }
    }
}

// 13번 현실 세계의 회원을 Member 클래스로 모델링하려고 합니다. 회원의 데이터로는 이름, 아이디, 패스워드, 나이가 있습니다. 이 데이터들을
// 가지는 Member 클래스를 선언해 보세요.
// 14번 13번 문제에서 작성한 member 클래스에 생성자를 추가하려고 합니다. 다음과 같이 name 필드와 id 필드를 외부에서 받은 값으로 초기화하도록
// 생성자를 선언해 보세요.
// 15번 login 메소드를 호출할 떄에는 매개값으로 id와 password 를 제공하고 logout 메소드는 id 만 매개값으로 제공하려고 합니다 다음 조건과
// 예쩨 코드를 보고 memberservice 클래스에서 login(), logout() 메소드를 선언해 보세요.
class Member{
    String name;
    String id;
    String password;
    int age;

    public boolean login(String id, String password){
        this.id = "hong"; 
        this.password = "12345";
        return this.id.equals(id) && this.password.equals(password);
    }

    public void logout(String id){
        System.out.println(id + "님이 로그아웃 되었습니다.");
        this.id = null;
        this.password = null;
        this.age = 0;
        this.name = null;
    }
}

// 16번 println() 메소드는 매개값을 콘솔에 출력합니다. println() 메소드의 매개값으로 int, boolean, double, String 타입값을 줄 수
// 있습니다.다음 조건과 예제 코드를 보고 printer 클래스에서 println 메소드를 오버로딩 하여 선언해 보세요.

// 17번 16번 문제에서는 Print 객체를 생성하고 println 메소드를 호출했습니다. 이번에는
// Printer 객체를 생성하지 않고도 다음과 같이 호출할 수 있도록 Printer 클래스를 수정해보세요.

class Printer {
    void println(int a){ // 17번 처럼 할려면 static으로 다 선언하면 가능함
        System.out.println(a);
    }
    void println(boolean b){
        System.out.println(b);
    }
    void println(double c){
        System.out.println(c);
    }
    void println(String d){
        System.out.println(d);
    }
}
// 18번 다음 예제 코드가 실행되면 "같은 ShopService 객체입니다." 라는 메시지가 출력되도록, 싱글
// 톤 패턴을 사용해서 ShopService 클래스를 작서앻보세요.

class ShopService{
    private static ShopService shopservice = new ShopService();
    private ShopService(){}
    public static ShopService getInstance(){
        return shopservice;
    }
}