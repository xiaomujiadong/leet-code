package com.saint.mid.string;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

 若可行，输出任意可行的结果。若不可行，返回空字符串。

 示例 1:

 输入: S = "aab"
 输出: "aba"
 示例 2:

 输入: S = "aaab"
 输出: ""
 注意:

 S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReorganizeString {
    public static String reorganizeString(String S) {

        char[] chars = S.toCharArray();
        Map<String, Integer> map = new HashMap<String, Integer>();
        char mostKey = ' ';
        int mostNum = 0;


        for(char c:chars){
            String key = c+"";
            int value = 1;
            if(map.containsKey(key)){
                value = map.get(key);
            }

            if(value>mostNum){
                mostKey = c;
                mostNum = value;
            }
            map.put(key, value);
        }

        int temp = S.length() - mostNum;
        if(mostNum-temp>1){
            return "";
        }

        char[] newCh = new char[S.length()];

        int pos = 0;
        for(int i=0; i<mostNum;i++){
            newCh[pos] = mostKey;
            pos = pos + 2;
        }

        int posOld = 0;
        int posNew = 1;

        for(;posNew<newCh.length;){
            //老循环等于最多的ke直接跳过
            if(chars[posOld] == mostKey){
                ++posOld;
                continue;
            }
            if(newCh[posOld] == mostKey){
                ++posNew;
                continue;
            }
//            newCh[]

        }


//        for(int i=0; )

        return "";
    }

    public static void main(String[] args){
//        String str = "vvvlo";
//        System.out.println("result: "+reorganizeString(str));

        char[] c = new char[1];
        System.out.println(c[0]=='\u0000');
    }

}
