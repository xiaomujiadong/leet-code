package com.saint.easy.sort;

import java.lang.reflect.Array;
import java.util.*;

public class Intersection2 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[nums1.length<nums2.length?nums1.length:nums2.length];

        int i1 = 0;
        int i2 = 0;
        int len = 0;

        while(i1<nums1.length && i2<nums2.length){

            if(nums1[i1] == nums2[i2]){
                result[len] = nums1[i1];
                ++len;
                ++i1;
                ++i2;
            }else if(nums1[i1] <nums2[i2]){
                ++i1;
            }else{
                ++i2;
            }
        }
        result = Arrays.copyOf(result, len);
        return result;
    }
    //先排序，在对比
    public int[] best(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return null;
        }
        int len = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] result = new int[len];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int t = 0;
        while(i < nums1.length && j < nums2.length) {
            while(i+1 < nums1.length && nums1[i] == nums1[i+1])	i++;
            while(j+1 < nums2.length && nums2[j] == nums2[j+1])	j++;
            if(nums1[i] == nums2[j]) {
                result[t++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        result = Arrays.copyOf(result, t);
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {1};
        int[] nums2 = {2};
        System.out.println("result: "+intersection(nums1, nums2));
    }
}
