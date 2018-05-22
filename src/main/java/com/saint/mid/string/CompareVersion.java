package com.saint.mid.string;

/**
 * 比较两个版本号 version1 和 version2。
 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

 你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

 示例 1:

 输入: version1 = "0.1", version2 = "1.1"
 输出: -1
 示例 2:

 输入: version1 = "1.0.1", version2 = "1"
 输出: 1
 示例 3:

 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 输出: -1
 */
public class CompareVersion {

    public static int other(String version1, String version2){
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int v1 = 0;
        int v2 = 0;
        while(v1<str1.length || v2<str2.length){
            int i1 = 0;
            if(v1<str1.length){
                i1 = Integer.valueOf(str1[v1]);
            }
            int i2 = 0;
            if(v2<str2.length){
                i2 = Integer.valueOf(str2[v2]);
            }

            if(i1>i2){
                return 1;
            }else if(i1<i2){
                return -1;
            }
            ++v1;
            ++v2;
        }
        return 0;
    }

    public static int better(String version1, String version2) {
        int temp1 = 0,temp2 = 0;
        int len1 = version1.length(),len2 = version2.length();
        int i = 0,j = 0;
        while(i<len1 || j<len2) {
            temp1 = 0;
            temp2 = 0;
            while(i<len1 && version1.charAt(i) != '.') {
                temp1 = temp1*10 + version1.charAt(i++)-'0';

            }
            while(j<len2 && version2.charAt(j) != '.') {
                temp2 = temp2*10 + version2.charAt(j++)-'0';

            }
            if(temp1>temp2) return 1;
            else if(temp1<temp2) return -1;
            else {
                i++;
                j++;

            }

        }
        return 0;
    }

    public static void main(String[] args){
        String v1 = "1.2";
        String v2 = "1.10";

        System.out.println("result: "+other(v1, v2));
    }
}
