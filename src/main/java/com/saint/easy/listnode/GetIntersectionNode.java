package com.saint.easy.listnode;

import com.saint.other.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 */

public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode left = headA;
        ListNode right = headB;
        while (left!=null && right!=null){
            if(left==right){
                return left;
            }else if(left.next == right){
                return right;
            }else if(right.next == left){
                return left;
            }else{
                left = left.next;
                right = right.next;
            }
        }
        return null;
    }

    public static ListNode violent(ListNode headA, ListNode headB) {
        ListNode left = headA;

        while (left!=null ){
            ListNode right = headB;
            while(right!=null){
                if(left == right){
                    return left;
                }else{
                    right = right.next;
                }
            }
            left = left.next;

        }
        return null;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        listNode11.next = listNode22;
        listNode22.next = listNode3;
        listNode3.next = listNode4;

        System.out.println("result: "+getIntersectionNode(listNode1, listNode11));
    }
}
