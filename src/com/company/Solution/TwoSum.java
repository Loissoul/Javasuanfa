package com.company.Solution;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    //数组
    public int[] towSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] result = {-1, -1};

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return  result;

    }


    //链表相加
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int addNum = 0;
        while (q != null) {
            if (p.next == null && q.next != null) {
                p.next = new ListNode(0);
            }
            if (q.next == null && p.next != null)  {
                q.next = new ListNode(0);
            }

            int sumAll = addNum + p.val + q.val;
            p.val = sumAll % 10;
            addNum = sumAll / 10;

            if (p.next == null && q.next == null && addNum != 0) {
                p.next = new ListNode(addNum);
            }

            p = p.next;
            q = q.next;

        }

        return l1;
    }

    //翻转链表
//  Node reserver(Node node) {
//
//    Node p = node;
//    Node q = null;
//    Node result = null;
//
//    while (p != null) {
//      if (result == null) {
//          result = p;
//      }
//      var temp = p.nextNode;
//
//      p.nextNode = q;
//      q = p;
//      p = temp;
//    }
//
//    return result;
//  }



}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}

}
