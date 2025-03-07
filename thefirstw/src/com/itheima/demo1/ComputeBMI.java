package com.itheima.demo1;
import java.util.Scanner;
public class ComputeBMI {
    public static void main(String[] args)
    {
            Scanner input = new Scanner(System.in);
            double weight,height;
            double bmi;
            System.out.print("请输入你的体重(单位：公斤）");
            weight = input.nextDouble();
        System.out.print("请输入你的身高（单位：米）:");
        height = input.nextDouble();
        bmi = weight / (height * height);
        System.out.println("您的bmi为" + bmi);
        if(bmi<18.5)
        {
            System.out.println("偏瘦");
        }
        else if(bmi<25.0)
        {
            System.out.println("正常");
        }
        else if(bmi<30.0)
        {
            System.out.println("超重");
        }
        else
        {
            System.out.println("过胖");
        }
    }


}
