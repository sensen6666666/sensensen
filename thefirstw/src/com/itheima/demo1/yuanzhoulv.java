package com.itheima.demo1;
import java.util.Scanner;
public class yuanzhoulv {
    public static void main(String[] args) {
        double radius;
        double area,perimeter;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入半径值:");
        radius = input.nextDouble();
        area =Math.PI * radius *radius;
        perimeter = 2* Math.PI *radius;
        System.out.println("圆的面积为:" + area);
        System.out.println("圆的周长为:" + perimeter);
    }

}
