package BackUp.graduated.P06_String;

import java.util.HashMap;
import java.util.Map;

public class P0312_3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        //找到最长无重复字串
        Map<Character,Integer > map = new HashMap<>();
        int left_point=0;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
          if(map.containsKey(s.charAt(i))){//如果这个map包含了这个值
              //map.get(s.charAt(i))+ 获得i对应的值在map中的下标+1为移动指针的位置
              left_point=Math.max(left_point,map.get(s.charAt(i))+1 );
          }
            map.put(s.charAt(i),i);
            max=Math.max(max, i-left_point+1);//当前的指针减去左指针+1，即现在的长度
        }
        return max;
    }
}
