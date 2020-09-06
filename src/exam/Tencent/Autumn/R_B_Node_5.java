package exam.Tencent.Autumn;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/6 21:49
 * @Description: 【红黑棋】
 *
 * 小Q发明了一种新的棋类游戏：红黑棋
 * 这种游戏现在有2n个棋子排成一排，其中n颗黑色棋子，依次编号为1~n,n颗红色棋子，依次编号为1~n
 * 现在小Q进行若干次以下操作：交换相邻的两颗棋子。
 * 现在给出每颗棋子的颜色和编号，小Q希望你能用最少的操作次数，使得红色棋子的编号从左到右依次增大，
 * 黑色棋子的编号从左到右依次增大，颜色不一定连续。
 * 请你求出最少需要的次数。
 *
 * 输入描述：
 * 第一行输出一个数字n(1 <= n <= 3000)
 * 第二行包括一个字符串，即这2n个=颗棋子依次的颜色，‘R’表示红色棋子，‘B’表示黑色棋子。
 * 第三行包括2n个以空格分割的数字，即这2n颗棋子依次的编号。
 *
 * 输出描述:
 * 输出一个整数表示最少操作次数。
 *
 * 输入：
 * 3
 * BRRBRB
 * 2 3 1 1 2 3
 *
 * 输出：
 * 5
 *
 * 说明：
 * 初始：
 * BRRBRB
 * 231123
 * 第一次交换：
 * BRRBRB
 * 213123
 * 第二次交换：
 * BRBRRB
 * 21323
 * 第三次交换：
 * BRBRRB
 * 211233
 * 第四次交换：
 * BBRRRB
 * 211233
 * 第五次交换：
 * 121233
 *
 *
 */
public class R_B_Node_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //n

        in.nextLine();
        String RBStr = in.nextLine().trim();
        char[] RBArr = RBStr.toCharArray();

        int[] num = new int[2 * n];   //存放棋子编号



    }
}
