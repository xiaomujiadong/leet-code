package com.saint.mid.string;

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
        // 如果只有一行则不需要转换
        if (numRows == 1) return s;

        // 按照行数建立n个字符串用于存放结果
        String [] res = new String[numRows];
        //用二维数组理解是就一行的数据
        for (int i = 0; i < numRows; i ++) res[i] = "";

        // 按照z字形开始往字符串中添加元素
        int countCharNum = 0, q = 0;
        boolean direction = false;
        while (countCharNum < s.length()) {
            res[q] += s.charAt(countCharNum);
            if (q == 0) direction = false;
            if (q == numRows - 1) direction = true;
            q = direction ? q - 1 : q + 1;
            countCharNum++;
        }

        StringBuffer ans = new StringBuffer("");
        for (String i : res) {
            ans.append(i);
        }

        return ans.toString();
    }

    public static String test(String s, int numRows){
        char[] c = s.toCharArray();

        String[] rowStr = new String[numRows];
        for (int i = 0; i < numRows; i ++) rowStr[i] = "";

        int rowIndex = 0;
        boolean nextLen = false;
        for(int i=0; i<c.length; i++){
            rowStr[rowIndex] += c[i];

            if(rowIndex == 0){
                nextLen = false;
            }
            if(rowIndex == numRows-1){
                nextLen = true;
            }

            if(nextLen){
                rowIndex = rowIndex - 1;
            }else{
                rowIndex = rowIndex +1;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String ss : rowStr){
            builder.append(ss);
        }
        return builder.toString();
    }


    public static void main(String[] args){
        String str = "PAYPALISHIRING";
        int rows = 3;
        System.out.println("result: "+convert(str, rows));
    }
}
