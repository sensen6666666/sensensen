package com.itheima.demo1;
import java.util.Scanner;//Scanner类存在java.util包中，因此需要使用import语句导入
public class yuanzhoulv {
    public static void main(String[] args) {
        double radius;
        double area,perimeter;
        Scanner input = new Scanner(System.in);//创建Scanner类实例input
        System.out.println("请输入半径值:");
        radius = input.nextDouble();//然后调用nextDouble()方法从键盘读取一个double类型数据赋给radius
                                    //这里读取需要注意nextDouble的大写问题
        int a;
        System.out.println("请输入a的值:");
        a = input.nextInt();
        area =Math.PI * radius *radius;//程序中圆周率使用Math类的PI常量
        perimeter = 2 * Math.PI *radius;
        System.out.println("a的值为:" + a);
        System.out.println("圆的面积为:" + area);
        System.out.println("圆的周长为:" + perimeter);
    }

}
