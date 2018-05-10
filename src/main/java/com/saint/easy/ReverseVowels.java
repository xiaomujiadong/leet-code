package com.saint.easy;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1：
 给定 s = "hello", 返回 "holle".

 示例 2：
 给定 s = "leetcode", 返回 "leotcede".

 注意:
 元音字母不包括 "y".
 */
public class ReverseVowels {
    public static String ReverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while(left<=right){

            char lc = chars[left];
            char rc = chars[right];

            if( !isVowel(lc) ){
                ++left;
                continue;
            }
            if( !isVowel(rc) ){
                --right;
                continue;
            }

            chars[left] = rc;
            chars[right] = lc;

            ++left;
            --right;
        }

        return new String(chars);
    }

    public static boolean isVowel(char lc){
        return lc == 'a' || lc == 'e' || lc =='i' || lc =='o' || lc =='u' || lc == 'A' || lc == 'E' || lc =='I' || lc =='O' || lc =='U';
    }

    public static void main(String[] args){
        String str = "aA";

        System.out.println("result: "+ReverseVowels(str));
    }
}
