package Test2;

public class StringDemo6 {
    public static void main(String[] args) {
        //1.获取说的话
        String talk = "你玩的真好，CNM，TMD";
        //2.定义敏感词库
        String[] arr = {"TMD","CNM","SB"};

        //3.循环得到数组中的每一个敏感词，依次进行替换
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i],"***");
        }

        System.out.println(talk);
    }
}
