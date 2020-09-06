package exam.DJI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/16 20:21
 * @Description:
 */
public class Gamer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String optionStr = sc.nextLine().trim();
        String[] options = optionStr.split("\\s+");
        int N = Integer.parseInt(options[0]);  //N 游戏数
        int X = Integer.parseInt(options[1]);   //  总天数

        //存储N个游戏 天数-成就值
        int[] v = new int[N];    //花费天数
        int[] w = new int[N];   //游戏成就值
        for (int i = 0; i < N; i++) {
            String tmpP = sc.nextLine().trim();
            String[] pOptions = tmpP.split("\\s+");
            int value = Integer.parseInt(pOptions[0]);
            int weight = Integer.parseInt(pOptions[1]);

            v[i] = value;
            w[i] = weight;
        }

        //特判
        if(null == v || null == w || v.length == 0 || w.length == 0){
            System.out.println(0);
            return;
        }

        int[][] temp = new int[N][X + 1];
        for (int j = 0; j < X + 1; j++) {
            temp[0][j] = 0;
        }

        for (int i = 0; i < N; i++) {
            temp[i][0] = 0;
        }

        //0-1 背包法处理
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < X + 1; j++) {
                if(w[i] <= j){
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - w[i]] + v[i]);
                }else{
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }

        //输出结果集
        System.out.println(temp[N - 1][X]);
    }
}
