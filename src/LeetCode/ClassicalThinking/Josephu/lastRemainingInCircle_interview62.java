package LeetCode.ClassicalThinking.Josephu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/3/30 16:01
 * @Description: 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 */
public class lastRemainingInCircle_interview62 {
    @Test
    public void test(){
        System.out.println(lastRemaining1(6,3));
    }

    /**
     * 方法一：使用ArrayList解决；
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while(n > 1){
            idx = (idx+m-1)%n;  //-1是因为当前位置0已经占据一位
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 方法二：数学+递归
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m){
        return helper(n,m);
    }
    public int helper(int n, int m){
        if(n == 1){
            return 0;
        }
        int idx = helper(n-1,m);
        return (idx+m)%n;
    }
}
