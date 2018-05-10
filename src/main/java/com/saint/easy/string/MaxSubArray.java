package com.saint.easy.string;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = 0, thisSum = 0;;
        int maxLesZero = 0;
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {

            if(nums[i]<0){
                if(maxLesZero == 0){
                    maxLesZero = nums[i];
                }else if(maxLesZero < nums[i]){
                    maxLesZero = nums[i];
                }
            }

            thisSum += nums[i];

            if(thisSum >= maxSum) {
                flag = true;
                maxSum = thisSum;
            }else if(thisSum < 0)
                thisSum = 0;
        }

        if(!flag){
            return maxLesZero;
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-1, 0};
        System.out.println("result: "+maxSubArray(nums));
    }
}
