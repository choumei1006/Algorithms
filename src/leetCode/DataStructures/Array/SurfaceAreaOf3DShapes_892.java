package leetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/3/25 20:44
 * @Description: 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 */
public class SurfaceAreaOf3DShapes_892 {
    @Test
    public void test(){

    }

    /**
     * 计算多边形表面积
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid){
        //特判
        if(null == grid){
            return 0;
        }
        //网格行数
        int rowLen = grid.length;
        //网格列数
        int colLen = grid[0].length;

        //统计立方体个数
        int cnt = 0;
        int verticalOverlap = 0;   //垂直方向上的重叠次数
        int rowOverlap = 0;     //水平-行方向上的重叠次数
        int colOverlap = 0;     //水平-列方向上的重叠次数


        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                cnt += grid[i][j];
                if(grid[i][j] > 1){
                    verticalOverlap += grid[i][j]-1;
                }
                //统计与前一行的立方柱的重叠面个数
                if(i > 0){
                    rowOverlap += Math.min(grid[i-1][j],grid[i][j]);
                }

                //统计与前一列的立方柱的重叠面个数
                if(j > 0){
                    colOverlap += Math.min(grid[i][j-1],grid[i][j]);
                }
            }
        }
        return cnt*6 - (verticalOverlap + rowOverlap + colOverlap)*2;

    }
}
