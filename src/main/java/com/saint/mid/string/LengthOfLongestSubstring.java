package com.saint.mid.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例：

 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<String, Integer> tempMap = new HashMap<String, Integer>();

        int max = 0;
        int start = 0;
        for(int i=0; i<chars.length; i++){
            String key = chars[i]+"";
            if(tempMap.containsKey(key)){
                int index = tempMap.get(key);

                if(index>=start){
                    start = index+1;
                }
            }

            int temp = i - start + 1;
            if(temp>max){
                max = temp;
            }

            tempMap.put(chars[i]+"", i);
        }

        return max;
    }

    public int better(String s){
        int start = 0;
        String max = "";
        String current = "";
        int pos;
        for(int i = 0;i<s.length();i++){
            if(current.indexOf(s.charAt(i)) != -1){
                if(current.length() >= max.length()){
                    max = current;
                }
                pos = current.indexOf(s.charAt(i));
                current = s.substring(start + current.indexOf(s.charAt(i))+1, i+1);
                start = start + pos + 1;
            }else{
                current = current + s.charAt(i);
            }
        }
        return max.length() > current.length()? max.length() : current.length();
    }

    public int best(String s){
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for(int i=0;i<list.length;i++){
            list[i]=-1;
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if(list[(int)c] > previous)
                previous = list[(int)c];
            max_len = Math.max(max_len, right - previous);
            list[(int)c] = right++;
        }
        return max_len;
    }

    public static void main(String[] args){
        String str = "aaaba";

        System.out.println("result: "+lengthOfLongestSubstring(str));
    }
}
