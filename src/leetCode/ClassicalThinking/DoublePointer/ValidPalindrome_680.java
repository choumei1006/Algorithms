package leetCode.ClassicalThinking.DoublePointer;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2019/12/1 11:54
 * @Description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 */
public class ValidPalindrome_680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
    public static boolean validPalindrome(String s){
        for (int i = 0,j = s.length()-1; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)){
                return isValidPalindrome(s,i+1,j) || isValidPalindrome(s,i,j-1);
            }
        }
        return true;
    }
    public static boolean isValidPalindrome(String s ,int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        /*for (int k = i,p = j; k < p ; k++,p--) {
            if(s.charAt(k) != s.charAt(p)){
                return false;
            }
        }*/
        return true;
    }

    /**
     * 自测
     */
    @Test
    public void test(){
        System.out.println(validPalindrome2("asdfghjujhgfdsa"));
    }

    /**
     * 判断非空字符串是否能成为回文串，最多删除一个字符
     * 思路：双指针左右夹击判断是否两两相等，若遇到不相等的，删除一方当前字符，判断剩余子串是否构成回文串
     * @param s
     * @return
     */
    public boolean validPalindrome2(String s){
        if(null == s || s.length() == 0){
            return false;
        }
        /*int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return validPalindromeHelper(s, i + 1, j) || validPalindromeHelper(s, i, j - 1);
            }
            i++;
            j--;
        }*/
        for (int i = 0, j = s.length() - 1; i < j ; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                return validPalindromeHelper(s,i + 1, j) || validPalindromeHelper(s, i, j - 1);
            }
        }
        return true;
    }

    /**
     * 返回字符串中起止指针包含的子串是否是回文串
     * @param s 待查字符串
     * @param i 子串左指针
     * @param j 子串右指针
     * @return
     */
    public boolean validPalindromeHelper(String s, int i, int j){
        if(null == s || i > j){
            return false;
        }
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
