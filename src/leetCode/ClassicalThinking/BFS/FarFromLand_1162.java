package leetCode.ClassicalThinking.BFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/3/29 23:13
 * @Description: 你现在手里有一份大小为 N x N 的『地图』（网格） grid，
 * 上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：
 * (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 参考：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
 *
 */
public class FarFromLand_1162 {
    @Test
    public void test(){
        System.out.println(maxDistance1(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
    }

    /**
     * BFS获取离陆地最远的海洋坐标，返回该海洋与离其最近的陆地之间的【曼哈顿距离】；
     * @param grid
     * @return
     */
    public int maxDistance1(int[][] grid){
        if(null == grid || grid.length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        //将grid中的所有陆地坐标存入队列中
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;

        //BFS访问地图方格
        while(!queue.isEmpty()){
            point = queue.poll();
            int curx = point[0];
            int cury = point[1];
            for (int i = 0; i < 4; i++) {
                int newx = curx + dir[i][0];
                int newy = cury + dir[i][1];
                if(newx < 0 || newx >= m || newy < 0 || newy >= n || grid[newx][newy] != 0){
                    continue;
                }
                grid[newx][newy] = grid[curx][cury] + 1;
                hasOcean = true;
                queue.add(new int[]{newx,newy});
            }
        }
        if(null == point || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    /**
     * 自测
     * @param grid
     * @return
     */
    public int maxDistance2(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> queue = new  LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[] tempPos = null;
        int newx,newy;
        boolean hasOcean = false;
        while(!queue.isEmpty()){
            tempPos = queue.poll();
            for(int[] d : dir){
                newx = tempPos[0] + d[0];
                newy = tempPos[1] + d[1];
                if(newx < 0 || newx > m || newy < 0 || newy > n || grid[newx][newy] != 0){
                    continue;
                }
                grid[newx][newy] = grid[tempPos[0]][tempPos[1]]+1;
                hasOcean = true;
            }
        }
        if(!hasOcean || null == tempPos){
            return -1;
        }
        return grid[tempPos[0]][tempPos[1]]-1;
    }
}
