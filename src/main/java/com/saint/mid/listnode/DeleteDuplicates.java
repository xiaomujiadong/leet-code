package com.saint.mid.listnode;

import com.saint.other.ListNode;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newList = null;
        ListNode first = null;

        boolean isDel = false;
        while (head!=null && head.next!=null){
            if(head.val == head.next.val){
                isDel = true;
            }else{
                if(!isDel){
                    if(first!=null){
                        first.next = head;
                    }
                    first = head;
                    if(newList == null){
                        newList = head;
                    }
                }
                isDel = false;
            }
            head = head.next;
        }
        if(first!=null){
            if(isDel ){
               first.next = null;
            }else{
                first.next = head;
            }
        }
        if(newList==null){
            if(!isDel ){
                newList = head;
            }
        }
        return newList;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
//        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(2);
//        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        int k = 4;
        System.out.println("result: "+deleteDuplicates(null));
    }
}
