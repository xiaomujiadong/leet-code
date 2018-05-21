package com.saint.easy.listnode;

import com.saint.other.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode index = head;

        while(index.next!=null){
            if(index.val == index.next.val){
                index.next = index.next.next;
            }else{
                index = index.next;
            }
        }

        return head;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;

        System.out.println("result: "+deleteDuplicates(listNode1));
    }
}
