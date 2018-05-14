package com.saint.easy.string;

public class JudgeCircle {
    public static boolean judgeCircle(String moves) {
        int lc = 0;
        int rc = 0;
        int uc = 0;
        int dc = 0;
        char[] c = moves.toCharArray();

        for(char tc:c){
            if(tc == 'L'){
                ++lc;
            }else if(tc == 'R'){
                ++rc;
            }else if(tc == 'U'){
                ++uc;
            }else if(tc == 'D'){
                ++dc;
            }
        }

        if(lc != rc || uc != dc){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String moves = "UDD";

        System.out.println("result: "+judgeCircle(moves));
    }
}
