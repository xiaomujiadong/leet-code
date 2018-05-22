package com.saint.easy.listnode;

import com.saint.other.ListNode;

public class DeleteNode {
    public static void deleteNode(ListNode node) {
        while (node!=null && node.next != null){
            node = node.next;
        }
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
        deleteNode(listNode3);
        System.out.println("result: "+listNode1);
    }
}
