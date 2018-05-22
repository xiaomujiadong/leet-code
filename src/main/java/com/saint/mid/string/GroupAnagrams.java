package com.saint.mid.string;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。

 解题思路
 1.新建，Map<String,List<String>>

 2.遍历字符串数组里的每个字符串

 把每个字符串---》字符数组，并对其进行排序

 排序后的字符数组--》字符串，作为key，去查找并添加进Map<String,List<String>>

 3.最后，输出Map<String,List<String>> 里的所有的value
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str:strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("result: "+groupAnagrams(strs));
    }
}
