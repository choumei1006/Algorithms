package Exam.Meituan_trainee;

import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/23 19:10
 * @Description:  找出平面内的幸运星个数
 */
public class LuckyStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //n行

        List<int[]> list = new ArrayList<>();
        //建立2000 * 2000的网格坐标系
        int[][] pos = new int[2000][2000];

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            pos[1000+x][1000+y] = 1;
            list.add(new int[]{1000+x,1000+y});
        }

        //方向
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int cnt = 0;
        //BFS方向
        for(int[] p : list){
            int curX = p[0];
            int curY = p[1];
            int res = 0;
            for (int i = 0; i < 4; i++) {
                int newX = curX;
                int newY = curY;
                while(true){
                    newX += dirs[i][0];
                    newY += dirs[i][1];
                    if(newX < 0 || newX >= 2000 || newY < 0 || newY >= 2000 ){
                        break;
                    }
                    if(pos[newX][newY] == 1){
                        res++;
                        break;
                    }
                }
            }
            if(res == 4){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
