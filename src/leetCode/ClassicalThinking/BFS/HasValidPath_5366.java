package leetCode.ClassicalThinking.BFS;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/3/22 11:41
 * @Description: 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 *
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 *
 *
 * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、
 * 一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 *
 * 注意：你 不能 变更街道。
 *
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 * 示例 3：
 *
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 * 示例 4：
 *
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 * 示例 5：
 *
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 */
public class HasValidPath_5366 {
    private int[][] dirChange = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    @Test
    public void test(){
        System.out.println(hasValidPath(new int[][]{{2},{2},{2},{2},{2},{2},{2},{6}}));
    }
    public boolean hasValidPath(int[][] grid) {
        //特判
        if(null == grid){
            return false;
        }
        /*if(grid.length == 1 && grid[0].length == 1){
            return true;
        }*/
        int xLen = grid.length;
        int yLen = grid[0].length;

        //从grid[0][0]开始搜索，
        int initFrom1 = getDestByNum(1,grid[0][0]);
        int initFrom2 = getDestByNum(2, grid[0][0]);
        int initFrom3 = getDestByNum(3, grid[0][0]);
        int initFrom4 = getDestByNum(4, grid[0][0]);

        int direction =  initFrom1 > 0 ? initFrom1 : initFrom2 > 0 ? initFrom2 : initFrom3 > 0 ? initFrom3 : initFrom4 > 0 ? initFrom4 : -1;
        int x = 0;
        int y = 0;

        //只要道路任然贯通就沿道路走
        while(direction > 0){
            //判断是否到达目的地
            if(x == xLen-1 && y == yLen-1){
                return true;
            }
            //根据方向获取下一步坐标
            x += dirChange[direction-1][0];
            y += dirChange[direction-1][1];
            //判断是否越界
            if(x >= xLen || x < 0 || y >= yLen || y < 0){
                return false;
            }
            //获取下一步走向
            direction = getDestByNum(direction,grid[x][y]);
        }
        return false;
    }
    /**
     * 根据入口及路标获取下一步走向
     * @param from
     * @param num
     * @return
     */
    public int getDestByNum(int from,int num){
        int dest = -1;
        switch (num){
            case 1:
                dest = from == 1 ? 1 : from == 3 ? 3 : -1;
                break;
            case 2:
                dest = from == 2 ? 2 : from == 4 ? 4 : -1;
                break;
            case 3:
                dest = from == 1 ? 2 : from == 4 ? 3 : -1;
                break;
            case 4:
                dest = from == 4 ? 1 : from == 3 ? 2 : -1;
                break;
            case 5:
                dest = from == 1 ? 4 : from == 2 ? 3 : -1;
                break;
            case 6:
                dest = from == 2 ? 1 : from == 3 ? 4 : -1;
                break;
            default:
                dest = -1;
                break;
        }
        return dest;
    }


}
