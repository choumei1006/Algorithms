package exam.Ali;


import java.util.Arrays;
import java.util.Scanner;
/**
 * @author:choumei
 * @date:2020/8/28 18:14
 * @Description:
 *
 *  /** 题目大概是：有几个人，给出每个人的拥有的钱。
 *      现在给出几个要出售的房子，两个变量，一个是价格，一个是舒服程度。求最大舒服度总和的购买方案
 *      要求：一个房子最多只能被一个买
 *      * 多个背包 + 0-1背包
 *      * money        数组：每个背包容量
 *      * a            每个物品的重量
 *      * b            每个物品的价值
 *      * n            背包的总数
 *      * m            物品的总数
 *      *
 *
 *
 *  测试用例：
 *      2 2
     * 2 2
     * 2 2
     * 2 2
     * out：4
 *
 *      5 6
     * 5  3  2  10  7
     * 9 8
     * 9 3
     * 7 6
     * 4 7
     * 1 7
     * 8 1
 */
public class Bag_0_1 {

        static boolean[] visited;
        static int[][][] dp;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] money = new int[n];
            for (int i = 0; i < n; i++) {
                money[i] = sc.nextInt();
            }
            int[] a = new int[m + 1];
            int[] b = new int[m + 1];
            for (int i = 1; i <= m; i++) {//让第一件物品对应的索引为1
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(a));
            System.out.println(maxB(money, a, b));
            //System.out.println(Arrays.toString(visited));
        }

        private static int maxB(int[] peo, int[] w, int[] v) {
            int n = peo.length;
            dp = new int[n][][];
            visited = new boolean[w.length];

            int k = 0;
            while (k < n) {
                dp[k] = new int[w.length][peo[k] + 1];

                for (int i = 1; i < w.length; i++) {
                    if (!visited[i]) {
                        for (int j = 1; j <= peo[k]; j++) {
                            if (j >= w[i]) {
                                dp[k][i][j] = Math.max(dp[k][i - 1][j], v[i] + dp[k][i - 1][j - w[i]]);
                            } else {
                                dp[k][i][j] = dp[k][i - 1][j];
                            }
                        }
                    } else {
                        dp[k][i] = dp[k][i - 1];//即使该物品被买了，也要更新dp表中的这一行
                    }
                }
                findTrace(w.length-1, peo[k], w, v, dp[k]);//从dp表右下角开始回溯
                k++;
            }
            int res = 0;
            for (int i1 = 0; i1 < n; i1++) {
                res += dp[i1][w.length - 1][peo[i1]];
            }
            return res;
        }

        static void findTrace(int x, int y, int[] w, int[] v, int[][] arr) {
            if (x == 0) {
                System.out.println(Arrays.toString(visited));
                return;
            }

            if (arr[x][y] == arr[x - 1][y]) {
                if(!visited[x])//如果该位置未被回溯过，才将这个位置置为false，避免在上一轮回溯为true重新被赋值
                    visited[x] = false;
                findTrace(x - 1, y, w, v, arr);
            } else if (arr[x][y] == arr[x - 1][y - w[x]] + v[x]) {
                visited[x] = true;
                findTrace(x - 1, y - w[x], w, v, arr);
            }

        }
}
