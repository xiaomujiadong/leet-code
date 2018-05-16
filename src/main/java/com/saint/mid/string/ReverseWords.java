package com.saint.mid.string;

public class ReverseWords {

    public static String reverseWords(String s) {
        int length = 0;

        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                ++length;
            }else{
                if(length != 0){
                    flag = true;

                }
            }
            if(i == 0 && length!=0){
                flag = true;
                i = i-1;
            }

            if(flag){
                for(int j=i+1; j<i+1+length;j++){
                    builder.append(s.charAt(j));
                }
                length = 0;
                builder.append(" ");
                flag = false;
            }
        }
        String newStr = builder.toString();
        int newLength = 0;
        for(int i=newStr.length()-1;i>=0;i++){
            if(newStr.charAt(i) == ' '){
                newLength = i;
                break;
            }
        }
        if(newLength!=0){
            newStr = newStr.substring(0, newLength);
        }
        return newStr;
    }

    public static void main(String[] args){
        String s = "1 ";
        System.out.println("result: "+reverseWords(s));
    }
}
