package com.saint.easy.string;

/**
 * 给定一个非空字符串s，您最多可以删除一个字符。判断你是否能把它变成一串“回文”。
 */
public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();

        int left = 0;
        int right = cs.length-1;
        while(left <right){
            if(cs[left] == cs[right]) {
                ++left;
                --right;
            }else{
                int templ = left+1;
                int tempr = right;
                while (templ<tempr){
                    if(cs[templ] == cs[tempr]) {
                        ++templ;
                        --tempr;
                    }else{
                        break;
                    }
                }
                if(templ>=tempr){
                    return true;
                }
                templ = left;
                tempr = right - 1;

                while (templ<tempr){
                    if(cs[templ] == cs[tempr]) {
                        ++templ;
                        --tempr;
                    }else{
                        return false;
                    }
                }

                return true;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        System.out.println("result: "+validPalindrome(str));

        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        char[] c = s.toCharArray();
        char[] ne = new char[s.length()];
        for(int i=0; i<c.length;i++){
            ne[c.length-1-i] = c[i];
        }
        System.out.println("new: "+new String(ne));
    }

}
