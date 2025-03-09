package com.itheima.demo1;
import java.util.Scanner;
public class Yield {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入一个年份");
        int year = input.nextInt();
        System.out.print("输入一个月份");
        int month = input.nextInt();
        int numDays = switch(month)
        {
            case 1,3,5,7,8,10,12 ->31;
            case 4,6,9, 11 ->30;
            case 2 ->{
                if(((year % 4 ==0)&&!(year % 100 == 0))||(year % 400 == 0))
                    yield 29;//yield受限关键字，返回一个值，只跳出当前switch语句块
                else yield 28;
            }
            default ->0;//在使用yield的时候，需要有default语句
        };//分号是赋值语句的结束
        System.out.println("该月的天数为" + numDays);
    }
}
