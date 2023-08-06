package BackUp.graduated.P01_LinkNode;

import java.util.Deque;
import java.util.LinkedList;

public class P09_CQueue {//用两个栈实现队列
}

class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        //初始化一个队列
        stack1 = new LinkedList<Integer>(); //用来存
        stack2 = new LinkedList<Integer>();//用来吐
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {//stack2为空
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }


        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
