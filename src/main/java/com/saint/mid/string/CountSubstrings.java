package com.saint.mid.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

 示例 1:

 输入: "abc"
 输出: 3
 解释: 三个回文子串: "a", "b", "c".
 示例 2:

 输入: "aaa"
 输出: 6
 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 注意:

 输入的字符串长度不会超过1000。
 */
public class CountSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length();i++){
            int tempCount = palindrome(s, i, i);
            count = count + tempCount;

            tempCount = palindrome(s, i, i+1);

            count = count + tempCount;
        }
        return count;
    }

    private static int palindrome(String str, int startLeft, int startRight){
        int count = 0;
        while(true){
            if(startLeft<0){
                break;
            }
            if(startRight>str.length()-1){
                break;
            }
            if (str.charAt(startLeft) == str.charAt(startRight)) {
                ++startRight;
                --startLeft;
                count = count + 1;
            }else{
                break;
            }
        }

        return count;
    }

    public static void main(String[] args){
        String str = "abab";

        System.out.println("result: "+countSubstrings(str));
    }
}
