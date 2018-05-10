package com.saint.easy.string;

/**
 * Created by wdcao on 2018/5/8.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();

        int index = 0;

        for(int i=0; i<chars.length; i++){
            if(' '==chars[i]){
                index = i;
            }
        }
        if(index==0){
            index=-1;
        }

        return chars.length - index - 1;
    }

    public static void main(String[] args){
        String s = "aaa";

        System.out.println("result: "+lengthOfLastWord(s));
    }
}
