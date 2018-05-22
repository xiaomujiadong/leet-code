package com.saint.mid.string;

public class CustomSortString {
    public static String customSortString(String S, String T) {
        int[] newChar = new int[256];

        for(int i=0; i<T.length(); i++){
            ++newChar[T.charAt(i)];
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            int temp = newChar[c];
            for(int j=0; j<temp;j++){
                builder.append(c);
                --newChar[c];
            }
        }
        char tes = 'd';

        for(int i=0; i<newChar.length;i++){
            int temp = newChar[i];
            if(temp!=0){
                char c = (char)i;
                for(int j=0; j<temp;j++){
                    builder.append(c);
                    --newChar[c];
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args){
        String s = "cba";
        String t = "abcd";
        System.out.println("result: "+customSortString(s, t));
    }
}
