package com.itheima.demo1;
import java.util.Scanner;
public class swtich {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入一个季节（1,2,3,4）");
        int season = input.nextInt();
        switch(season)
        {
            case 1 -> System.out.println("春雨惊春清谷天");
            case 2 -> System.out.println("夏");
            case 3 -> System.out.println("秋");
            case 4 -> System.out.println("冬");
            default -> System.out.println("数字输入非法");
        }
    }
}
