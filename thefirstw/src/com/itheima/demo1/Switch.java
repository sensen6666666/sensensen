package com.itheima.demo1;

import java.time.DayOfWeek;

public class Switch {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.SATURDAY;
        int numLetters = switch(day)
        {
            case MONDAY,FRIDAY,SUNDAY ->6;
            case TUESDAY ->7;
            case THURSDAY,SATURDAY -> 8;
            case WEDNESDAY ->9;

        };
        System.out.println(numLetters);
    }
}
