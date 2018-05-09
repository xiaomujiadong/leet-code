package com.saint.easy;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int count = 0;
        for(int i:digits){
            if(i==9){
                count += 1;
            }
        }
        int[] newA = digits;
        boolean flag = false;
        if(count == digits.length){
            newA = new int[digits.length+1];
            newA[0]=1;
            flag = true;
        }

        for(int i=digits.length-1;i>=0;i--){
            if((digits[i]+1)!=10){
                if(flag){
                    newA[i+1] = digits[i]+1;
                }else{
                    newA[i] = digits[i]+1;
                }
                break;
            }else{
                if(flag){
                    newA[i+1] = 0;
                }else{
                    newA[i] = 0;
                }
            }
        }
        return newA;
    }

    public static void main(String[] args){
        int[] digits = new int[]{8, 9,9, 9};
        int[] newA = plusOne(digits);
        System.out.println("length: "+newA.length);
        for(int i:newA){
            System.out.print(i+", ");
        }

    }
}
