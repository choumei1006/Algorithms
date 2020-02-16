package LeetCode.DataStructures.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/2/16 11:16
 * @Description: 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 *
 * 1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 *
 *
 * 提示：
 *
 * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
 * 0 <= num <= 100
 * 1 <= k <= 40000
 */
public class ProductOfNumbers_5341 {
    public static void main(String[] args) {
        /**
         * Your ProductOfNumbers object will be instantiated and called as such:
         * ProductOfNumbers obj = new ProductOfNumbers();
         * obj.add(num);
         * int param_2 = obj.getProduct(k);
         */

        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(11);        // [3,0,2,5]
        productOfNumbers.add(15);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
    }


}

class ProductOfNumbers{
    List<Integer> preResult = new ArrayList<>();
    int lastZeroIdx;

    public ProductOfNumbers(){
        preResult.add(1);
    }

    public void add(int num){
        if(num == 0){
            lastZeroIdx = preResult.size();
            preResult.add(1);
        }else{
            preResult.add(preResult.get(preResult.size()-1)*num);
        }
    }

    public int getProduct(int k){
        int lastIdx = preResult.size()-1;
        int preKIdx = lastIdx-k;
        if(preKIdx < lastZeroIdx){
            return 0;
        }else{
            return preResult.get(lastIdx)/preResult.get(preKIdx);
        }
    }

}

/**
 * 方案一：超时
 */
class ProductOfNumbers2 {
    private StringBuilder  arrStr ;
    public String[] arr;

    public ProductOfNumbers2() {
        arrStr = new StringBuilder();
        arr = null;
    }

    public void add(int num) {
        arrStr.append(","+num);
        //arr = arrStr.toString().split(",");
    }

    public int getProduct(int k) {
        arr = arrStr.toString().split(",");
        int p = 1;
        for (int i = arr.length-1; i >= arr.length-k ; i--) {
            p *= Integer.parseInt(arr[i]);
        }
        return p;
    }
}

