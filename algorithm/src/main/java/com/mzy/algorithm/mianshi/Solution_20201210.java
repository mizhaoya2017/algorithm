package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/12/9 17:04
 * @description：
 */
public class Solution_20201210 {
    public static ListNode3 swapPairs(ListNode3 head) {
        int i = 0;
        ListNode3 f = head;
        while (f.next != null) {
            if (i % 2 == 0) {
                ListNode3 x = f.next;
                f.next = f.next.next;
                x.next = f;
            }
            f = f.next.next;
            i ++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode3 res = swapPairs(new ListNode3(1, new ListNode3(2, new ListNode3(3, new ListNode3(4)))));
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}