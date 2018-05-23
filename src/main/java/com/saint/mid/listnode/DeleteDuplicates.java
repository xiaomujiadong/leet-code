package com.saint.mid.listnode;

import com.saint.other.ListNode;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newList = null;
        ListNode first = null;

        boolean isDel = false;
        while (head!=null && head.next!=null){
            if(head.val == head.next.val){
                if(first!=null){
                    first.next = head.next;
                }
                head = head.next;
                isDel = true;
            }else{
                //找到头结点
                if(newList == null){
                    if(isDel){
                        newList = head.next;
                    }else{
                        newList = head;
                    }
                    isDel = false;
                }

                if(first != null){
                    if(isDel){
                        first.next = head.next;
                    }else{
                        first.next = head;
                    }
                }

                first = head;
                head = head.next;
            }
        }
        return newList;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(0);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(0);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
//        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        int k = 4;
        System.out.println("result: "+deleteDuplicates(listNode1));
    }
}
