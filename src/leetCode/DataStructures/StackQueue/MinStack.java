package leetCode.DataStructures.StackQueue;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/1/5 20:16
 * @Description:
 *  * Your MinStack object will be instantiated and called as such:
 *  * MinStack obj = new MinStack();
 *  * obj.push(x);
 *  * obj.pop();
 *  * int param_3 = obj.top();
 *  * int param_4 = obj.getMin();
 *
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min,x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


