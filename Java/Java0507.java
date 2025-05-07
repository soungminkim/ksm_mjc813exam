public class Java0507 {
    public static void main(String[] args) {
        // 이것이 자바다 연산자 챕터
        // 문제 3번 534 자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고,
        // 마지막에 몇 개가 남는지를 구하는 코드입니다. () 에 들어갈 알맞은 코드를 차례대로 작성해 보세요.
        int pencils = 534;
        int students = 30;

        int pencilsPerStudent = pencils / students; // (pencils / students)
        System.out.println(pencilsPerStudent);

        int pencilsLeft = pencils % students; // (pencils % students)
        System.out.println(pencilsLeft);
    }
}
