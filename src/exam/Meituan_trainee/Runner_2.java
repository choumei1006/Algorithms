package exam.Meituan_trainee;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/4/9 19:14
 * @Description: 题目描述：
 * “我将带头冲锋。”每一个军人如是说。
 *
 * 某部队举办了一届军事运动会，其中有一个团体马拉松项目，有n名选手按顺序从起跑线出发，并且记录下他们到达终点的顺序。
 * 在跑步过程中超越了其他人的选手要给予表彰。
 *
 * 受表彰的选手需要满足的条件是，如果存在一名出发顺序排在选手X之后的选手Y先于X到达终点，则认为Y超越了X。
 *
 * 对于每一个选手，只要他超越了任意一个人，就有资格受到表彰。请你计算出有多少人可以得到表彰。
 * 输入
 * 输入第一行仅包含一个正整数n，表示选手数量。(1<=n<=10^5)
 *
 * 输入第二行包含n个正整数，是一个1-n的排列A，表示出发顺序，A[i]表示第i个出发的选手的编号。
 *
 * 输入第三行同样包含一个1-n的排列B，表示到达顺序，B[i]表示第i个到达的选手的编号。
 *
 * 输出
 * 输出仅包含一个整数，表示得到表彰的人数。
 *
 *
 * 样例输入
 * 5
 * 5 3 1 4 2
 * 2 4 5 1 3
 * 样例输出
 * 3
 *
 * 提示
 * 样例解释：
 * 显然除了5号和3号以外，其他人都可以受到表彰，因为他们均超越了3号。
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
public class Runner_2 {
    @Test
    public void test(){
        //main();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //n
        //int[] start = new int[n];
        //int[] end = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            //start[i] = sc.nextInt();
            //queue.add(start[i]);
            int start_i = sc.nextInt();
            if(start_i >= 1 && start_i <= n) {
                queue.add(start_i);
            }
        }
        for(int i = 0; i < queue.size(); i++){
            //end[i] = sc.nextInt();
            //if(end[i] != queue.peek()){
            int end_i = sc.nextInt();
            if(end_i != queue.peek() && end_i >= 1 && end_i <= n){
                res++;
            }else{
                queue.poll();
            }
        }
        System.out.println(res);
    }
}
