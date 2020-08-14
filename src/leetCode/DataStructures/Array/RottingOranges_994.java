package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/3/4 13:22
 * @Description: 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 */
public class RottingOranges_994 {
    @Test
    public  void test() {
        System.out.println(orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
    }
    class Pos{
        int x ;
        int y ;
        int minute ;
        public Pos(int _x,int _y,int _minute){
            this.x = _x;
            this.y = _y;
            this.minute = _minute;
        }
    }
    public  int orangesRotting(int[][] grid) {
        //参数检查
        if(grid.length == 0){
            return 0;
        }
        //定义minute、dir数组
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int minute = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        //定义队列
        Queue<Pos> queue = new LinkedList<Pos>();
        //将腐烂的橘子加入队列
        for (int i = 0; i < rowLen ; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 2){
                    queue.add(new Pos(i,j,minute));
                }
            }
        }
        //BFS
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            minute = p.minute;
            for (int i = 0; i < 4; i++) {
                int pos_x = p.x+dir[i][0];
                int pos_y = p.y+dir[i][1];
                if(pos_x >= 0 && pos_x < rowLen && pos_y >= 0 && pos_y < colLen && grid[pos_x][pos_y] == 1){
                    grid[pos_x][pos_y] = 2;
                    queue.add(new Pos(pos_x,pos_y,minute+1));
                }
            }
        }
        //遍历grid，检查好橘子
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        //return
        return minute;
    }
}
