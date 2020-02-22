package LeetCode.ClassicalThinking.Josephu;

/**
 * @author:choumei
 * @date:2020/2/22 23:18
 * @Description: 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
 *
 * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
 *
 * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
 *
 * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
 *
 * 请你实现 Cashier 类：
 *
 * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
 * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
 * [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
 * 输出
 * [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
 * 解释
 * Cashier cashier = new Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]);
 * cashier.getBill([1,2],[1,2]);                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
 * cashier.getBill([3,7],[10,10]);                      // 返回 4000.0
 * cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
 * cashier.getBill([4],[10]);                           // 返回 4000.0
 * cashier.getBill([7,3],[10,10]);                      // 返回 4000.0
 * cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
 * cashier.getBill([2,3,5],[5,3,2]);                    // 返回 2500.0
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^4
 * 0 <= discount <= 100
 * 1 <= products.length <= 200
 * 1 <= products[i] <= 200
 * products 列表中 不会 有重复的元素。
 * prices.length == products.length
 * 1 <= prices[i] <= 1000
 * 1 <= product.length <= products.length
 * product[i] 在 products 出现过。
 * amount.length == product.length
 * 1 <= amount[i] <= 1000
 * 最多有 1000 次对 getBill 函数的调用。
 * 返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
 * [[3,50,[1,2,3,4,5,6,7],[101,201,301,401,301,201,101]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],
 * [1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
 *
 * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill",
 * "getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
 * [[192,34,[77],[302]],[[77],[343]],[[77],[990]],[[77],[101]],[[77],[577]],[[77],[160]],[[77],[20]],[[77],[407]],
 * [[77],[205]],[[77],[511]],[[77],[456]],[[77],[287]],[[77],[560]],[[77],[945]],[[77],[453]],[[77],[165]],
 * [[77],[326]],[[77],[222]],[[77],[30]],[[77],[464]],[[77],[916]],[[77],[153]],[[77],[170]],[[77],[368]],
 * [[77],[215]],[[77],[684]],[[77],[21]],[[77],[78]],[[77],[825]],[[77],[259]],[[77],[609]],[[77],[80]],
 * [[77],[660]],[[77],[740]],[[77],[453]],[[77],[918]],[[77],[574]],[[77],[897]],[[77],[135]],[[77],[391]],
 * [[77],[912]],[[77],[560]],[[77],[215]],[[77],[700]],[[77],[557]],[[77],[364]],[[77],[213]],[[77],[331]],
 * [[77],[627]],[[77],[812]],[[77],[84]],[[77],[501]],[[77],[683]],[[77],[603]],[[77],[454]],[[77],[160]],
 * [[77],[19]],[[77],[25]],[[77],[381]],[[77],[595]],[[77],[198]],[[77],[52]],[[77],[734]],[[77],[742]],
 * [[77],[419]],[[77],[555]],[[77],[330]],[[77],[631]],[[77],[132]],[[77],[825]],[[77],[850]],[[77],[923]],
 * [[77],[171]],[[77],[72]],[[77],[13]],[[77],[668]],[[77],[729]],[[77],[64]],[[77],[657]],[[77],[223]],
 * [[77],[981]],[[77],[107]],[[77],[477]],[[77],[111]],[[77],[812]],[[77],[419]],[[77],[391]],[[77],[448]],
 * [[77],[75]],[[77],[842]],[[77],[627]],[[77],[776]],[[77],[297]],[[77],[711]],[[77],[309]],[[77],[654]],
 * [[77],[526]],[[77],[921]],[[77],[73]],[[77],[360]],[[77],[728]],[[77],[499]],[[77],[856]],[[77],[678]],
 * [[77],[488]],[[77],[111]],[[77],[860]],[[77],[352]],[[77],[193]],[[77],[922]],[[77],[859]],[[77],[865]],
 * [[77],[113]],[[77],[370]],[[77],[966]],[[77],[694]],[[77],[432]],[[77],[549]],[[77],[909]]]
 */
public class ApplyDiscount_5324 {
    public static void main(String[] args) {
        Cashier cashier = new Cashier(192,34,new int[]{77},new int[]{302});
        System.out.println(cashier.getBill(new int[]{77},new int[]{343}));                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
        /*System.out.println(cashier.getBill(new int[]{3,7},new int[]{10,10}));                      // 返回 4000.0
        System.out.println(cashier.getBill(new int[]{1,2,3,4,5,6,7},new int[]{1,1,1,1,1,1,1}));    // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
        System.out.println(cashier.getBill(new int[]{4},new int[]{10}));                           // 返回 4000.0
        System.out.println(cashier.getBill(new int[]{7,3},new int[]{10,10}));                      // 返回 4000.0
        System.out.println(cashier.getBill(new int[]{7,5,3,1,6,4,2},new int[]{10,10,10,9,9,9,7})); // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
        System.out.println(cashier.getBill(new int[]{2,3,5},new int[]{5,3,2}));             */      // 返回 2500.0

    }
}
