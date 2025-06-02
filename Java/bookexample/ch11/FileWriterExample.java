package bookexample.ch11;

import java.io.IOException;
// 8. FileWriter는 파일을 열고 데이터를 저장하는 클래스입니다.
// 예외 발생 여부와 상관 없이 마지막에는 close() 메소드를 실행해서 파일을 닫아주려고 합니다.
// 왼쪽 코드는 try-catch-finally를 이용해서 작성한 코드로 리소스 자동 닫기를 이용하도록 수정하고 싶습니다.
// 수정한 코드를 오른쪽에 작성해보세요.

public class FileWriterExample {
    public static void main(String[] args) {
        // 수정전
        //FileWriter fw = null;
        // try {
        //     fw = new FileWriter("file.txt");
        //     fw.write("Java");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } finally {
        //     try { fw.close(); } catch
        //     (IOException e) {}
        // }

        try(FileWriter fw = new FileWriter("file.txt")) {
            fw.write("java");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
