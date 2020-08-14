package leetCode.DataStructures.StackQueue;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/3/15 11:58
 * @Description:
 */
class CustomStack {
    Stack<Integer> stack ;
    int maxSize;
    int[] increase;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize;
        increase = new int[maxSize];
    }

    public void push(int x) {
        if(stack.size() < maxSize){
            stack.push(x);
        }
    }

    public int pop() {
        int temp = increase[stack.size()-1];
        return stack.pop()+ temp;
    }

    public void increment(int k, int val) {
        for(int i = 0;i < stack.size() && i < k;i++){
            increase[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
