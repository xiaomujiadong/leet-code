package com.saint.mid.string;

import java.util.*;

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
        Map<String, HelpRecorganized> map = new HashMap<String, HelpRecorganized>();
        int max = 0;
        for(int i=0; i<S.length(); i++){
            String key = S.charAt(i)+"";

            HelpRecorganized helpRecorganized = map.get(key);
            if(helpRecorganized == null){
                helpRecorganized = new HelpRecorganized(S.charAt(i));
            }

            helpRecorganized.count += 1;

            if(helpRecorganized.count>max){
                max = helpRecorganized.count;
            }

            map.put(key, helpRecorganized);
        }

        int last = S.length() - max;
        if(max-last>1){
            return "";
        }

        List<HelpRecorganized> list = new ArrayList<HelpRecorganized>();
        for(String key:map.keySet()){
            list.add(map.get(key));
        }

        Collections.sort(list,new Comparator<HelpRecorganized>() {
            @Override
            public int compare(HelpRecorganized o1, HelpRecorganized o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                return o2.count-o1.count;
            }
        });
        char[] chars = new char[S.length()];

        for(int i=0;i<chars.length;i++){
            chars[i] = ' ';
        }

        int start = 0;
        for(HelpRecorganized helpRecorganized : list){
            System.out.println("key: "+helpRecorganized.key+", count: "+helpRecorganized.count);
            for(int i=0; i<helpRecorganized.count;i++){
                chars[start] = helpRecorganized.key;
                start = start + 2;
                if(start > S.length()-1){
                    start = 1;
                }
            }
        }

        return new String(chars);
    }

    public static String best(String S){
        int[] data = new int[26];
        int max = 0;
        int maxi = -1;
        for(char c : S.toCharArray()){
            data[c-'a']++;
            if(data[c-'a']>max){
                max=data[c-'a'];
                maxi=c-'a';
            }
            if(max>(1+S.length())/2) return "";
        }
        char[] res = new char[S.length()];
        int index = 0;
        for(int i=0;i<max;i++){
            res[index] = (char)(maxi+'a');
            index+=2;
        }
        data[maxi]=0;
        for(int i=0;i<26;i++){
            int count = data[i];
            for(int j=0;j<count;j++){
                if(index>=S.length()) index=1;
                res[index]=(char)(i+'a');
                index+=2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args){
        String str = "aaab";
        System.out.println("result: "+reorganizeString(str));

    }

}
class HelpRecorganized{
    int count;
    char key;

    public HelpRecorganized(char c){
        this.key = c;
        this.count = 0;
    }
}

