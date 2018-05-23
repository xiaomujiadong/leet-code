package com.saint.mid.listnode;

import com.saint.other.ListNode;

import java.util.List;

/**
 *
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {

        // Write your code here
        if(head == null || head.next == null)
            return head;

        ListNode stHead = new ListNode(0);  //防止链断开设置的节点
        stHead.next = head;//放在头结点之前，头结点是首先要交换的两个节点的前一个节点
        ListNode res = stHead;//用于最后返回结果 因为stHead会改变
        while(stHead.next != null && stHead.next.next != null){
            ListNode first = stHead.next;  //要交换节点1
            ListNode second = stHead.next.next;  //要交换节点2

            first.next = second.next;
            second.next = first;
            stHead.next = second;

            stHead = stHead.next.next;
        }

        return res.next;  //！返回的写法很重要
    }

    public static ListNode swapPairs2(ListNode head) {

        ListNode index = new ListNode(0);
        index.next = head;

        ListNode result = index;

        while(index.next!=null&&index.next.next!=null){
            ListNode first = index.next;
            ListNode second = index.next.next;

            first.next = second.next;
            second.next = first;
            index.next = second;

            index = index.next.next;
        }
        return result.next;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(9);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        System.out.println("result: "+swapPairs2(listNode1));
    }
}
