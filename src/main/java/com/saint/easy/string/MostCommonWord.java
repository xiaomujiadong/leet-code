package com.saint.easy.string;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String str : banned){
            map.put(str.toLowerCase(), 0);
        }

        char[] ch = paragraph.toCharArray();
        StringBuilder builder = new StringBuilder();
        int max = 0;
        String result = "";
        boolean flag = false;
        for(int i=0; i<ch.length;i++){
            char tc = ch[i];
            if('a'<=tc && tc<='z' || 'A'<=tc && tc<='Z'){
                builder.append((tc+"").toLowerCase());
                flag = false;
                if(i!=ch.length-1){
                    continue;
                }
            }

            if(flag){
                continue;
            }
            flag = true;
            String key = builder.toString().toLowerCase();
            System.out.println("key: "+key);
            builder.delete(0, key.length());
            Integer value = map.get(key);
            if(value == null){
                value = 1;
            }else if(value==0){
                continue;
            }else{
                value = value+1;
            }
            map.put(key, value);
            if(value>=max){
                max = value;
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String par = "Bob. hIt, baLl";
        String[] baned = new String[]{"bob","hit"};

        System.out.println("result: "+mostCommonWord(par, baned));
    }
}
