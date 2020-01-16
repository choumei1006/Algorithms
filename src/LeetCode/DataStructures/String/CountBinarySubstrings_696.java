package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/16 22:36
 * @Description: 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 */
public class CountBinarySubstrings_696 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
    public static int countBinarySubstrings(String s){
        int preLen = 0,curLen = 1,count = 0;
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                curLen++;
            }else{
                preLen = curLen;
                curLen = 1;
            }
            if(preLen >= curLen){
                count++;
            }
        }
        return count;
    }
}
