package com.saint.easy.string;

import static java.lang.Math.max;

/**
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。

 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。

 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。

 示例 :

 输入: "aba", "cdc"
 输出: 3
 解析: 最长特殊序列可为 "aba" (或 "cdc")
 说明:

 两个字符串长度均小于100。
 字符串中的字符仅含有 'a'~'z'。
 */
public class FindLUSlength {
    public static int findLUSlength(String a, String b) {
        int s1=a.length(),s2=b.length();
        if(s1!=s2){
            if(s1>s2){
                return s1;
            }else{
                return s2;
            }
        }
        else if(a!=b)
            return s1;
        else
            return -1;
    }

    public static void main(String[] args){
        String str = "test";
        String b = "aaa";
        System.out.println();
    }
}
