package com.saint.search;

public class BinarySearch {

    public static int search(int[] nums, int val){
        int start = 0;
        int end = nums.length-1;

        while(start<end ){
            int mid = (start+end)/2;

            if(val>nums[mid]){
                start = mid;
            }else if(val < nums[mid]){
                end = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int val = -2;
        System.out.println("result: "+search(nums, val));
    }

}
