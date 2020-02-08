package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/8 22:31
 * @Description: 5311. 将数字变成 0 的操作次数 显示英文描述
 * 用户通过次数878
 * 用户尝试次数881
 * 通过次数897
 * 提交次数971
 * 题目难度Easy
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 *
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 *
 * 输入：num = 123
 * 输出：12
 *
 */
public class NumberOfSteps_5311 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
    public static int numberOfSteps (int num) {
        int times = 0;
        while(num!=0){
            if(num % 2 != 0){
                num--;
            }else{
                num /= 2;
            }
            times++;
        }
        return times;
    }
}
