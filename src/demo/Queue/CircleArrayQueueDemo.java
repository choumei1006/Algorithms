package demo.Queue;

import java.security.spec.ECField;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/2/6 21:18
 * @Description: 数组模拟循环队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //创建数组模拟的循环队列
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char k = ' ';
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("s(show):输出队列元素；");
            System.out.println("a(add):元素入队；");
            System.out.println("g(get):元素出队；");
            System.out.println("p(peek):获取队头元素；");
            System.out.println("c(cnt):获取队列元素个数；");
            System.out.println("e(exit):退出程序；");
            k = scanner.next().charAt(0);
            switch (k){
                case 's':
                    try {
                        circleArrayQueue.listQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    if(circleArrayQueue.isFull()){
                        System.out.println("队列已满！");
                    }else {
                        System.out.println("请输入要入队的元素：");
                        int tempNum = scanner.nextInt();
                        circleArrayQueue.addQueue(tempNum);
                    }
                    break;
                case 'g':
                    try {
                        System.out.printf("元素%d出队成功！\n", circleArrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        System.out.printf("队头元素：%d\n", circleArrayQueue.peek());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    System.out.printf("队列元素个数：%d\n",circleArrayQueue.cntQueue());
                    break;
                case 'e':
                    scanner.close();
                    flag  = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序~~");
    }
}
class CircleArrayQueue{
    private int maxSize;   //数组最大长度
    private int front;     //队头
    private int rear;      //队尾
    private int[] arr;     //数组，模拟循环队列

    /**
     * 构造器
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队满
     * @return
     */
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    /**
     * 判断队空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 元素入队
     * @param num
     */
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }

        arr[rear] = num;
        rear = (rear+1)%maxSize;
        System.out.printf("元素%d入队成功！\n",num);
    }

    /**
     * 元素出队
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能出队！");
        }
        int temp = arr[front];
        front++;
        return temp;
    }

    /**
     * 输出队列元素
     */
    public void listQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        for (int i = front; i < front+cntQueue() ; i++) {
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    /**
     * 获取元素个数
     * @return
     */
    public int cntQueue(){
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 获取队头元素
     * @return
     */
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }
}
