package leetCode.ClassicalThinking.BFS;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/4/8 10:52
 * @Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 */
public class RobotMovingScope_interview13 {
    @Test
    public void test(){
        System.out.println(movingCount(16,8,4));
    }

    /**
     * 计算机器人能够到达的方格数；
     * 方法一：BFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k){
        int[][] dir = {{0,1},{1,0}};              //遍历方向
        Queue<int[]> queue = new LinkedList<>();  //BFS队列
        queue.offer(new int[]{0,0});   //初始入队
        int[][] map = new int[m][n];
        int res = 0;      //结果

        //临时变量
        int[] tempPos = new int[2];
        int newx = 0;
        int newy = 0;
        boolean isTerm = false;

        while(!queue.isEmpty()){
            tempPos = queue.poll();
            isTerm = false;
            if(isValid(tempPos,k)){
                //System.out.println(Arrays.toString(tempPos));
                isTerm = true;
                res++;
            }
            for(int[] d : dir){
                newx = tempPos[0] + d[0];
                newy = tempPos[1] + d[1];
                if(!(newx >= 0 && newx < m && newy >= 0 && newy < n && map[newx][newy] == 0 && isTerm)){
                    continue;
                }
                queue.offer(new int[]{newx,newy});
                map[newx][newy] = 1;
            }
        }
        return res;
    }

    /**
     * 判断坐标各数位之和是否小于等于k
     * @param pos
     * @param k
     * @return
     */
    public boolean isValid(int[] pos, int k){
        int x = pos[0];
        int y = pos[1];
        int res = 0;
        while(x != 0){
            res += x % 10;
            x /= 10;
        }
        while(y != 0){
            res += y % 10;
            y /= 10;
        }
        return res > k ? false : true;
    }
}
