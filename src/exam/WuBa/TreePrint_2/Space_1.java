package exam.WuBa.TreePrint_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/14 20:45
 * @Description:
 */
public class Space_1 {
    public static void main(String[] args) {
        //接收输入数据
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   //m
        int n = sc.nextInt();   //n

        int[][] grid = new int[m][n];   //地图

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int res = 0;   //疫情聚集区数目

        //获取地图中的疫情聚集区
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    ++res;
                }
            }
        }
        System.out.println(res);
    }

    /**
     * dfs查询某一小区周围聚集区
     * @param grid
     * @param i
     * @param j
     */
    public static void dfs(int[][] grid, int i, int j){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i , j - 1);
        dfs(grid, i , j + 1);
    }
}
