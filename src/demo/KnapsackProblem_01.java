package demo;

import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/2/4 13:30
 * @Description: 动态规划-01背包问题
 */
public class KnapsackProblem_01 {
    public static void main(String[] args) {

        int[] w = {1,4,3};    //商品重量数组
        int[] val = {1500,3000,2000};   //商品价值数组

        int m = 4;          //背包总容量
        int n = val.length;    //商品数量


        int[][] v = new int[n+1][m+1];    //v[i][j]表示背包中放入前i个物品时的商品最大总价值

        //初始化第一行、第一列
        for (int i = 0; i < m+1 ; i++) {
            v[0][i] = 0;
        }
        for (int i = 0; i < n+1 ; i++) {
            v[i][0] = 0;
        }

        int[][] path = new int[n+1][m+1];    //记录背包策略

        //根据公式动态规划处理
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < m+1 ; j++) {
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    if(v[i-1][j] >= val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = v[i-1][j];
                    }else{
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }
                }
            }
        }

        //输出V
        for (int i = 0; i < v.length ; i++) {
            for (int j = 0; j < v[i].length ; j++) {
                System.out.printf(v[i][j]+"\t");
            }
            System.out.println();
        }


        //输出策略
        int i = path.length-1;
        int j = path[0].length-1;
        while(i >= 0 && j >= 0){
            if(path[i][j] == 1){
                System.out.printf("第%d个背包被装入；\n",i);
                j -= w[i-1];
            }
            i--;
        }
    }
}
