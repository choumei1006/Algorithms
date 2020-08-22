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

    //���캯��
    public StructStackByQueue(){
        queue = new LinkedList<>();
    }

    //��ջ
    public void push(int x){
        queue.offer(x);
    }

    //��ջ
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

    //�п�
    public boolean isEmpty(){
        return null == queue.peek() ? true : false;
    }

}
