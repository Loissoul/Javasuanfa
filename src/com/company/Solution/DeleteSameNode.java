package com.company.Solution;

public class DeleteSameNode {

//    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//    示例 1:
//
//    输入: 1->2->3->3->4->4->5
//    输出: 1->2->5
//    示例 2:
//
//    输入: 1->1->1->2->3
//    输出: 2->3



    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode lastTail = null;
        ListNode newHead = null;

        while (p != null) {
            ListNode lastSame = findLastSameNode(p);
            if (p == lastSame) {
                //没有重复的
                if (newHead == null) {
                    newHead = p;
                }

                if (lastTail == null) {
                    lastTail = p;

                } else {
                    lastTail.next = p;
                    lastTail = p;
                }
                p = p.next;
            } else {
                if(lastTail != null) {
                    lastTail.next = lastSame.next;
                }
                p = lastSame.next;
            }

        }

        return newHead;

    }



    //获取整个重复的最后一个node
    public ListNode findLastSameNode(ListNode node) {
        int val = node.val;
        ListNode p = node.next;
        ListNode pPr = node;
        while (p != null) {
            int tmp = p.val;
            if (val == tmp) {
                pPr = p;
                p = p.next;
            } else {
                break;
            }
        }
        return pPr;
    }

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //
    //示例 1:
    //
    //输入: 1->1->2
    //输出: 1->2
    //示例 2:
    //
    //输入: 1->1->2->3->3
    //输出: 1->2->3

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }



}
















