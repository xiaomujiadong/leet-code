package com.saint.easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

 示例 1:

 输入: "abab"

 输出: True

 解释: 可由子字符串 "ab" 重复两次构成。
 示例 2:

 输入: "aba"

 输出: False
 示例 3:

 输入: "abcabcabcabc"

 输出: True

 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */

public class RepeatedSubstringPattern {
    //TODO 在复习复习
    public static boolean repeatedSubstringPattern(String s){
        if(s==null||s.length()==0)
            return false;
        int len = s.length();
        char[] ch = s.toCharArray();
        int j = 0;
        int[] arr = new int[len];
        for(int i = 1;i < len;){
            if(ch[i]==ch[j]){
                arr[i] = j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j = arr[j-1];
                }else{
                    i++;
                }
            }
        }
        int p = arr[len-1];
        if( p > 0 && len%(len-p)==0)
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "abab";
        System.out.println("result: "+repeatedSubstringPattern(s));
    }

}
