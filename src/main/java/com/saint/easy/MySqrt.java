package com.saint.easy;

public class MySqrt {
    public static int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 1, right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if(sqrt == mid) return mid;
            else if(sqrt < mid) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }

    public static void main(String[] args){
        int x = 2147395599;
        System.out.println("result: "+mySqrt(x));
    }
}
