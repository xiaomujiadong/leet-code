package com.saint.normal.sort;

/**
 * 冒泡排序：将最小的数，放在第一位，外层循环第一次选出的是最小值
 */
public class BubbleSort {
    public static int[] bubbleSort1(int[] nums){
        int count = 0;
        for(int i=0;i<nums.length ;i++){
            boolean flag = true;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
                ++count;
            }
            if (flag) {
                break;
            }
            System.out.print("第 "+i+" 次排序： ");
            printArray(nums);
            System.out.println();
        }
        System.out.println("count: "+count);
        return nums;
    }

    public static void bubbleSortBest(int [] A){
        boolean flag = true;
        int count = 0;
        for(int i=0; i<A.length && flag;i++){
            flag = false;
            for(int j=A.length-1;j>i;j--){
                if(A[j-1] > A[j]){
                    int temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                    flag = true;
                }
                ++count;
            }
            System.out.print("第 "+i+" 次排序： ");
            printArray(A);
            System.out.println();
        }
        System.out.println("count: "+count);
    }

    public static void main(String[] args){
        int[] nums = {33, 22, 44, 22, 4, 1, 11, 10, 6, 5, 22, 13, 0};
        bubbleSort1(nums);
        int[] numsA = {33, 22, 44, 22, 4, 1, 11, 10, 6, 5, 22, 13, 0};
        bubbleSortBest(numsA);
    }

    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i:nums){
            System.out.print(i+", ");
        }
        System.out.print("]");
    }
}
