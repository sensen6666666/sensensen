import java.util.Scanner;
public class pingwei
{
    public static void main(String[] args) {
        int[] scoreArr = getScores();
        for(int i = 0;i<scoreArr.length;i++)
        {
            System.out.print(scoreArr[i] + " ");
        }
        System.out.println("\n");
        int max = getMax(scoreArr);
        int min = getMin(scoreArr);
        int sum = getSum(scoreArr);
        double avg = 1.0 *  (sum-max-min)/(scoreArr.length-2);
        System.out.print("最终得分为" + avg);
    }
    //求总分
    public static int getSum(int[] scoreArr)
    {
        int sum = 0;
        for (int i = 0; i < scoreArr.length; i++) {
            sum = sum + scoreArr[i];
        }
        return sum;
    }
    //求最大值
    public static int getMax(int[] scoreArr)
    {
        int max = scoreArr[0];
        for(int i = 0;i < scoreArr.length;i++)
        {
            if(max > scoreArr[i])
            {
                max  = scoreArr[i];
            }
        }
        return max;
    }

    //求最小值
    public static int getMin(int[] scoreArr)
    {
        int min = scoreArr[0];
        for(int i = 0;i < scoreArr.length;i++)
        {
            if(min < scoreArr[i])
            {
                min  = scoreArr[i];
            }
        }
        return min;
    }
    //从键盘读取数据
    public static int[] getScores(){
        int[] scores = new int[6];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i < scores.length;)
        {
            System.out.print("请输入第"+ (i + 1) +"位评委的评分");
            int score = sc.nextInt();
            if(score >= 0 && score <= 100)
            {
                scores[i] = score;
                i++;//i++应该放在这里，如果输入的值不符合规范的话就不会往下直接跳转了，而是停留在当前值
                    //很重要
            }
            else {
                System.out.println("成绩超出范围重新输入");
            }
        }
        return scores;
}
}
