package exam.QiAnXin.Autumn;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author:choumei
 * @date:2020/9/2 15:59
 * @Description:
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //台阶数n
        int cnt = 0;
        if(n >= 1 || n <= 36){
            cnt = climbHelper(n);
        }
        System.out.println(cnt);
    }

    /**
     * 计算爬n个台阶的方案数
     *
     * @return
     */
    public static int climbHelper(int n) {
        //特判
        /*if (n < 0 || n > 36) {
            return 0;
        }*/

        //1、用Vector保存爬n个台阶的方案数
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);

        //2、dp
        if(n <= 2){
            return vector.get(n - 1);
        }
        for (int i = 2; i < n; i++) {
            vector.add(vector.get(i - 1) + vector.get(i - 2));     //F(n) = F(n - 1) + F(n - 2);
        }
        return vector.get(n - 1);
    }
}
