package leetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/2/16 11:04
 * @Description: 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回 grid 中 负数 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 *
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 *
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 *
 * 输入：grid = [[-1]]
 * 输出：1
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class CountNegatives_5340 {
    public static void main(String[] args) {
        //System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println(countNegatives(new int[][]{{}}));
    }
    public static  int countNegatives(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        int beginRow = m;
        for(int  i = 0; i < m;i++){
            if(grid[i][n-1] < 0){
                beginRow = i;
                break;
            }
        }
        if(beginRow > m-1){
            return 0;
        }
        int cnt = 0;
        int frontIdx = n-1;
        for(int  i = beginRow; i < m;i++){
            int temp = grid[i][frontIdx];
            while(temp < 0 && frontIdx >= 1 && grid[i][frontIdx-1] < 0){
                frontIdx--;
            }
            cnt += n-frontIdx;
        }
        return cnt;
    }

    @Test
    public void test(){
        //System.out.println(countNegatives2(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println(countNegatives(new int[][]{{}}));
    }

    /**
     * 统计矩阵中的所有负数个数
     * @param grid
     * @return
     */
    public int countNegatives2(int[][] grid){
        //特判
        if(null == grid ||  grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        //找到自上而下第一个出现负数的行
        int beginRow = 0;
        for (int i = 0; i < m; i++) {
            if(grid[i][n-1] < 0){
                beginRow = i;
                break;
            }
        }

        //没有负数
        if(beginRow > m - 1){
            return 0;
        }
        //从起始行开始遍历每行的负数
        int cnt = 0;
        for (int i = beginRow; i < m; i++) {
            int beginCol = n - 1;
            while(beginCol >= 0 && grid[i][beginCol] < 0){
                beginCol--;
                cnt++;
            }
        }
        return cnt;
    }
}
