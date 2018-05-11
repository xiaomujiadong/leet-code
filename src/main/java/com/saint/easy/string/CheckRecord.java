package com.saint.easy.string;

public class CheckRecord {
    public static boolean checkRecord(String s) {

        int a = 0;
        int l = 0;

        for(int i=0; i<s.length(); i++){
            char h = s.charAt(i);
            if( h  == 'A'){
                ++a;
                if(a>1){
                    return false;
                }
            }else if(h=='L'){
                ++l;
                if(l>2){
                    return false;
                }
                continue;
            }
            l = 0;
        }
        return true;
    }


    public static void main(String[] args){
        String s = "PPALLP";
        System.out.println("result: "+checkRecord(s));
    }
}
