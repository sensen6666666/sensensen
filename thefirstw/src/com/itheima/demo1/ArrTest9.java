package com.itheima.demo1;

import java.util.Random;

public class ArrTest9 {
    public static void main(String[] args) {
        //需求：定义一个数组，存入1~5，要求打乱数组中所有数据的顺序
        int[] arr ={1,2,3,4,5};
        Random r = new Random();

       for(int i = 0;i < arr.length;i++)
        {
            //生成一个随机索引
            int randomIndex = r.nextInt(arr.length);
            //拿着随机索引指向的元素跟i指向的元素进行交换
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex]=temp;
        }
        for(int i = 0;i< arr.length ; i++)
        {
            System.out.println(arr[i] + " ");
        }



    }
}
