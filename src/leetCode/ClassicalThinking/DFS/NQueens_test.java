package leetCode.ClassicalThinking.DFS;

import org.w3c.dom.ls.LSOutput;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/12 9:09
 * @Description: N皇后问题自测
 */
public class NQueens_test {
    public static void main(String[] args) {
        //1、接受输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //2、调用子函数，获取结果集
        List<List<String>> rst = getBoards(N);

        //3、输出结果集
        int idx = 1;
        for (List<String> s : rst) {
            System.out.println("方案" + idx++);
            System.out.println("[");
            for(String str : s){
                System.out.println("\t[" + str + "]");
            }
            System.out.println("]");
        }
    }

    /**
     * 获取N皇后问题的所有棋盘解集合
     *
     * @return
     */
    public static List<List<String>> getBoards(int N) {
        //1、创建棋盘
        int[][] board = new int[N][N];

        //2、创建结果集
        List<List<String>> rst = new ArrayList<>();

        //2、从第一行开始回溯访问
        backTrack(board, 0, rst);

        return rst;
    }

    /**
     * 回溯访问每一行
     *
     * @param board
     * @param rowIdx
     * @param rst
     */
    public static void backTrack(int[][] board, int rowIdx, List<List<String>> rst) {
        int queenCnt = board.length;

        //1、是否构成整局棋盘
        if (rowIdx == board.length){
            rst.add(format(board));   //将二维数组格式化为字符串集合 ‘.’、‘Q’
        }

        //2、访问当前行的所有列位置是否可以放置皇后，并进行回溯
        for (int col = 0; col < queenCnt; col++) {
            //不能放皇后
            if(!isValid(board, rowIdx, col)){
                continue;
            }
            //可以放皇后-回溯
            board[rowIdx][col] = 1;
            backTrack(board, rowIdx + 1, rst);

            //撤销操作
            board[rowIdx][col] = 0;
        }
    }

    /**
     * 判断棋盘board中<rowIdx, colIdx>位置是否可以放置皇后
     * @param board
     * @param rowIdx
     * @param colIdx
     * @return
     */
    public static boolean isValid(int[][] board, int rowIdx, int colIdx){
        //特判
        if(null == board || board.length == 0 || board.length != board[0].length){
            return false;
        }
        //边界
        int len = board.length;
        if(rowIdx < 0 || rowIdx >= len || colIdx < 0 || colIdx >= len){
            return false;
        }

        //同一列
        for (int i = 0; i < rowIdx; i++) {
            if(board[i][colIdx] == 1){
                return false;
            }
        }
        //左上角
        for (int i = rowIdx - 1, j = colIdx - 1; i >= 0 && j >= 0 ; i--, j--) {
            if(board[i][j] == 1){
                return false;
            }
        }

        //右上角
        for (int i = rowIdx - 1, j = colIdx + 1; i >= 0 && colIdx < len ; i--, j++) {
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 辅助类：将棋盘01转换为‘.’、‘Q’组成的字符串集合
     *
     * @param board
     * @return
     */
    public static List<String> format(int[][] board) {
        List<String> res = new ArrayList<>();
        //特判
        if (null == board || board.length == 0) {
            return res;
        }
        for(int[] row : board){
            StringBuilder sb = new StringBuilder();
            for(int i : row){
                sb.append(i > 0 ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
