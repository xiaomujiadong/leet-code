package com.saint.easy.string;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 示例 1:

 输入: "USA"
 输出: True
 示例 2:

 输入: "FlaG"
 输出: False
 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 */
public class DetectCapitalUse {
    public static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();

        int length = word.length();
        int count = 0;
        boolean isBig = false;
        for(int i=0; i<length; i++){
            char c = chars[i];

            if('A' <= c && c <= 'Z') {
                if(i == 0){
                    isBig = true;
                    continue;
                }
                ++count;
            }
        }

        if(isBig){
            if( (count >= length-1 || count == 0 )){
                return true;
            }
            return false;
        }else if(count == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String word = "wsadF";
        System.out.println("result: "+detectCapitalUse(word));
    }
}
