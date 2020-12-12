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
        ListNode3 pre = new ListNode3(0);
        pre.next = head;
        ListNode3 f = pre;
        while (f.next != null && f.next.next != null) {
            ListNode3 start = f.next;
            ListNode3 end = f.next.next;
            f.next = end;
            start.next = end.next;
            end.next = start;
            f = start;
        }
        return pre.next;
    }

    public static ListNode3 swapPairs2(ListNode3 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode3 next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode3 res = swapPairs2(new ListNode3(1, new ListNode3(2, new ListNode3(3, new ListNode3(4)))));
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}