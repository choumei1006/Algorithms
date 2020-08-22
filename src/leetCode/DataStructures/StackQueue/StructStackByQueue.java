package leetCode.DataStructures.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/8/15 0:18
 * @Description:
 */
public class StructStackByQueue {
    private Queue<Integer> queue;

    //构造函数
    public StructStackByQueue(){
        queue = new LinkedList<>();
    }

    //入栈
    public void push(int x){
        queue.offer(x);
    }

    //出栈
    public int pop(){
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    //top
    public int top(){
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        int tmp = queue.peek();
        queue.add(tmp);
        return tmp;
    }

    //判空
    public boolean isEmpty(){
        return null == queue.peek() ? true : false;
    }

}
