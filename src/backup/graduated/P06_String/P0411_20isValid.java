package BackUp.graduated.P06_String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author:vic
 * @Date:21-4-11
 * @Content:
 */
public class P0411_20isValid {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2==1) return false;

        /**
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，
         * 判断字符串是否有效。
         */
        //我们使用一个栈结果来存储比较，如果没有找到对应的则退出
        Deque<Character>stack=new LinkedList<Character>();

        //用来保存存储的键值对
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < n; i++) {
            char tmp=s.charAt(i);//获得当前的字符
            if (map.containsKey(tmp)){//这个时候说明是右边的，即map中的键
                if(stack.isEmpty()||stack.peek()!=map.get(tmp)){
                    return false;//stack中取出的应该和此时的是一对
                }
                stack.pop();
            }else {//这个时候说明是左边的，即map中的值
                //加入
                stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }

}
