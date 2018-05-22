package com.saint.easy.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();

        for(int i:nums1){
            set.add(i);
        }
        Set<Integer> temp = new HashSet<Integer>();
        for(int i:nums2){
            if(set.contains(i)){
                temp.add(i);
            }
        }

        int[] result = new int[temp.size()];
        int j=0;
        for(int i:temp){
            result[j] = i;
            ++j;
        }
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

}
