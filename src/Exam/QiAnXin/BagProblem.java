package Exam.QiAnXin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/1 15:57
 * @Description:
 */
public class BagProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();  //总预算V
        int n = sc.nextInt();  //物资种类n

        int[] weight = new int[n];
        int[] value = new int[n];
        int[] num = new int[n];

        for(int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
            num[i] = 20;
        }

        System.out.println(manyPack(V, n, weight, value, num));
    }

    /**
     * 背包最大价值求解
     * @param
     */
    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }

        return dp[N][V];
    }

}
