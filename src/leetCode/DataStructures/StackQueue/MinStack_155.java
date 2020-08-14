package leetCode.DataStructures.StackQueue;

/**
 * @author:choumei
 * @date:2020/1/4 15:00
 * @Description: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack_155 {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(2);
        ms.push(5);
        ms.push(1);
        ms.push(9);
        ms.push(0);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());

    }
}
