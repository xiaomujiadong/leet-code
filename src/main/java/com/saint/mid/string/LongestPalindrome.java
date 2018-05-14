package com.saint.mid.string;

/**
 * 题目描述
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 分析

 回文字符串分为两种
 第一种：abccba
 第二种：abcacba
 */
public class LongestPalindrome {
    private static int lo;
    private static int maxLen;

    public static String longestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        char[] chars = s.toCharArray();

        for(int i=0; i<s.length()-1; i++){
            //第二种
            palindrome(chars, i, i);
            //第一种
            palindrome(chars, i, i+1);
        }
        System.out.println("lo: "+lo+", maxLen: "+maxLen);
        return s.substring(lo, maxLen+lo+1);
    }

    private static void palindrome(char[] chars, int startLeft, int startRight){
        System.out.println("lo: "+lo+", left: "+startLeft+", right: "+startRight);
        while (true){
            if(startLeft<0 || startRight>(chars.length-1) || chars[startLeft] != chars[startRight]){
                ++startLeft;
                --startRight;
                break;
            }
            --startLeft;
            ++startRight;
        }

        if(maxLen < (startRight-startLeft)){
            maxLen = startRight-startLeft;
            lo = startLeft;
        }
    }



    public static void main(String[] args){
        String str = "aab";

        System.out.println("result: "+longestPalindrome(str));

        System.out.println("suc".substring(0, 2));
    }
}
