package com.saint.mid.array;

import com.saint.other.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(end-start>=3){
            int otherTarget = target - nums[start] - nums[end];

            int otherStart = start+1;
            int otherEnd = end-1;
            while(otherStart<end){
                if(nums[otherStart]+nums[otherEnd]==otherTarget){
                    List<Integer> templist = new ArrayList<Integer>();
                    templist.add(nums[start]);
                    templist.add(nums[otherStart]);
                    templist.add(nums[otherEnd]);
                    templist.add(nums[end]);

                    result.add(templist);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {};
        int target = 0;

        for(List<Integer> list:fourSum(nums, target)){
            System.out.print("[");
            for(int i:list){
                System.out.print(i+",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
