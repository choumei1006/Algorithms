package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/13 23:22
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class LongestPalindromicSubString_5 {
    public static void main(String[] args) {
        System.out.println("最长回文子串："+longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s){
        if(null == s || s.length() <= 0){
            return s;
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandedPalindrome(s,i,i);    //以当前字符为中心的回文子串数
            int len2 = expandedPalindrome(s,i,i+1);  //以当前字符右侧间隙为中心的回文子串数
            int tempLen = Math.max(len1,len2);
            if(tempLen > maxLen ){
                start = i - (tempLen-1)/2;
                end = i + tempLen/2;
                maxLen = tempLen;
            }
        }
        return s.substring(start,end+1);
    }

    public static int expandedPalindrome(String s,int start,int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;     // = ((end-1)-(start+1))+1   = (end-1-start-1)+1  = end-start-1
    }
}
