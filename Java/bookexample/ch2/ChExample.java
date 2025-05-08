package bookexample.ch2;

public class ChExample {
    public static void main(String[] args) {
        class Example5 {   //5. 다음 자동 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
            byte byteValue = 10;
            char charValue = 'A';

            int intValue = byteValue;
            int intValue1 = charValue;

            // short shortValue = charValue;
            // 해당 형변환 에서는 short와 char이 바이트수가 같기에 char 그대로 유지해서 자동 타입 변환에서 컴파일 에러가 발생

            double doubleValue = byteValue;
        }
        class Example6 {   //6. 다음 강제 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
            int intValue = 10;
            char charValue = 'A';
            double doubleValue = 5.7;
            String strValue = "A";

            double var = (double) intValue;
            byte var1 = (byte) intValue;
            int var2 = (int) doubleValue;
            // char var3 = (char) strValue;
            // string은 기본데이터형이 아니기에 강제형변환도 가져올수있다
            char var3 = Character.valueOf(charValue);
            // 하면서 알게된점 해당 함수를 호출시켜서 print 시키는건 불가능함
            // 해당 객체를 메인에 멤버로 해두고 Example6 example6 = new Example6();
            // 이상태에서 System.out.println(Example6.var3); 로 출력가능함 출력시 A가 나오는걸 확인함
        }
        class Example7 {    //7. 변수를 잘못 초기화한 것은 무엇입니까?
            int var1 = 10;
            long var2 = 110000000000L;
            // char var3 = ''; 불가능 공백이라도 넣어둬야함
            float var4 = 10;
            String var5 = "abc\ndef";
            String var6 = """
                    abc
                    def
                    """;
        }
        class Example9 {    //9. 연산식의 타입 변환중에서 컴파일 에러가 발생하는 것을 선택하세요.
            byte byteValue = 10;
            float floatValue = 2.5f;
            double doubleValue = 2.5;

            // byte result = byteValue + byteValue;
            // 연산시 기본 데이터형인 int로 승격되는데 이때 byte로 넣으려고 하니 자동 연산에서 실패 한것
            // (byte)를 붙혀 바이트 형으로 강제 형변환 해주면 실행 성공함.
            int result1 = 5 + byteValue;
            float result2 = 5 + floatValue;
            // 검색하면서 알게 된 사실인데 byte·short 같은 작은 정수 타입끼리 연산할 때는 “정수 타입이어서” JLS 규칙에 따라 무조건 int 로 승격
            // 실수형은 연산식 비교만 한다고 함.
            double result3 = 5 + doubleValue;
        }
        class Example10 {   //10. 문자열을 기본 타입으로 변환하는 코드로 틀린 것을 고르세요.
            String str = "5";

            byte var1 = Byte.parseByte(str);
            byte var1_1 = Byte.valueOf(str);

            //int var2 = Int.parseInt(str); Integer 사용 해야 함
            int var2 = Integer.parseInt(str);
            int var2_1 = Integer.valueOf(str);

            float var3 = Float.parseFloat(str);
            float var3_1 = Float.valueOf(str);

            double var4 = Double.parseDouble(str);
            double var4_1 = Double.valueOf(str);
        }
    // Example10 example10 = new Example10();
    // System.out.println(example10.var1);
    // System.out.println(example10.var1_1);
    // System.out.println(example10.var2);
    // System.out.println(example10.var2_1);
    // System.out.println(example10.var3);
    // System.out.println(example10.var3_1);
    // System.out.println(example10.var4);
    // System.out.println(example10.var4_1);


    //11 다음 코드에서 컴파일 에러가 발생하는 라인을 모두 적어 보세요.
    int v1 = 1;
    System.out.println("v1: "+v1);
    if(true){
        int v2 = 2;
            if(true) {
                int v3 = 2;
                System.out.println("v1: " + v1);
                System.out.println("v2: " + v2);
                System.out.println("v3: " + v3);
            }
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        //System.out.println("v3: " + v3); 해당 블록에선 v3가 선언이 없음.
        }
    System.out.println("v1: " + v1);
    //System.out.println("v2: " + v2); 위에 v3 와 동일
    }
}
