package com.saint.easy.string;

public class ReverseStr {
    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        if(k>=s.length()){
            String str = "";
            for(int i=ch.length-1; i>=0; i--){
                str +=ch[i];
            }
            return str;
        }
        char[] newc = new char[ch.length];
        int temp = k;
        int start = 0;
        boolean flag = true;
        for(int i=0; i<ch.length; i++){
            if(flag){
                int ne = k+start-1;
                if(ne>=ch.length){
                    ne = ch.length - 1;
                }

                newc[ne] = ch[i];
                --k;
                if(k==0){
                    start +=temp*2;
                    flag = false;
                }
            }else{
                newc[i] = ch[i];
                ++k;
                if(k==temp){
                    flag=true;
                }
            }
        }
        return new String(newc);

    }

    public static void main(String[] args){
        String romanStr = "abcdefg";
        int i = 3;
        System.out.println("result: "+reverseStr(romanStr, i));
    }
}
