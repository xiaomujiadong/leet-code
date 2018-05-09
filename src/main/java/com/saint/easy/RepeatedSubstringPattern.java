package com.saint.easy;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        String temp = "";
        for(int i=0; i<s.length()/2; i++){
            if(s.length()%(i+1) == 0){

                for(; start<i;start++){
                    temp += chars[start];
                }
                String sss = "";
                for(int j=0; j<=s.length()/(i+1);j++){
                    sss += temp;
                }
                System.out.println("temp: "+temp+", sss: "+ sss);
                if(sss.equals(s)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean test(String s){
        if(s==null||s.length()==0)
            return false;
        int len = s.length();
        char[] ch = s.toCharArray();
        int j = 0;
        int[] arr = new int[len];
        for(int i = 1;i < len;){
            if(ch[i]==ch[j]){
                arr[i] = j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j = arr[j-1];
                }else{
                    i++;
                }
            }
        }
        int p = arr[len-1];
        if( p > 0 && len%(len-p)==0)
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "abab";
        System.out.println("result: "+repeatedSubstringPattern(s));
    }

}
