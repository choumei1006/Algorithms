package exam.DJI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/16 19:48
 * @Description:
 */
public class FindMinPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String optionStr = sc.nextLine().trim();
        String[] options = optionStr.split("\\s+");
        int N = Integer.parseInt(options[0]);  //N
        int P = Integer.parseInt(options[1]);   //P

        //通道存储
        int[][] map = new int[N][N];   //图
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], -1);
        }
        for (int i = 0; i < P; i++) {
            String tmpP = sc.nextLine().trim();
            String[] pOptions = tmpP.split("\\s+");
            int A = Integer.parseInt(pOptions[0]);
            int B = Integer.parseInt(pOptions[1]);
            int T = Integer.parseInt(pOptions[2]);

            map[A][B] = T;
        }

        String x_optionStr = sc.nextLine().trim();
        String[] x_options = x_optionStr.split("\\s+");
        int X = Integer.parseInt(x_options[0]);  //X

        getShortestPath(map);
        System.out.println(map[0][X]);
    }

    //Floyd：单源最短路径
    public static  void getShortestPath(int[][] adjMatrix){
        for (int k = 0; k < adjMatrix.length ; k++) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    if(adjMatrix[i][k] != -1 && adjMatrix[k][j] != -1){
                        int temp = adjMatrix[i][k] + adjMatrix[k][j];
                        if(adjMatrix[i][j] == -1 || adjMatrix[i][j] > temp){
                            adjMatrix[i][j] = temp;
                        }
                    }
                }
            }
        }
    }
}
