package com.itheima.demo1;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = 10 + (int)(Math.random() * 90);
        int number2 = 10 + (int)(Math.random() * 90);
        int operator = (int)(Math.random()*2);
        int result,answer;
        if(operator == 0)//operator为零表示加法
        {
            result = number1 + number2;
            System.out.println(number1 + "+" + number2);
        }
        else {
            if(number1<number2)
            {
                int temp=number2;
                number2 = number1;
                number1 = temp;
            }
            result = number1 - number2;
            System.out.println(number1 + "-" + number2);
        }
        answer = input.nextInt();//接受用户输入答案
        if(answer == result)
        {
            System.out.println("恭喜你，回答正确");
        }
        else{
            System.out.println("回答错误");
        }
    }
}
/*
生成随机数也可以用java..util.random类
Random rand = new Random();
int number = 10 + rand.nextInt(90);
*/
