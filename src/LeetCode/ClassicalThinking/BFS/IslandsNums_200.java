package LeetCode.ClassicalThinking.BFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/4/20 9:29
 * @Description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class IslandsNums_200 {
    @Test
    public void test(){
        System.out.println(numsIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
    public int numsIslands(char[][] grid){
        if(null == grid || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    res++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.addLast(i * n + j);
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int curPoint = queue.removeFirst();
                        int curX = curPoint / n;
                        int curY = curPoint % n;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + dir[k][0];
                            int newY = curY + dir[k][1];
                            if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[curX][curY] == '1'){
                                queue.addLast(newX * n + newY);
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
