package com.saint.easy.listnode;

import com.saint.other.ListNode;

public class Partition {

    public static ListNode partition(ListNode head, int x) {
        ListNode one = new ListNode(0);
        ListNode oneTemp = one;
        ListNode two = new ListNode(0);
        ListNode twoTemp = two;

        while(head!=null){
            if(head.val<x){
                oneTemp.next = head;
                oneTemp = head;
            }else{
                twoTemp.next = head;
                twoTemp = head;
            }
            head = head.next;
        }

        oneTemp.next = null;
        twoTemp.next = null;

        oneTemp.next = two.next;

        return one.next;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(2);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(2);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
//        listNode6.next = listNode7;

        int val = 3;

        System.out.println("result: "+partition(listNode1, val));
    }

}
