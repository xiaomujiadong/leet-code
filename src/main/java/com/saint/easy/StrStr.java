package com.saint.easy;

public class StrStr {
    public static int strStr(String haystack, String needle) {
        if(needle==null || "".equals(needle)){
            return 0;
        }
        if(needle.length()>haystack.length())
            return -1;


        char[] chars = haystack.toCharArray();
        char[] cA = needle.toCharArray();

        int index = 0;
        int result = 0;
        boolean flag = false;
        for(int i=0; i<(chars.length); i++){
            if(chars[i]==cA[index]) {
                System.out.println("i: "+i+", index: "+index);
                if(index==cA.length-1){
                    result = i+1-index-1;
                    flag = true;
                    break;
                }
                ++index;
                continue;
            }
            if(index!=0){
                i = i-index;
                index = 0;
            }
        }
        if(!flag){
            return -1;
        }
        return result;
    }

    public static int strStr2(String haystack, String needle){
        if(needle==null)
            return 0;
        int place;
        place=haystack.indexOf(needle);
        return place;
    }

    public static void main(String[] args){
        String haystack = "mississippi";
        String needle = "sippi";
        System.out.println("result: "+strStr(haystack, needle));
    }
}
