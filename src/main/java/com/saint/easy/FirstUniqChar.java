package com.saint.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        int[] map = new int[26];
        for(char i:chars){
            ++map[i-'a'];
        }
        for(int i=0; i<chars.length; i++){
            if(map[chars[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        String str = "dddccdbba";
        System.out.println("result: "+firstUniqChar(str));
    }
}
