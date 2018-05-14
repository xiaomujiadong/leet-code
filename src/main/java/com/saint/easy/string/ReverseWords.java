package com.saint.easy.string;

import java.util.List;
import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<String>();

        StringBuilder result = new StringBuilder();
        for(char c:chars){
            if(c == ' '){
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append(" ");
                continue;
            }

            stack.push(c+"");
        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static String better(String s){
        char[] chars = s.toCharArray();

        int start = 0;
        int end = 0;
        for(int i=0;i<chars.length; i++){
            if(chars[i] == ' ' || i==chars.length-1){
                System.out.println("start: "+start+", end: "+(i-1));
                if(chars[i]==' '){
                    end = i-1;
                }
                change(start, end, chars);
                start = i+1;
            }
        }
        return new String(chars);
    }

    private static void change(int start, int end, char[] chars){
        while(start<end){
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            ++start;
            --end;
        }
    }

    public static void main(String[] args){
        String s = "let test tesa dsfasdf afas afa ewra fasdf awerfa lkjoj nnljo adfasd adfoasdif vxzvj ojanfaoil nzvnlm";
        long ss = System.currentTimeMillis();
        System.out.println("result: "+reverseWords(s)+", time: "+(System.currentTimeMillis()-ss));
        long st = System.currentTimeMillis();
        System.out.println("result: "+better(s)+", time: "+(System.currentTimeMillis()-st));
    }
}
