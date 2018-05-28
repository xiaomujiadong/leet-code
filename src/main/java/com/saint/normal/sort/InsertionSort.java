package com.saint.normal.sort;

import static com.saint.normal.sort.BubbleSort.bubbleSort1;
import static com.saint.normal.sort.BubbleSort.bubbleSortBest;
import static com.saint.normal.sort.BubbleSort.printArray;

public class InsertionSort {

    public static int[] insertionSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int j=i;
            while(j>0 && nums[j]<nums[j-1]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
            System.out.print("第 "+i+" 次排序： ");
            printArray(nums);
            System.out.println();
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {33, 22, 44, 22, 4, 1, 11, 10, 6, 5, 22, 13, 0};
        insertionSort(nums);
    }
}
