package Demo.Queue;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/2/5 22:33
 * @Description: 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char k = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("s(show):输出队列元素；");
            System.out.println("a(add):数据入队；");
            System.out.println("g(get):对头元素出队；");
            System.out.println("p(peek):获取队头元素；");
            System.out.println("e(exit):退出程序；");

            k = scanner.next().charAt(0);
            switch (k){
                case 's':
                    try {
                        arrayQueue.listQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入要入队的元素：");
                    int num = scanner.nextInt();
                    arrayQueue.addQueue(num);
                    System.out.printf("元素'%d'入队成功！\n",num);
                    break;
                case 'g':
                    try{
                        System.out.printf("出队元素：%d\n",arrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try{
                        System.out.printf("队头元素：%d\n",arrayQueue.peek());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序~~");
    }
}

class ArrayQueue{
    private int maxSize;   //队列最大容量
    private int front;     //队列头
    private int rear;      //队列尾
    private int[] arr;     //队列数据数组，模拟队列

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;   //指向队列头部，front总是指向队列头元素的前一个位置
        rear = -1;     //指向队列尾部，rear总是指向队列中的尾元素
    }

    /**
     * 判断是否队满
     */
    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 判断是否队空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 元素入队
     * @param num
     */
    public void addQueue(int num){
        //判断是否队满
        if(isFull()){
            System.out.println("队列已满，不能再添加数据！");
            return ;
        }
        rear++;
        arr[rear] = num;
    }

    /**
     * 元素出队
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        front++;
        return arr[front];
    }

    /**
     * 获取队头元素
     * @return
     */
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[front+1];
    }

    /**
     * 输出队列所有元素
     */
    public void listQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

}

