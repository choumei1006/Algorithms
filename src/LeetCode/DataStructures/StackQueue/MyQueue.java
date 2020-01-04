package LeetCode.DataStructures.StackQueue;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/1/4 11:26
 * @Description:
 * **
 *  * Your MyQueue object will be instantiated and called as such:
 *  * MyQueue obj = new MyQueue();
 *  * obj.push(x);
 *  * int param_2 = obj.pop();
 *  * int param_3 = obj.peek();
 *  * boolean param_4 = obj.empty();
 *  *
 */
class MyQueue {

    //利用两个栈实现队列先进先出功能
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    /**
     * 更新out栈；
     */
    private void in2out(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }
}

