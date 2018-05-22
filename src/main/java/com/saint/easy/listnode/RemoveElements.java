package com.saint.easy.listnode;

import com.saint.other.ListNode;

/**
 * Created by wdcao on 2018/5/22.
 */
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode lastNode = head;

        ListNode now = head;
        while(now!=null){
            if(now.val == val){
                if(now == head){
                    head = head.next;
                }else{
                    lastNode.next = now.next;
                }
            }else{
                lastNode = now;
            }
            now = now.next;
        }

        return head;
    }

    public static ListNode best(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null){
            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;

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

        int val = 6;

        System.out.println("result: "+removeElements(listNode1, val));
    }

}
