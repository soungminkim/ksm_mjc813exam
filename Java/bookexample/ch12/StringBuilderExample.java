package bookexample.ch12;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF") // 문자열 끝에 추가
                .insert(0,"ABC") // 문자열 지정 위치에 추가
                .delete(3,4) //문자열 일부를 삭제
                //.replace(시작 위치 ,끝 위치 ,문자열) 문자열 일부를 대체
                .toString(); // 완성된 문자열 리턴
        System.out.println(data);
    }
}
// 해당 결과 "ABCEF" D는 .delete(3, 4)에서 삭제
