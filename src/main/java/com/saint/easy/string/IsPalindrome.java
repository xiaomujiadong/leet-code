package com.saint.easy.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length()<=1){
            return true;
        }

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length-1;
        boolean flag = true;
        while(left <= right){
            char lc = chars[left];
            char rc = chars[right];

            if(!((lc>='a'&& lc<='z') || (lc>='A'&& lc<='Z') || (lc>='0'&& lc<='9'))){
                ++left;
                continue;
            }
            if(!((rc>='a'&& rc<='z') || (rc>='A'&& rc<='Z') || (rc>='0'&& rc<='9'))){
                --right;
                continue;
            }

            if('0'<=lc && lc<='9' || '0'<=rc && rc<='9'){
                if(lc != rc){
                    flag = false;
                    break;
                }
            }

            if(lc==rc || (lc-rc)==32 || (lc-rc)==-32){
                ++left;
                --right;
            }else{
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args){
        String str = "0P";

        System.out.println("result: "+isPalindrome(str));

        int a = '0';
        int A = '9';
        int result = A-a;

        System.out.println("result: "+result);
    }
}
