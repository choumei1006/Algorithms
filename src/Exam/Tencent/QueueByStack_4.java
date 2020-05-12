package Exam.Tencent;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/26 20:43
 * @Description: 用两个栈实现队列，支持队列的基本操作：
 *
 * 输入描述:
 * 第一行输入一个整数N，表示对队列进行的操作总数。
 * 下面N行每行输入一个字符串S，表示操作的种类。
 * 如果S为“add”,则后面还有一个整数X表示向队列尾部加入整数X；
 * 如果S为“poll”,则表示弹出队列头部操作；
 * 如果S为“peek”,则表示询问当前队列中头部元素是多少。
 *
 * 数据保证没有不合法的操作：
 *
 * 输出描述：
 * 对于每一个为“peek”的操作，输出一行表示当前队列中头部元素是多少。
 *
 * 示例1：
 *
 * 输入：
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 *
 * 输出：
 * 1
 * 2
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
