package StudentSystem;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        loop:while (true) {
            System.out.println("请输入您的选择：1.登录 2.注册 3.忘记密码 4.退出系统：");
            String choose =sc.next();
            switch(choose)
            {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" ->{
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("请重新输入");
            }
        }


    }

    //注册
    public static void register(ArrayList<User> list) {
        String username;String password;String personID;String phoneNumber;
        //1.键盘录入用户名
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            username = sc.next();
            //细节：先验证格式是否正确，再验证唯一性
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("用户名格式不满足条件，需要重新输入");
                continue;
            }

            //检验用户名唯一
            boolean flag2 = contains(list, username);
            if(flag2)
            {
                System.out.println("用户名" + username + "已存在，请重新输入");
            }
            else break;
        }

        //2.键盘录入密码
        //密码键盘输入两次，两次一致才可以进行注册
        while(true)
        {
            System.out.println("请输入要注册的密码：");
            password = sc.next();
            System.out.println("请再次输入密码：");
            String againpassword = sc.next();
            if(!password.equals(againpassword)) {
                System.out.println("两次输入密码不一致，请重新输入");
            }
            else {
                System.out.println("两次输入一致");
                break;
            }

        }

        //3.录入身份证号码
        while (true) {
            System.out.println("请输入身份证号码：");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if(flag)
            {
                System.out.println("身份证号满足要求");
                break;
            }
            else {
                System.out.println("身份证号格式有误，请重新输入");
            }
        }

        //4.键盘录入手机号码
        while (true) {
            System.out.println("请输入手机号码：");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if(flag)
            {
                System.out.println("手机号格式正确");break;
            }
            else {
                System.out.println("手机号格式错误，请重新输入");
            }
        }

        //用户名，密码等放到用户对象中
        User u = new User(username,password,personID,phoneNumber);
        //把用户对象添加到集合中
        list.add(u);
        System.out.println("注册成功");

        //遍历集合
        printlist(list);
    }

    //登录
    private static void login(ArrayList<User> list)
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i<3;i++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            boolean flag = contains(list,username);
            if(!flag)
            {
                System.out.println(username + "未注册，请先注册再登录");
                return;
            }
            System.out.println("请输入密码");
            String password = sc.next();

            while (true) {
                String rightCode = getCode();
                System.out.println("当前正确的验证码为：" + rightCode);
                System.out.println("请输入验证码");
                String code = sc.next();
                if(code.equalsIgnoreCase(rightCode))
                {
                    System.out.println("验证码正确");
                    break;
                }
                else {
                    System.out.println("验证码错误，请重新输入");
                }
            }

            //验证用户名和密码是否正确
            //集合中是否包含用户名和密码
            //定义一个方法验证用户名和密码是否正确

            //封装思想的应用：
            //我们可以把一些零散的数据，封装成一个对象
            //以后传递参数的时候，只要传递一个整体就可以了，不需要管这些零散的数据
            User u = new User(username,password,null,null);

            boolean flag1 = checkUserInfo(list,u);

            if(flag1)
            {
                System.out.println("登录成功，可以开始使用学生管理系统了");break;
            }
            else {
                System.out.println("登录失败，用户名或密码错误");
                if(i == 2)
                {
                    System.out.println("三次机会已全部用尽，当前账户已被锁定");
                }
                else {
                    System.out.println("还剩" + (2-i) + "次机会");
                }
            }
        }
    }


    private static boolean checkUserInfo(ArrayList<User> list,User userInfo)
    {
        //遍历集合，判断用户是否存在，如果存在登录成功，如果不存在登录失败
        for(int i = 0;i<list.size();i++)
        {
            User user = list.get(i);
            if(user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword()))
            {
                return true;
            }
        }
        return false;
    }

    //生成验证码
    private static String getCode()
    {
        //1.创建一个集合添加所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0;i<26;i++)
        {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        //2.要随机抽取4个字符
        Random r = new Random();
        for(int i=0;i<4;i++)
        {
            //获取随机索引
            int index = r.nextInt(list.size());
            //利用随机索引获取字符
            //把字符添加到sb中
            sb.append(list.get(index));
        }

        //3.把一个随机数字添加到末尾
        sb.append(r.nextInt(10));

        //4.如果我们要修改字符串中的内容
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length -1];
        arr[arr.length - 1]=temp;
        return new String(arr);
    }

    //忘记密码
    private static void forgetPassword(ArrayList<User> list)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username =sc.next();
        boolean flag = contains(list,username);
        if(!flag)
        {
            System.out.println("当前用户" + username + "未注册，请先注册");
            return;
        }

        //键盘录入身份证号码和手机号码
        System.out.println("请输入身份证号码");
        String personID = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();

        //比较用户对象中的手机号码和身份证号码是否相同
        //需要把用户对象先获取出来
        int index = findIndex(list,username);
        User user = list.get(index);
        //比较用户对象中的手机号码和身份证号码是否相同
        if(!(user.getPersonID().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber)))
        {
            System.out.println("身份证号码或手机号输入有误，不能修改密码");
            return;
        }

        //当代码执行到这里，表示所有的数据全部验证成功，直接修改
        String password;
        while(true)
        {
            System.out.println("请输入新的密码");
            password = sc.next();
            System.out.println("请再次输入密码");
            String againPassword = sc.next();
            if(password.equals(againPassword))
            {
                System.out.println("两次输入密码一致");
                break;
            }
            else {
                System.out.println("两次密码输入不一致，请重新输入");
            }
        }
        user.setPassword(password);
    }

    private static int findIndex(ArrayList<User> list,String username)
    {
        for(int i = 0;i< list.size();i++)
        {
            User user = list.get(i);
            if(user.getUsername().equals(username))
            {
                return i;
            }
        }
        return -1;
    }
    private static void printlist(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++)
        {
            User user = list.get(i);
            System.out.println(user.getUsername() + ","+user.getPassword() +","+ user.getPersonID() + ","+user.getPhoneNumber());
        }
    }
    private static boolean checkPhoneNumber(String phoneNumber)
    {
        //长度为11位
        if(phoneNumber.length() != 11)
        {
            return false;
        }
        //不能以0为开头
        if(phoneNumber.startsWith("0"))
        {
            return false;
        }
        //必须都是数字
        for(int i = 0;i<phoneNumber.length();i++)
        {
            char c = phoneNumber.charAt(i);
            if(c<'0'||c>'9')
            {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonID(String personID)
    {
        //长度为18位
        if(personID.length() != 18)
            return false;
        //不能以0为开头
        if(personID.startsWith("0"))
        {
            //如果以0开头，返回false
            return false;
        }
        /*此处也可替换为
           if(personID.charAt(0) == '0')
            return false;
         */

        //前17位，必须都是数字
        for(int i = 0;i<personID.length() - 1;i++)
        {
            char c = personID.charAt(i);
            //如果有一个字符不在0~9之间，直接返回false
            if(!(c >= '0' && c <= '9'))
            {
                return false;
            }
        }

        //最后一位可以是数字，也可以是大写X或小写x
        char endChar = personID.charAt(personID.length() - 1);
        return (endChar >= '0' && endChar <= '9') || (endChar == 'X') || (endChar == 'x');
    }
    public static boolean contains(ArrayList<User> list,String username)
    {
        for(int i = 0;i<list.size();i++)
        {
            User user = list.get(i);
            String rightUsername = user.getUsername();
            if(rightUsername.equals(username))
                return true;
        }
        return false;
    }

    public static boolean checkUsername(String username) {
        int len = username.length();
        if (len < 3 || len > 15) {
            return false;
        }
        //用户名不能是纯数字
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char temp = username.charAt(i);
            if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }
}