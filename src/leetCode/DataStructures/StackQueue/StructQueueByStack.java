package leetCode.DataStructures.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/8/14 19:21
 * @Description: ��ջģ��ʵ�ֶ���
 */
public class StructQueueByStack {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /**
     * ���캯��
     */
    public StructQueueByStack(){
    }

    /**
     * ���
     * @param x
     */
    public void push(int x){
        in.push(x);
    }

    /**
     * ����
     * @return
     */
    public int pop(){
        in2out();
        return out.pop();
    }

    /**
     * ���ض���ͷԪ��
     * @return
     */
    public int peek(){
       in2out();
       return out.peek();
    }

    /**
     * �ж��Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    /**
     * �ƶ�����
     */
    public void in2out(){
        if(out.isEmpty()){
           while(!in.isEmpty()){
               out.push(in.pop());
           }
        }
    }

}
