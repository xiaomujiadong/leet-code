package com.saint.easy.listnode;

import com.saint.other.ListNode;

/**
 * 判断2个给定链表相交的点
 *
 * 思路：
 *      先分别统计2个链表的长度，
 *      因为相交，所以是尾部对齐
 *      所以先把长的链表多余的长度去掉，
 *
 *      然后剩下的长度，进行同时比较
 *
 */

public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lena = 0;
        int lenb = 0;

        ListNode tempa = headA;
        while(tempa!=null){
            ++lena;
            tempa = tempa.next;
        }

        ListNode tempb = headB;
        while(tempb!=null){
            ++lenb;
            tempb = tempb.next;
        }

        tempa = headA;
        tempb = headB;
        if(lena>lenb){
            while(lena!=lenb){
                tempa = tempa.next;
                --lena;
            }
        }else if(lena < lenb){
            while(lena!=lenb){
                tempb = tempb.next;
                --lenb;
            }
        }

        while(tempa!=null && tempb!=null){
            if(tempa==tempb){
                return tempa;
            }
            tempa = tempa.next;
            tempb = tempb.next;
        }

        return null;
    }


    //暴力破解
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
