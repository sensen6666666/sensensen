package com.itheima.demo1;

public class CastDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);//
        double pi = Math.PI;//要达到保留四位小数的效果
        pi = pi *10000 +0.5;//四舍五入
        pi = (int )pi;//强制转换成整数
        pi = pi /10000;//再除以一万，达到四舍五入的效果
        System.out.println(pi);
    }
}
