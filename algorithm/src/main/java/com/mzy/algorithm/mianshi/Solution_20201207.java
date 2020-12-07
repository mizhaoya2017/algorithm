package com.mzy.algorithm.mianshi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：mizhaoya
 * @date ：2020/12/3 11:02
 * @description：
 */
public class Solution_20201207 {

    public static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        if (l1== null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode2 s1 = l1;
        ListNode2 s2 = l2;
        ListNode2 res = new ListNode2();
        ListNode2 s3 = res;
        while(s1 != null || s2 != null) {
            if (s1 == null) {
                s3.next = s2;
                break;
            }
            if (s2 == null) {
                s3.next = s1;
                break;
            }
            if (s1.val == s2.val) {
                s3.next = new ListNode2(s1.val);
                s3 = s3.next;
                s3.next = new ListNode2(s2.val);
                s3 = s3.next;
                s1 = s1.next;
                s2 = s2.next;

            } else if (s1.val > s2.val) {
                s3.next = new ListNode2(s2.val);
                s2 = s2.next;
                s3 = s3.next;
            } else if (s1.val < s2.val) {
                s3.next = new ListNode2(s1.val);
                s1 = s1.next;
                s3 = s3.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode2(1, new ListNode2(2, new ListNode2(4))), new ListNode2(1, new ListNode2(3, new ListNode2(4)))));
        System.out.println(mergeTwoLists(null, new ListNode2()));
        System.out.println(mergeTwoLists(new ListNode2(2), new ListNode2(1)));
    }
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 }
