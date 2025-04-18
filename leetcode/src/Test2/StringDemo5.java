package Test2;

import java.util.Scanner;
public class StringDemo5 {
    public static void main(String[] args) {
        //1.键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();
        //2.进行遍历
        for(int i = 0;i<str.length();i++)
        {
            char c = str.charAt(i);//ctrl alt + v 自动生成
            System.out.println(c);
        }
    }
}
