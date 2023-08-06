package backup.graduated.P06_String;

import java.util.HashMap;

public class P50_firstUniqChar {
    //数组法要确定index的具体位置
    //hashMap要判断是否已经包含该元素
    public char firstUniqChar1(String s) {
        //数组法
        char[]array=s.toCharArray();
        int[]count=new int[26];
        for (char c : array) {
            count[c-'a']++;
        }
        for (char c : array) {
            if (count[c-'a']==1)
                return c;
        }

        return ' ';
    }

    public char firstUniqChar(String s) {
        //hashMap
        HashMap<Character, Boolean> map = new HashMap<>();
        char[]array=s.toCharArray();
        for (char c : array) {
            map.put(c,!map.containsKey(c));//如果没有就是true，如果有就是false
        }
        for (char c : array) {
            if(map.get(c))//是true，说明仅包含一个
                return c;
        }

        return ' ';
    }
}
