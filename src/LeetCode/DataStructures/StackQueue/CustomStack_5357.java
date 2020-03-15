package LeetCode.DataStructures.StackQueue;

/**
 * @author:choumei
 * @date:2020/3/15 11:59
 * @Description:
 */
public class CustomStack_5357 {
    public static void main(String[] args) {
        CustomStack obj = new CustomStack(3);
        obj.push(4);
        obj.increment(3,100);
        System.out.println(obj.pop());
        obj.increment(3,100);
    }
}
