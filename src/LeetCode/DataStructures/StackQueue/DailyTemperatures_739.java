package LeetCode.DataStructures.StackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/1/5 21:15
 * @Description: 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 */
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailtTemperatures(temperatures)));
    }

    /**
     * 返回数组中每个元素离下一个“大哥”的距离 组成的数组；
     * @param T
     * @return
     */
    public static int[] dailtTemperatures(int[] T){
        int len = T.length;
        Stack<Integer> index = new Stack<>();
        int[] distance = new int[len];
        for (int curIdx = 0; curIdx < len; curIdx++) {
            while(!index.isEmpty() && T[curIdx] > T[index.peek()]){
                int preIdx = index.pop();
                distance[preIdx] = curIdx - preIdx;
            }
            index.push(curIdx);
        }
        return distance;
    }
}
