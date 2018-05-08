package com.saint.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        if(strs.length == 0){
            return "";
        }
        String shortStr = strs[0];
        for(int i=1;i<strs.length; i++){
            if(shortStr.length()>strs[i].length()){
                shortStr = strs[i];
            }
        }

        for(int i=shortStr.length(); i>0; i--){
            shortStr = shortStr.substring(0, i);
            boolean flag = true;
            for(String str : strs){
                String temp = str.substring(0, shortStr.length());
                if(!shortStr.equals(temp)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return shortStr;
            }
        }
        return "";
    }

    public static void main(String[] args){
        String[] strs = new String[]{"dog", "dd", "dddd"};
        System.out.println("result: "+longestCommonPrefix(strs));
    }
}
