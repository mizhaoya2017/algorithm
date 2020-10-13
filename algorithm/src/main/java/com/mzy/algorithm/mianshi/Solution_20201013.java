package com.mzy.algorithm.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：mizhaoya
 * @date ：2020/10/13 16:52
 * @description：
 */
public class Solution_20201013 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        for (int i = 0; i < len-1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nums[i] + nums[j] == target) {
                    res = new int[]{i, j};
                    return res;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head =null; ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1==null?0:l1.val;
            int l2val = l2==null?0:l2.val;
            int num = l1val + l2val + carry;
            if (head == null) {
                head = tail = new ListNode(num % 10);
            } else {
                tail.next = new ListNode(num % 10);
                tail = tail.next;
            }
            carry = num / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
////        int target = 9;
////        int[] res = twoSum(nums, target);
////        for (int i = 0;i < res.length; i ++) {
////            System.out.println(res[i]);
////        }

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode res = addTwoNumbers(l1, l2);
//        System.out.print(res);

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode res = addTwoNumbers(l1, l2);
        System.out.print(res);
    }
}
