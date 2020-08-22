package leetCode.DataStructures.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/8/14 19:21
 * @Description: 用栈模拟实现队列
 */
public class StructQueueByStack {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /**
     * 构造函数
     */
    public StructQueueByStack(){
    }

    /**
     * 入队
     * @param x
     */
    public void push(int x){
        in.push(x);
    }

    /**
     * 出队
     * @return
     */
    public int pop(){
        in2out();
        return out.pop();
    }

    /**
     * 返回队列头元素
     * @return
     */
    public int peek(){
       in2out();
       return out.peek();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    /**
     * 移动辅助
     */
    public void in2out(){
        if(out.isEmpty()){
           while(!in.isEmpty()){
               out.push(in.pop());
           }
        }
    }

}
