package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/15 23:08
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class PalindromeNumber_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x){
        if(x == 0){
            return true;
        }
        if(x < 0 || x % 10 == 0){
            return false;
        }
        int right = 0;
        while(x > right){
            right = right*10 + (x % 10);
            x /= 10;
        }
        return x == right || x == (right/10);
    }
    //review
    public static boolean isPanlindrome(int x){
        if(x == 0){
            return true;
        }
        if(x < 0 || x % 10 == 0){
            return false;
        }
        int   rightNumber = 0;
        while(x > rightNumber){
            rightNumber = rightNumber*10 + (x%10);
            x /=  10;
        }
        return x == rightNumber || x == (rightNumber/10);

    }
}
