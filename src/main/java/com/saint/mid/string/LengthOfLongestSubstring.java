package com.saint.mid.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        Map<String, Integer> tempMap = new HashMap<String, Integer>();

        int max = 0;
        int start = 0;
        char last = ' ';
        for(int i=0; i<chars.length; i++){
            if(tempMap.containsKey(chars[i]+"") || i == chars.length-1){
                int temp = i - start ;
                System.out.println("temp: "+temp+", start: "+start+", i： "+i+", c: "+chars[i]);
                if(!tempMap.containsKey(chars[i]+"")){
                    temp = temp+1;
                }

                if(temp>max){
                    max = temp;
                }
                if(i != chars.length-1){
                    start = tempMap.get(chars[i]+"");
                    if(last != ' ' && last!=chars[i]){
                        start = start+1;
                    }

                }
                last = chars[i];
            }else{
                last = ' ';
            }
            tempMap.put(chars[i]+"", i);
        }
        return max;
    }

    public static void main(String[] args){
        String str = "bbbb";

        System.out.println("result: "+lengthOfLongestSubstring(str));
    }
}
