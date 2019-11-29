package LeetCode.ClassicalThinking.DoublePointer;

/**
 * @author:choumei
 * @date:2019/11/29 10:38
 * @Description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * 示例2:
 * 输入: 3
 * 输出: False
 *
 */
public class twoSquareSum_633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
    }
    public static boolean judgeSquareSum(int c){

        if(c < 0) return false;
        int i=0,j=(int)Math.sqrt(c);
        while(i <= j){
            int curSum = i*i+j*j;
            if(curSum == c) return true;
            else if(curSum > c) j--;
            else if(curSum < c) i++;
        }
        return false;
    }
}
