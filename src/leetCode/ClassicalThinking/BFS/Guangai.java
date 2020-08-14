package leetCode.ClassicalThinking.BFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/5/13 15:30
 * @Description:
 */
public class Guangai {
    @Test
    public void test(){
        System.out.println(waterMap(new int[][]{{0,1,0,0,0},{0,0,0,1,0},{0,1,0,0,0},{0,0,0,0,0}},2));
    }
    class Pos{
        int x ;
        int y ;
        int hour ;
        public Pos(int _x,int _y,int _hour){
            this.x = _x;
            this.y = _y;
            this.hour = _hour;
        }
    }
    public  int waterMap(int[][] grid, int hour) {
        //参数检查
        if(grid.length == 0){
            return 0;
        }
        //定义minute、dir数组
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int sum = rowLen * colLen;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        //定义队列
        Queue<Pos> queue = new LinkedList<Pos>();
        //将水管田加入队列
        for (int i = 0; i < rowLen ; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1){
                    queue.add(new Pos(i, j,0));
                }
            }
        }
        int curWatered = queue.size();
        //BFS
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            if(p.hour >= hour){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int pos_x = p.x + dir[i][0];
                int pos_y = p.y + dir[i][1];
                if(pos_x >= 0 && pos_x < rowLen && pos_y >= 0 && pos_y < colLen && grid[pos_x][pos_y] == 0){
                    grid[pos_x][pos_y] = 1;
                    queue.add(new Pos(pos_x,pos_y,p.hour+1));
                    curWatered ++;
                }
            }
        }
        return sum - curWatered;
    }
}
