package LeetCode.ClassicalThinking.Josephu;

import java.util.HashMap;

/**
 * @author:choumei
 * @date:2020/2/22 23:19
 * @Description:
 * /**
 *  * Your Cashier object will be instantiated and called as such:
 *  * Cashier obj = new Cashier(n, discount, products, prices);
 *  * double param_1 = obj.getBill(product,amount);
 *
 */
public class Cashier {
    int currIdx = 0;
    int n;  //打折频率
    int discount;  //折扣
    int[] products;
    int[] prices;
    HashMap<Integer,Integer> map;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.currIdx = 0;
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        this.map = new HashMap<>();
        for(int i = 0;i < products.length;i++){
            map.put(products[i],prices[i]);
        }

    }

    public double getBill(int[] product, int[] amount) {
        double cnt = 0;
        for (int i = 0; i < product.length; i++) {
            cnt += map.get(product[i]) *amount[i];
        }
        cnt -= (++currIdx== n ? cnt*discount/100 : 0);
        currIdx = currIdx == n ? 0 : currIdx;
        return cnt;
    }
}
