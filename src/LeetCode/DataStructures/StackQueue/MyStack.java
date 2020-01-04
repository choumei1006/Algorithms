package LeetCode.DataStructures.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/1/4 14:42
 * @Description:
 *  * Your MyStack object will be instantiated and called as such:
 *  * MyStack obj = new MyStack();
 *  * obj.push(x);
 *  * int param_2 = obj.pop();
 *  * int param_3 = obj.top();
 *  * boolean param_4 = obj.empty();
 *  *
 *  做法：利用一个队列实现：每当一个元素入栈，将这个元素先入队，随后，将这个元素之前入队的所有元素顺次出队并入队，
 *  保证最后入队的元素永远在队列头部；
 */
public class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size-- > 1){
            queue.add(queue.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

