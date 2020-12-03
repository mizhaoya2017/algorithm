package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/3 11:02
 * @description：
 */
public class Solution_20201203 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0, head);
        if (head == null) {
            return null;
        }
        int len = getLen(head);
        if (len == 1 && n == 1) {
            return null;
        }
        int i = len - n + 1;
        int x = 1;
        ListNode res = dum;
        while (x < i) {
            res = res.next;
            x ++;
        }
        res.next = res.next.next;
        ListNode ans = dum.next;
        return ans;
    }

    public static boolean isValid(String s) {
        return true;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1, new ListNode(2));
//        ListNode x = null;
//        ListNode x = new ListNode(1);
//        ListNode x = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(x, 2);
        System.out.println(listNode);
    }

    private static int getLen(ListNode head) {
        int len = 1;
        ListNode zz = head;
        while (zz.next != null) {
            zz = zz.next;
            len ++;
        }
        return len;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
