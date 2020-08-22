package leetCode.DataStructures.StackQueue;

/**
 * @author:choumei
 * @date:2020/8/14 19:39
 * @Description:
 */
public class StructQueueByArray {

    private int maxSize;

    private int[] arr;

    private int front;    //第一个元素位置

    private int rear;    //第一个元素下一个位置

    //构造函数
    public StructQueueByArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //判断是否队满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //入队
    public void push(int x){
        if(isFull()){
            System.out.println("队列已满，入队失败！");
            return;
        }

        arr[rear] = x;
        rear = (rear + 1) % maxSize;
    }

    //出队
    public int pop(){
        if(isEmpty()){
            new RuntimeException("队列为空，出队失败！");
        }
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }

    //获取队首元素
    public int peek(){
        if(isEmpty()){
            new RuntimeException("队列为空，出队失败！");
        }
        return arr[front];
    }

    //打印队列元素
    public void print(){
        if(isEmpty()){
            new RuntimeException("队列为空！");
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d",i,arr[i]);
        }
    }

    //有效数据长度
    public int size(){
        if(isEmpty()){
            return 0;
        }
        return (rear - front + maxSize) % maxSize;
    }
}
