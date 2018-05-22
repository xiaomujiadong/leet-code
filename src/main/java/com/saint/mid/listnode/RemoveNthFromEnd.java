package com.saint.mid.listnode;

import com.saint.other.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            ++i;
        }
        i = i-n;
        if(i == 0){
            head = head.next;
            return head;
        }

        temp = head;
        while(i>1 && temp!=null){
            temp = temp.next;
            --i;
        }
        if(temp!=null && temp.next != null && temp.next.next!=null){
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
        return head;
    }

    public static ListNode best(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;

        for (ListNode node = head; node != null; node = node.next, n--)
            ;

        if (n > 0)
            // n 大于链表的总长度
            return head;
        if (n == 0)
            return head.next;

        for (ListNode node = head; node != null; node = node.next) {
            n++;
            if (n == 0) {
                node.next = node.next.next;
                return head;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(6);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(2);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(1);
        listNode6.next = listNode7;

//        System.out.println("result: "+isPalindrome(listNode1));

        System.out.println("result: "+removeNthFromEnd(listNode1, 1));
    }
}
