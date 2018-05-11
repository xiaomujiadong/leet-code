package com.saint.easy.string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。

 示例：

 输入：s = "hello"
 返回："olleh"
 */
public class ReverseString {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            ++left;
            --right;
        }

        return new String(chars);
    }

    public static void main(String[] args){
        String str = "abcd";

        System.out.println("result: "+reverseString(str));
    }
}

