package com.mjc.studyjava;

// 8. com.mjc813.studyjava.Mouse 클래스를 생성한다.
// 9. Mouse 클래스에는 정수 pointX, 정수 pointY 멤버변수를 생성한다.
// 10. Mouse 클래스에는 왼쪽버튼클릭, 오른쪽버튼클릭 2개 메소드를 생성한다.
// 11. Mouse 클래스에는 moveMouse(int x, int y) 메소드를 생성한다.
public class Mouse {
    int pointX;
    int pointY;

    public Mouse() {
        this.pointX = 0;
        this.pointY = 0;
    }

    public void moveMouse(int x, int y){
        this.pointX = x;
        this.pointY = y;
    }

    public void clickLeftButton(){
        System.out.println("마우스(" + pointX + "," + pointY + ") 왼쪽 버튼 클릭됨");

    }

    public void clickRightButton(){
        System.out.println("마우스(" + pointX + "," + pointY + ") 오른쪽 버튼 클릭됨");
    }
}
