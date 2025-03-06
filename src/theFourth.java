import java.util.Scanner;

public class theFourth {
    public static void main(String[] args)
    {
        double radius;
        double area,perimeter;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入半径值");
        radius = input.nextDouble();
        perimeter =2 * Math.PI *radius;area=Math.PI *radius *radius;
        System.out.println("圆的面积为" +  area);
        System.out.println("圆的面积为" + perimeter);
    }


}
