package com.example.homework;

import android.graphics.Color;

class Number {

    private int num1;
    private int color;

    Number(int num1) {
        this.num1 = num1;
        if (num1 % 2 == 0) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }
    }

    int getNum() {
        return num1;
    }

    int getColor() {
        return color;
    }
}
