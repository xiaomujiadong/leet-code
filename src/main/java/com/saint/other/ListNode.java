package com.saint.other;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public String toString(){
        if(next==null){
            return val+"->";
        }else{
            return val+"->"+next.toString();
        }
    }
}
