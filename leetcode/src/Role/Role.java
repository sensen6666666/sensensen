package Role;

import java.util.Random;
public class Role {
    private String name;
    private int blood;

    public Role(){
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack (Role role)//这里的Role可以看做C语言的结构体 role是Role类型定义的变量名
    {
        //计算造成的伤害
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;//范围为1~20

        //修改挨揍的人的血量
        //剩余血量
        int remainBlood = role.getBlood() - hurt;

        //对剩余血量验证，如果为负数，修改成0
        remainBlood = (remainBlood) < 0 ? 0 :remainBlood;
        //修改血量
        role.setBlood(remainBlood);

        //this表示方法的调用者
        System.out.println(this.getName() + "举起拳头，打了" +role.getName() + "一下," +
                "造成了" + hurt +"点伤害," + role.getName() + "还剩下" + remainBlood +"点血");
    }


}
