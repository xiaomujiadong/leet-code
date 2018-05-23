package com.saint.mid.listnode;

import com.saint.other.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 示例 2:

 输入: 0->1->2->NULL, k = 4
 输出: 2->0->1->NULL
 解释:
 向右旋转 1 步: 2->0->1->NULL
 向右旋转 2 步: 1->2->0->NULL
 向右旋转 3 步: 0->1->2->NULL
 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return head;
        }

        ListNode start = head;

        int len = 0;
        while(head!=null){
            if(head.next == null){
                head.next = start;
                break;
            }
            ++len;
            head = head.next;
        }

        int times = 1;
        int loop = len * times-k;

        while(loop<0){
            times = times +1;
            loop = len * times - k;
        }

        if(loop == 0){
            head.next = null;
            return start;
        }

        while(loop!=0){
            start = start.next;
            --loop;
        }
        ListNode newList = start.next;
        start.next = null;

        return newList;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(9);
//        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        int k = 4;
        System.out.println("result: "+rotateRight(listNode1, k));
    }
}
