package Exam.Tencent;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/26 20:43
 * @Description:
 */
public class QueueByStack_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //N
        sc.nextLine();

        List<Integer> res = new ArrayList<>();
        MyQueue queue = new MyQueue();


        for (int j = 0; j < N; j++) {
            String optMsg = sc.nextLine();
            String[] msgs = optMsg.split("\\s+");
            String option = msgs[0];
            int num = 0;
            if(msgs.length > 1 && option.equals("add")){
                num = Integer.valueOf(msgs[1]);
            }

            switch (option){
                case "add":
                    queue.push(num);
                    break;
                case "poll":
                    if(!queue.empty()){
                        queue.pop();
                    }
                    break;
                case "peek":
                    if(!queue.empty()){
                        res.add(queue.peek());
                    }
                    break;
                default:
                    break;
            }
        }
        for(int r : res){
            System.out.println(r);
        }
    }
}
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
