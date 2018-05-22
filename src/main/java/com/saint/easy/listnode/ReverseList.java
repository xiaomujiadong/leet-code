package com.saint.easy.listnode;

import com.saint.other.ListNode;

import java.util.List;

/**
 * Created by wdcao on 2018/5/22.
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {

        ListNode root = new ListNode(0);

        ListNode nextNode;
        while (head != null) {
            //把第二个节点存储
            nextNode = head.next;
            //第二节点的next指向root.next
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }

        return root.next;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

//        System.out.println("result: "+reverseList(listNode1));

        System.out.println("result: "+reverseList2(listNode1));
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode listNode = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = listNode;
            listNode = head;
            head = temp;
        }
        return listNode;
    }
}
