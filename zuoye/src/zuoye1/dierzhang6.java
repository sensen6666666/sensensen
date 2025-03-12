package zuoye1;
import java.util.Scanner;
public class dierzhang6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float w;
        float h;
        float BMI;
        System.out.print("请输入您的体重（kg）：");
        w = input.nextFloat();
        System.out.print("请输入您的身高（m）：");//
        h = input.nextFloat();
        BMI = w / h / h;
        System.out.print("您的BMI为" + BMI);
    }
}
