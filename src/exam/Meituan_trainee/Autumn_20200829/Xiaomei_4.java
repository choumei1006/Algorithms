package exam.Meituan_trainee.Autumn_20200829;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/29 16:12
 * @Description: 【小团的默契游戏】
 *
 * 小团从某不知名论坛上突然得到了一个测试默契度的游戏，想和小美玩一次来检验两人的默契程度。
 * 游戏规则十分简单，首先有给出一个长度为n的序列，最大值不超过m。
 *
 * 小团和小美各自选择一个[1,m]之间的整数，设小美选择的是l，小团选择的是r，我们认为两个人是默契的需要满足以下条件:
 *
 * 1. l 小于等于r。
 *
 * 2. 对于序列中的元素x，如果0<x<l,或r<x<m+1,则x按其顺序保留下来，要求保留下来的子序列单调不下降。
 *
 * 小团为了表现出与小美最大的默契，因此事先做了功课，他想知道能够使得两人默契的二元组<l,r>一共有多少种。
 *
 * 我们称一个序列A为单调不下降的，当且仅当对于任意的i>j,满足A_i>=A_j。
 *
 *
 *
 * 输入描述
 * 输入第一行包含两个正整数m和n，表示序列元素的最大值和序列的长度。(1<=n,m<=100000)
 *
 * 输入第二行包含n个正整数，表示该序列。
 *
 * 输出描述
 * 输出仅包含一个整数，表示能使得两人默契的二元组数量。
 *
 *
 * 样例输入
 * 5 5
 * 4 1 4 1 2
 * 样例输出
 * 10
 */
public class Xiaomei_4 {
    public static void main(String[] args) {
        //接收数据输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }



    }

    /**
     * 思路：动态规划
     *     遍历每一个nums元素，返回当前元素之前，比它小的元素中，
     * 最大的dp[i]+1,即为：以当前元素为尾的数组中的最长升序序列长度；
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(null == nums){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int rstLen = 1;
        for(int i = 1; i<len ;i++){
            int tempMaxLen = 0;
            for(int j = 0; j < i ;j++){
                if(nums[j] < nums[i] ){
                    tempMaxLen = Math.max(tempMaxLen,dp[j]);
                }
            }
            dp[i] = tempMaxLen+1;
            rstLen = Math.max(rstLen,dp[i]);
        }
        return rstLen;
    }



}
