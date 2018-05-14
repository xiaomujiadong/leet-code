package com.saint;

/**
 *
 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

 实现一个将字符串进行指定行数变换的函数:

 string convert(string s, int numRows);
 示例 1:

 输入: s = "PAYPALISHIRING", numRows = 3
 输出: "PAHNAPLSIIGYIR"
 示例 2:

 输入: s = "PAYPALISHIRING", numRows = 4
 输出: "PINALSIGYAHRPI"
 解释:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class Convert {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();

        int len = 0;

        int all = 0;

        while(all>=s.length()){

            if(len%2 == 0){
                all += numRows;
            }else{
                all += numRows-2;
            }
            ++len;
        }

        char[][] newChar = new char[len][numRows];

        int row = 0;
        int i = 0;
        int l = 0;
        while(i<chars.length){

            if(row%2==0){
                newChar[row][l] = chars[i];
                ++l;
                if(l>=numRows){

                }
            }else{
                ++row;
            }

            ++i;
        }



    }

    public static void main(String[] args){
        String str = "";
        int rows = 3;
        System.out.println("result: "+convert(str, rows));
    }
}
