package com.mzy.algorithm.thread;

/**
 * @author ：mizhaoya
 * @date ：2020/9/18 16:58
 * @description：
 */
public class TestThread {
    static final int r_distance = 200;
    static String winner;
    public static void main(String[] args) {
        rabbit r = new rabbit();
        tortoise t = new tortoise();
        new Thread(r).start();
        new Thread(t).start();
        System.out.println("开始赛跑");

    }

}

class rabbit implements Runnable{
    private int speed = 5;
    private int r_distance = 0;
    private boolean sleep = false;
    @Override
    public void run() {
        while(TestThread.winner == null) {
            r_distance += speed;
            System.out.println("兔子跑了"+r_distance+"米");
            try {
                Thread.sleep(50);
                if (r_distance >= 100 && !sleep) {
                    System.out.println("兔子累了，在睡觉");
                    Thread.sleep((long)(10000 * Math.random()));
                    speed=3;
                    sleep= true;
                }

            }catch (Exception e){

            }
            if (r_distance > TestThread.r_distance) {
                TestThread.winner = "兔子";
            }
        }
        System.out.println(TestThread.winner+"胜利");
    }
}

class tortoise implements Runnable{

    private int speed = 2;
    private int r_distance = 0;
    @Override
    public void run() {
        while (TestThread.winner == null) {
            r_distance += speed;
            System.out.println("乌龟跑了"+r_distance+"米");
            try {
                Thread.sleep(50);
            } catch (Exception e){

            }
            if (r_distance > TestThread.r_distance) {
                TestThread.winner = "乌龟";
            }
        }
        System.out.println(TestThread.winner+"胜利");
    }
}
