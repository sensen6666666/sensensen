package com.itheima.demo1;
import java.util.Scanner;
public class fangchengzu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a,b,c,d,e,f;
        double x,y;
        System.out.println("请输入abe的值");
        a = input.nextDouble();
        b = input.nextDouble();
        e = input.nextDouble();
        System.out.println("请输入cdf的值");
        c = input.nextDouble();
        d = input.nextDouble();
        f = input.nextDouble();
        if((a * d - b* c) == 0)//
        {
            System.out.println("此方程组无解");
        }
        else{
            x = (e * d - b * f)/(a * d - b * c);
            y = (a * f - e * c)/(a * d - b * c);
            System.out.println("x = "+x);
            System.out.println("y = "+y);
        }
    }
}
