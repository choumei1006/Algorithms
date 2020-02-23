package LeetCode.ClassicalThinking;

/**
 * @author:choumei
 * @date:2020/2/23 11:57
 * @Description: 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * 示例 2：
 *
 * 输入：num = 123
 * 输出：[5,25]
 * 示例 3：
 *
 * 输入：num = 999
 * 输出：[40,25]
 *
 *
 * 提示：
 *
 * 1 <= num <= 10^9
 */
public class CloestDivisors_5171 {
    public static void main(String[] args) {
        int[] rst = closestDivisors(8);
        for(int temp : rst){
            System.out.println(temp);
        }
    }
    public static  int[] closestDivisors(int num) {
        int[] rst1 = findHelper(num+1);
        int[] rst2 = findHelper(num+2);
        return Math.abs(rst1[0]-rst1[1]) > Math.abs(rst2[0]-rst2[1]) ? rst2 : rst1;
    }
    public static int[] findHelper(int num){
        int gen = (int)Math.sqrt(num);
        while(gen > 1){
            if(num  % gen == 0){
                return new int[]{gen,num/gen};
            }else{
                gen--;
            }
        }
        return new int[]{1,num};
    }
}
