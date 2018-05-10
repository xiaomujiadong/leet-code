package com.saint.easy.string;

import java.util.*;

/**
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class TwoSum {
    public static void twoSum(int[] nums, int target) {
        System.out.println("twoSumFirst:");
        twoSumFirst(nums, target);
        System.out.println("twoSumSecond:");
        twoSumSecond(nums, target);
        System.out.println("twoSumThird:");
        twoSumThird(nums, target);
    }

    /**
     * 时间复杂度为O(n^2)
     * @param nums
     * @param target
     */
    public static void twoSumFirst(int[] nums, int target){
        for(int ii=0;ii<nums.length;ii++){
            int i = nums[ii];
            int j = target - i;
            for(int ji = ii; ji<nums.length-1; ji++){
                int t = nums[ji];
                if(j == t){
                    System.out.println("第一个数为： "+i +", 第二个数为： "+j);
                    continue;
                }
            }
        }
    }

    /**
     * 时间复杂度为O(nlogn)
     * @param nums
     * @param target
     */
    public static void twoSumSecond(int[] nums, int target){
        Arrays.sort(nums);
        int li = 0;
        int ri = nums.length-1;

        while (li<ri){
            int result = nums[li] + nums[ri];
            if( result == target){
                System.out.println("第一个数为： "+ nums[li] +", 第二个数为： "+nums[ri]);
                break;
            }else if(result > target){
                --ri;
            }else{
                ++li;
            }
        }
    }

    /**
     * 空间换时间，最终时间复杂度为O(n)
     * @param nums
     * @param target
     */
    public static void twoSumThird(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        System.out.println(nums.length);
        for(int i=0;i<nums.length;i++){
            System.out.println("i: "+i);
            map.put(nums[i], i);
        }
        System.out.println(map);
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int j=0;j<nums.length-1;j++){
            int otherTar = target - nums[j];
            if(map.containsKey(otherTar) && target != 2*nums[j] && !resultSet.contains(nums[j])){
                resultSet.add(nums[j]);
                resultSet.add(otherTar);
//                return new int[]{j, map.get(otherTar)};
                System.out.println("第一个数索引： "+j +", 第二个数索引： "+map.get(otherTar));
            }
        }
    }

    public static void main(String[] args){
        int[] enmus = new int[]{3, 2, 4};
        int target = 6;

//        twoSum(enmus, target);

        twoSumThird(enmus, target);
    }
}
