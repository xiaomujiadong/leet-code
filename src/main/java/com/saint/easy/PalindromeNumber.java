package com.saint.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        int palindrome = 0, temp = x;
        int count = 0;
        while(temp!=0){
            count = count + 1;
            palindrome = palindrome * 10 + temp%10;
            temp /= 10;
        }
        System.out.println(count);
        return palindrome == x;
    }

    public static boolean isPalindrome2(int x) {
        char[] chars = (x+"").toCharArray();

        int li = 0;
        int ri = chars.length-1;
        int count = 0;
        while(li<ri){
            count = count + 1;
            if(chars[li] == chars[ri]){
                ++li;
                --ri;
                continue;
            }
            return false;
        }
        System.out.println(count);
        return true;
    }
    public static void main(String[] args){
        int x = 1758118571;

        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome2(x));

    }
}
