package com.saint.easy.string;

import java.util.Stack;

public class KuoHaoVaild {
    public static boolean isValid(String s){
        if(s == null || s.equals("")){
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(char c : chars){
            if(c == '{' || c=='[' || c=='('){
                stack.push(c);
            }else if(stack.isEmpty()){
                return false;
            }else if(c == ')' && stack.pop()!='('){
                return false;
            }else if(c == ']' && stack.pop()!='['){
                return false;
            }else if(c == '}' && stack.pop()!='{'){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = "{[()]}()";
        System.out.println("resultr: "+isValid(s));
    }
}
