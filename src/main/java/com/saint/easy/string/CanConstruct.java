package com.saint.easy.string;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

 (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

 注意：

 你可以假设两个字符串均只含有小写字母。

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.equals(magazine) || ransomNote.equals("")){
            return true;
        }

        char[] rc = ransomNote.toCharArray();
        char[] mc = magazine.toCharArray();

        int ri = 0;
        int mi = 0;

        while((mi+1)<magazine.length() ){

            if(rc[ri] != mc[mi]){
                mi = mi - ri +1;
                ri = 0;
            }else{
                if((ri+1)==ransomNote.length()){
                    return true;
                }
                ++ri;
                ++mi;
            }
        }

        return false;
    }

    public static  void main(String[] args){
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.println("result: "+canConstruct(ransomNote, magazine));
    }
}
