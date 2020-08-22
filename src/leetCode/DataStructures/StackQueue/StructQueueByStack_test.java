package leetCode.DataStructures.StackQueue;

/**
 * @author:choumei
 * @date:2020/8/14 19:36
 * @Description:
 */
public class StructQueueByStack_test {
    public static void main(String[] args) {
        StructQueueByStack queue = new StructQueueByStack();
        System.out.println(queue.isEmpty());
        queue.push(1);
        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
