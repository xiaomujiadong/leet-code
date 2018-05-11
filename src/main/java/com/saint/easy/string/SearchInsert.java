package com.saint.easy.string;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;
        int mid = nums.length/2+left;

        boolean flag = false;
        while(left<=right){
            if(nums[mid] ==target){
                flag = true;
                break;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
            mid = (right-left)/2 +left;
        }

        if(flag){
            return mid;
        }else{
            return left;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1};
        int target = 0;

        System.out.println("result: "+searchInsert(nums, target));
    }
}
