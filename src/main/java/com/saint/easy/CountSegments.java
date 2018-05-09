package com.saint.easy;

public class CountSegments {
    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i)!= ' ' && (i == 0 || (s.charAt(i-1)== ' '))){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String str = "Hello, my name is John";

        int a = 'a';
        int z = 'z';
        System.out.println(a+";"+z);

        System.out.println("result: "+countSegments(str));
    }
}
