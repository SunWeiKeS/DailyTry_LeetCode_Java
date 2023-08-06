package BackUp.graduated.P03_Array;

import java.util.Stack;

public class P0326_155MinStack {
    /** initialize your data structure here. */
    Stack <Integer>stack;
    Stack <Integer>min_stack;
    public P0326_155MinStack() {
        stack= new Stack<>();
        min_stack= new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty()||val<=min_stack.peek())
            min_stack.push(val);

    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min_stack.peek();
    }
}
