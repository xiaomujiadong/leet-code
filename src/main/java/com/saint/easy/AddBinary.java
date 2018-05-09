package com.saint.easy;

public class AddBinary {
    public static String addBinary(String a, String b) {
        char[] aA = a.toCharArray();
        char[] bA = b.toCharArray();

        int aI = aA.length-1;
        int bI = b.length() - 1;

        int sum = 0;
        String result = "";
        while(aI>=0||bI>=0){
            if(aI>=0){
                sum += Integer.valueOf(aA[aI]+"");
                aI--;
            }
            if(bI>=0){
                sum += Integer.valueOf(bA[bI]+"");
                bI--;
            }
            if(sum==2){
                result = "0"+result;
                sum = 1;
            }else if(sum ==0 || sum == 1){
                result = sum+result;
                sum = 0;
            }else if(sum==3){
                result = "1"+result;
                sum = 1;
            }
        }
        if(sum==1){
            result = "1"+result;
        }
        return result;
    }

    public static void main(String[] args){
        String a = "11";
        String b = "10";

        System.out.println("result: "+addBinary(a, b));
    }
}
