package com.itheima.demo1;
import java.util.Scanner;
public class jipiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价");
        int ticket =sc.nextInt();
        System.out.println("请输入当前的月份");
        int month = sc.nextInt();
        System.out.println("请输入当前购买的舱位 0 头等舱 1 经济舱");
        int seat = sc.nextInt();
        if(month >= 5 &&month <=10)
        {
            //旺季
            ticket = getTicket(ticket,seat,0.9,0.85);
        } else if ((month >=1 &&month <= 4)||(month >= 11 && month <= 12)) {
            //淡季
            ticket = getTicket(ticket,seat,0.7,0.65);
        }
        else {
            System.out.println("键盘录入的月份不合法");
        }
        System.out.println(ticket);
    }

    private static int getSeat(Scanner input) {
        return input.nextInt();
    }

    public static int getTicket(int ticket,int seat, double v, double v2)
    {
        if (seat == 0)
        {
            //头等舱
            ticket = (int) (ticket * v);
        }
        else if(seat == 1)
      {
        //经济舱
        ticket = (int)(ticket * v2);
      }
        else
        {
            System.out.println("没有这个舱位");
        }
        return ticket;
    }
}
