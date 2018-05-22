package com.saint.easy.sort;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] sc = new int[256];
        int[] tc = new int[256];

        for(int i=0;i<s.length();i++){
            ++sc[s.charAt(i)];
            ++tc[t.charAt(i)];
        }

        for(int i=0;i<256;i++){
            if(sc[i] != tc[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println("result: "+isAnagram(s, t));
    }
}
