package com.saint.mid.listnode;

import com.saint.other.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newList = new ListNode(0);
        ListNode nowNode = newList;
        int temp = 0;
        while(l1!=null && l2!=null){
            int val = l1.val + l2.val + temp;
            if(val>9){
                temp = 1;
                val = val%10;
            }else{
                temp = 0;
            }
            nowNode.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            nowNode = nowNode.next;
        }

        while (l1!=null){
            int val = l1.val +temp;
            if(val>9){
                temp = 1;
                val = val%10;
            }else{
                temp = 0;
            }
            nowNode.next = new ListNode(val);
            l1 = l1.next;
            nowNode = nowNode.next;
        }

        while (l2!=null){
            int val = l2.val +temp;
            if(val>9){
                temp = 1;
                val = val%10;
            }else{
                temp = 0;
            }
            nowNode.next = new ListNode(val);
            l2 = l2.next;
            nowNode = nowNode.next;
        }

        if(temp!=0){
            nowNode.next = new ListNode(temp);
        }

        return newList.next;
    }

    public ListNode best(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum/10;
        ListNode result = new ListNode(sum%10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode cache = result;
        while (l1 != null || l2 != null || carry > 0) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            cache.next = new ListNode(sum%10);
            carry = sum/10;
            cache = cache.next;
            if (l1 !=null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(9);
        listNode3.next = listNode4;

        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        System.out.println("result: "+addTwoNumbers(listNode1, listNode5));
    }
}
