package com.saint.mid.sort;

import com.saint.other.Interval;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()<1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval interva1, Interval interva2) {
                return interva1.start-interva2.start;
            }
        });

        Interval interval = intervals.get(0);
        List<Interval> newList = new ArrayList<Interval>();
        boolean flag = false;
        for(Interval temp:intervals){
            if(temp.start>interval.end){
               newList.add(interval);
               interval = temp;
            }else{
                if(temp.end > interval.end){
                    interval.end = temp.end;
                }
            }
        }

        newList.add(interval);
        return newList;
    }

    public static List<Interval> best(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;

    }

    public static void main(String[] args){
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(9, 18);

        List<Interval> list = new ArrayList<Interval>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);

        for(Interval interval:merge(list)){
            System.out.println(interval);
        }
    }
}
