package com.mzy.algorithm.heap;

import lombok.Data;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author ：mizhaoya
 * @date ：2020/9/14 17:03
 * @description：
 */
@Data
public class BankSimulation {
    private int k;
    private BinaryHeap<People> list;
    private int tick = 0;
    private List<Bank> bank;
    private Queue<People> queue;

    public BankSimulation() {
        for(int i = 0; i < 50; i ++) {
            list.insert(new People());
        }
        for (int j = 0; j < k; j ++) {
            bank.add(new Bank());
        }
    }

    public void timeFlow() {
        for (; tick < 1000; tick ++) {
            //0、判断有空柜台没
            List<Bank> b = bank.stream().filter(x -> x.isEmpty()).collect(Collectors.toList());
            //1、判断队列有人没和有人进来没
            People min = list.findMin();
            if (b.size() >0 &&!queue.isEmpty()) {
                People remove = queue.remove();
                Bank bank = b.get(0);
                bank.setLeaveTime(remove.getArriveTime() + remove.getInterval());
                bank.setEmpty(false);
            } else if (min.getArriveTime() == tick) {
                if (b.size() > 0) {
                    //2.1、进入柜台
                    Bank bank = b.get(0);
                    bank.setLeaveTime(min.getArriveTime() + min.getInterval());
                    bank.setEmpty(false);
                } else {
                    //2.2、入队列
                    queue.add(min);
                }
                list.deleteMin();
            }

            //3、判断有人离开没
            for (Bank ban: bank) {
                if (!ban.isEmpty() && ban.getLeaveTime() == tick) {
                    ban.setEmpty(true);
                    ban.setLeaveTime(0);
                }
            }
        }
    }


}

@Data
class People implements Comparable<People> {
    private int arriveTime;
    private int interval;
    private int waitTime;
    public People() {
        arriveTime = (int) (Math.random() * 100) + 1;
        interval = (int) (Math.random() * 100);
    }

    @Override
    public int compareTo(People o) {
        return o.arriveTime - this.arriveTime;
    }
}

@Data
class Bank {
    private boolean isEmpty;
    private int leaveTime;
    public Bank() {
        isEmpty = true;
        leaveTime = 0;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
}
