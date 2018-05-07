package com.saint.easy;

import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        ListNode head, currentA, currentB;
        if (a.val < b.val) {
            head = a;
            currentA = a.next;
            currentB = b;
        } else {
            head = b;
            currentB = b.next;
            currentA = a;
        }
        ListNode index = head;

        while (currentA != null && currentB != null) {
            if (currentA.val < currentB.val) {
                index.next = currentA;
                index = currentA;
                currentA = currentA.next;
            } else {
                index.next = currentB;
                index = currentB;
                currentB = currentB.next;
            }
        }
        index.next = (currentA == null) ? currentB : currentA;

        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode resultNode = mergeTwoLists(l1, l4);

        System.out.println(resultNode);
    }

}

class ListNode {
    int val;
    public ListNode next;
    ListNode(int x){
        this.val = x;
    }

    public String toString(){
        if(this.next==null){
            return val+"";
        }else{
            return val+"->"+next.toString();
        }
    }
}