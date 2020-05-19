package LeetCode.ClassicalThinking.DoublePointer;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/19 8:53
 * @Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class ValidPalindrome_125 {
    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 判断某字符串是否是回文串
     * 方法一：内置api
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        if(s.length() == 0){
            return true;
        }
        //变小写->正则替换
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));

        //反转判断
        return sb.toString().equals(sb.reverse().toString());
    }
}
