package com.mjc813.studyjava;

import lombok.Data;

@Data
public class Mouse {
    private int pointX;
    private int pointY;

    public void moveMouse(int x, int y) {
        this.pointX = x;
        this.setPointX(x);

        this.pointY = y;
        this.setPointY(y);
    }
    public void clickLeftButton() {
        System.out.printf("마우스(%d, %d) 왼쪽버튼 클릭됨\n", this.pointX, this.pointY);
    }
    public void clickRightButton() {
        System.out.printf("마우스(%d, %d) 오른쪽버튼 클릭됨\n", this.pointX, this.pointY);
    }
}
