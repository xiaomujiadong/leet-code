package com.saint.easy.string;

/**
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 举个例子，A = "abcd"，B = "cdabcdab"。
 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 注意:
 A 与 B 字符串的长度在1和10000区间范围内。
 */
public class RepeatedStringMatch {
    public static int repeatedStringMatch(String A, String B) {
        int aLength = A.length();
        int bLength = B.length();
        int result = -1;
        if (A.contains(B))
            return 1;
        char[] bArray = B.toCharArray();
        for (int i = 0; i < bArray.length; i++) {
            if (!A.contains(String.valueOf(bArray[i]))) {
                return -1;
            }
        }
        StringBuffer aBuffer = new StringBuffer(A);
        int count = 1;
        while (aLength < bLength * 2) {
            aBuffer.append(A);
            aLength = aBuffer.length();
            count++;
            if (aBuffer.toString().contains(B)) {
                result = count;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String a = "abcd";
        String b = "cdabcdab";

        System.out.println("result: "+repeatedStringMatch(a, b));
    }
}
