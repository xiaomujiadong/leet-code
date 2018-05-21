package com.saint.mid.sort;

import com.saint.other.ListNode;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {

        ListNode index = head.next;
        //新的头部
        ListNode newList = new ListNode(head.val);
        while(index!=null){
            ListNode indexT = newList;
            ListNode last = null;
            ListNode temp = index.next;
            while(indexT!=null){
                if(index.val<indexT.val){
                    if(last == null){
                        index.next = indexT;
                        newList = index;
                    }else{
                        last.next = index;
                        index.next = indexT;
                    }

                    break;
                }else{
                    last = indexT;
                    indexT = indexT.next;
                }
            }
            index = temp;

        }
        return newList;
    }

    ListNode sorted = new ListNode(0);
    ListNode left = null;
    ListNode right = null;
    public ListNode best(ListNode head) {
        if(head == null){
            return head;
        }
        left = head;
        right = head;
        sorted.next = left;

        ListNode cur = head.next;
        head.next = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = null;
            insert(sorted,cur);
            cur = next;
        }
        return sorted.next;
    }
    private void insert(ListNode head , ListNode cur){
        if(cur.val <= left.val){
            sorted.next = cur;
            cur.next = left;
            left = cur;
            return;
        }
        else if(cur.val>=right.val){
            right.next = cur;
            right = cur;
            cur.next = null;
            return;
        }
        ListNode node = head.next;
        while(node.next!=null){
            if(cur.val>=node.val&&cur.val<=node.next.val){
                ListNode temp = node.next;
                node.next = cur;
                cur.next = temp;
                break;
            }
            node = node.next;
        }
    }

    /**
     * 链表插入排序
     * */
    public ListNode other(ListNode head) {
        //边界条件判断
        if(head==null || head.next == null)
            return head;

        //创造一个新的链表头部
        ListNode pre = new ListNode(-1);
        //用一个临时变量保存头节点
        ListNode ans = pre;
        //cur是原链表上的指针
        ListNode cur = head;
        while (cur != null) {
            //每次循环前重置pre为头结点，这样保证每次都从头往后遍历
            pre = ans;

            //当pre.next.val大于cur.val时停止循环
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            //pre.next.val 大于 cur.val，此时应该把cur插入到pre后
            //保存原链表当前节点的下一节点
            ListNode tmp = cur.next;
            //把cur插入到pre之后
            cur.next = pre.next;
            pre.next = cur;

            //cur指针后移一位
            cur = tmp;
        }
        return ans.next;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;

        System.out.println("result: "+insertionSortList(listNode1));
    }
}