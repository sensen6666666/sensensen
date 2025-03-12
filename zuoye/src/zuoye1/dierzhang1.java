package zuoye1;
import java.util.Scanner;
public class dierzhang1 {
    public static void main(String[] args) {
        System.out.print("请输入华氏温度：");
        Scanner input = new Scanner(System.in);
        double tem;
        tem = input.nextDouble();
        double hua;
        hua = (5.0 / 9) * (tem - 32);
        System.out.println("摄氏温度为" + hua);
    }
}
