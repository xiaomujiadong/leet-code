package com.saint.easy.listnode;

import com.saint.other.ListNode;

/**
 * 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while(head!=null){
            builder.append(head.val);
            head = head.next;
        }

        String str = builder.toString();
        int left = 0;
        int right = str.length()-1;

        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            ++len;
            temp = temp.next;
        }

        int count = len/2;
        if(len%2 != 0){
            count = count+1;
        }

        ListNode oneList = null;

        ListNode tempList;
        while(head!=null && count!=0){

            tempList = head.next;
            head.next = oneList;
            oneList = head;
            head = tempList;
            count = count -1;
        }

        if(len%2!=0){
            oneList = oneList.next;
        }

        System.out.println("oneList: "+oneList);
        System.out.println("twoList: "+head);

        while(oneList!=null && head!=null){
            if(oneList.val != head.val){
                return false;
            }
            oneList = oneList.next;
            head = head.next;
        }

        return true;
    }

    public boolean best(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.val == head.next.val && head.next.next == null)
            return true;
        //到这时，链表的长度为3
        ListNode slow = head;
        ListNode cur = head.next;
        while(cur.next != null){
            if(cur.next.val == slow.val){
                if(cur.next.next != null)
                    return false;
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val)
                    return true;
            }else{
                cur = cur.next;
            }
        }
        return false;

    }


    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(6);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(1);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(1);
        listNode6.next = listNode7;

//        System.out.println("result: "+isPalindrome(listNode1));

        System.out.println("result: "+isPalindrome2(listNode1));
    }
}
