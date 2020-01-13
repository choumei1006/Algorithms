package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/13 10:24
 * @Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 */
public class PalindromicSubStrings_647 {
    public static void main(String[] args) {
        System.out.println("回文子串个数:"+countSubstrings("aaa"));
    }

    /**
     * 计算一个字符串的回文子串个数
     * @param s
     * @return
     */
    private static int total = 0;
    public static int countSubstrings(String s){
        for (int i = 0; i <s.length() ; i++) {
            getPalindromeStrCnt(s,i,i);
            getPalindromeStrCnt(s,i,i+1);
        }
        return total;
    }

    /**
     * 从字符串中[start,end]位置为中心计回文个数
     * @param str
     * @param start
     * @param end
     */
    public static void getPalindromeStrCnt(String str,int start,int end){
        while(start >= 0 && end <str.length() && (str.charAt(start) == str.charAt(end))){
            start--;
            end++;
            total++;
        }
    }
}
