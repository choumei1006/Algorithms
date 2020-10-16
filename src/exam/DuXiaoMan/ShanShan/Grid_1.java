package exam.DuXiaoMan.ShanShan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/13 20:52
 * @Description:
 */
public class Grid_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.nextLine();
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine().trim();
            char[] tmpRow = input.toCharArray();
            grid[i] = tmpRow;
        }
        System.out.println(getMaxTime(grid, K));
    }

    /**
     * 获取最短时间
     * @param grid
     * @return
     */
    public static  int getMaxTime(char[][] grid, int K){
        //特判
        if(null == grid || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int N = grid.length;
        int timeCnt = 0;

        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        //[0,0]坐标存入队列中
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[] point = null;
        //BFS访问迷宫方格
        while(!queue.isEmpty()){
            point = queue.poll();
            int curx = point[0];
            int cury = point[1];

            int newx = -1;
            int newy = -1;
            //向四个方向延申一步
            for (int i = 0; i < 4; i++) {
                int tmpTimeCnt = timeCnt;
                newx = curx + dir[i][0];
                newy = cury + dir[i][1];
                if(newx < 0 || newx >= N || newy < 0 || newy >= N || grid[newx][newy] == '1'){
                    continue;
                }
                if(grid[newx][newy] == '0'){
                    tmpTimeCnt ++;
                }else if(grid[newx][newy] == '#'){
                    tmpTimeCnt += K;
                }
                timeCnt = Math.max(timeCnt, tmpTimeCnt);

            }
            if(newx == N - 1  && newy == N - 1){
                break;
            }
        }
        return timeCnt;
    }
}
