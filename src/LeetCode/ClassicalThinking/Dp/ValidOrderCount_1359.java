package LeetCode.ClassicalThinking.Dp;

/**
 * @author:choumei
 * @date:2020/2/23 1:08
 * @Description: 给你 n 笔订单，每笔订单都需要快递服务。
 *
 * 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务 delivery(i) 总是在其收件服务 pickup(i) 之后。
 *
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：只有一种序列 (P1, D1)，物品 1 的配送服务（D1）在物品 1 的收件服务（P1）后。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：6
 * 解释：所有可能的序列包括：
 * (P1,P2,D1,D2)，(P1,P2,D2,D1)，(P1,D1,P2,D2)，(P2,P1,D1,D2)，(P2,P1,D2,D1) 和 (P2,D2,P1,D1)。
 * (P1,D2,P2,D1) 是一个无效的序列，因为物品 2 的收件服务（P2）不应在物品 2 的配送服务（D2）之后。
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：90
 *
 *
 * 提示：
 *
 * 1 <= n <= 500
 */
public class ValidOrderCount_1359 {
    public static void main(String[] args) {
        System.out.println(countOrders(18));
    }
    public static  int countOrders(int n) {
        long rst = 1;
        long mods = (long)Math.pow(10,9)+7;
        for (int i = 1; i <= 2*n; i++) {
            rst *= i%2==0 ? i/2 : i;
            rst %= mods;
        }
        return (int)rst;
    }
}