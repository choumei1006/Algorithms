package LeetCode.ClassicalThinking.DFS;

/**
 * @author:choumei
 * @date:2020/3/15 12:31
 * @Description: 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 */
public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
 }));
    }
    public static  int maxAreaOfIsland(int[][] matrix){
        if(null == matrix || matrix.length == 0){
            return 0;
        }
        int rst = 0;
        for (int r = 0; r < matrix.length ; r++) {
            for (int c = 0; c < matrix[r].length ; c++) {
                int a = area(matrix,r,c);
                rst = Math.max(a,rst);
            }
        }
        return rst;
    }
    public static int area(int[][] matrix,int r,int c){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length){
            return 0;
        }
        if(matrix[r][c] != 1){
            return 0;
        }
        matrix[r][c] = 2;
        return 1+area(matrix,r-1,c)+area(matrix,r+1,c)+area(matrix,r,c-1)+area(matrix,r,c+1);
    }
}
