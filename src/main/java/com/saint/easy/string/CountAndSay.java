package com.saint.easy.string;

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n ，输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。

 示例 1:

 输入: 1
 输出: "1"
 示例 2:

 输入: 4
 输出: "1211"
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        int result = 1;
        String str = "";
        if (n == 0) return str;
        if (n == 1) return str + result;
        if (n == 2) return str + result + result;
        if (n == 3) return "21";
        str = "21";

        String tempresult = "";
        int sum = 1;  //计数君
        for (int i = 3; i < n; i++) {
            for (int j = 0; j < str.length(); j++) {
                // 在遍历到末尾前，当前的数与后一个数相等
                if (j != str.length() - 1 && str.charAt(j) == str.charAt(j+1)) {
                    sum++;  // 相邻且相同的数计数+1
                    continue;
                    // 若遍历到末尾，未位数与前一个数相等
                }else if (j == str.length() - 1 && str.charAt(j) == str.charAt(j-1)){
                    tempresult += sum + String.valueOf(str.charAt(j));
                    sum = 1;    // 已完成报数，计数君重置为0
                }else {
                    tempresult += sum + String.valueOf(str.charAt(j));
                    sum = 1;    // 已完成报数，计数君重置为0
                }
            }
            str = tempresult;
            tempresult = "";

        }
        System.out.println("str:" + str);
        return str;
    }

    public static void main(String[] args){
        System.out.println("result: "+countAndSay(6));
    }
}
