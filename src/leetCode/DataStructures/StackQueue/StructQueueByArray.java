package leetCode.DataStructures.StackQueue;

/**
 * @author:choumei
 * @date:2020/8/14 19:39
 * @Description:
 */
public class StructQueueByArray {

    private int maxSize;

    private int[] arr;

    private int front;    //��һ��Ԫ��λ��

    private int rear;    //��һ��Ԫ����һ��λ��

    //���캯��
    public StructQueueByArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty(){
        return front == rear;
    }

    //�ж��Ƿ����
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //���
    public void push(int x){
        if(isFull()){
            System.out.println("�������������ʧ�ܣ�");
            return;
        }

        arr[rear] = x;
        rear = (rear + 1) % maxSize;
    }

    //����
    public int pop(){
        if(isEmpty()){
            new RuntimeException("����Ϊ�գ�����ʧ�ܣ�");
        }
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }

    //��ȡ����Ԫ��
    public int peek(){
        if(isEmpty()){
            new RuntimeException("����Ϊ�գ�����ʧ�ܣ�");
        }
        return arr[front];
    }

    //��ӡ����Ԫ��
    public void print(){
        if(isEmpty()){
            new RuntimeException("����Ϊ�գ�");
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d",i,arr[i]);
        }
    }

    //��Ч���ݳ���
    public int size(){
        if(isEmpty()){
            return 0;
        }
        return (rear - front + maxSize) % maxSize;
    }
}
