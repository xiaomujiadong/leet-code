package com.saint.mid.string;

public class MyAtoi {
    public static int myAtoi(String str) {
        int start = 0;
        int end = 0;
        boolean flag = false;
        boolean isZ = true;
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);

            if(!flag){
                if(c == '+' || c=='-' || ('0'<=c && c<='9')){
                    start = i;
                    flag = true;
                }else if(c == ' '){
                    continue;
                }else{
                    break;
                }
            }else{
                if(!('0'<=c && c<='9')){
                    end=i;
                    break;
                }else if(i==str.length()-1){
                    end = i+1;
                }
            }
        }
        if(end<=start){
            return 0;
        }
        String newStr = str.substring(start, end);

        if(newStr.equals("-") || newStr.equals("+")){
            return 0;
        }

        char first = newStr.charAt(0);

        if (first == '-') {
            String minV = Integer.MIN_VALUE+"";
            if(newStr.length()>minV.length()){
                return 0;
            }else if(newStr.length()==minV.length()){
                for(int i=1;i<newStr.length();i++){
                    if(newStr.charAt(i) > minV.charAt(i)){
                        return 0;
                    }
                }
            }

            return Integer.valueOf(newStr);
        }

        if(first == '+'){
            if (newStr.length() == 1) {
                return 0;
            }
            newStr = newStr.substring(1, newStr.length());
        }

        String maxV = Integer.MAX_VALUE+"";
        if(newStr.length()>maxV.length()){
            return 0;
        }else if(newStr.length() == maxV.length()){
            for(int i=1;i<newStr.length();i++){
                if(newStr.charAt(i) > maxV.charAt(i)){
                    return 0;
                }
            }
        }


        System.out.println("test: "+str.substring(start, end));

        return Integer.valueOf(newStr);
    }

    public static void main(String[] args){
        String str = "words and 987";
        System.out.println("result: "+myAtoi(str));
    }
}
