package ru.mail.park.tp_android_hometask1;

import android.graphics.Color;

public class Digit {
    private int value;
    private int color;

    public Digit(int value){
        this.value = value;
        if (value % 2 == 0) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }
    }

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }
}
