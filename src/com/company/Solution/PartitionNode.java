package com.company.Solution;


//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//        你应当保留两个分区中每个节点的初始相对位置。
//
//        示例:
//
//        输入: head = 1->4->3->2->5->2, x = 3
//        输出: 1->2->2->4->3->5
//
public class PartitionNode {

    class Solution {
        public ListNode partition(ListNode head, int x) {

            if (head == null) return head;

            ListNode p2_h = null;
            ListNode p1_h = null;

            ListNode p1 = null;
            ListNode p2 = null;
            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    if (p1 == null) {
                        p1_h = p;
                        p1 = p1_h;
                    } else {
                        p1.next = p;
                        p1 = p1.next;
                    }

                } else  {
                    if (p2 == null) {
                        p2_h = p;
                        p2 = p2_h;
                    } else {
                        p2.next = p;
                        p2 = p2.next;
                    }

                }
                p = p.next;
            }


            if (p2_h  == null) {
                return p1_h;
            } else {
                p2.next = null;
            }
            if(p1_h == null)  {
                return p2_h;
            }
            p1.next = p2_h;

            return p1_h;
        }
    }
}
