package com.itheima.demo1;
public class CurrentTime {
    public static void main(String[] args) {
        //获取当前时间的毫秒数
        long t = System.currentTimeMillis();
        //将毫秒数转成秒数
        long seconds = t / 1000;
        //计算当前的秒数（0~59）
        long s = seconds % 60;
        //总的分钟数
        long minutes = seconds / 60;
        long m = minutes % 60;
        //总的小时数
        long hours = minutes / 60;
        long h = (hours % 24) + 8;
        System.out.println("当前时间:" + h + ":" + m + ":" + s);
    }
}
