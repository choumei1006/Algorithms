package LeetCode.DataStructures.String;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author:choumei
 * @date:2020/1/11 22:32
 * @Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 */
public class LongestPalindrome_409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abccccdd"));

    }

    /**
     * 方法一：
     * @param s
     * @return
     */
    public static int longestPalindrome1(String s){
        int longestLen = 0;
        char[] charArr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char tempChar : charArr){
            map.put(tempChar,map.getOrDefault(tempChar,0)+1);
        }
        //方法一：
        /*for(Entry<Character,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(value/2 > 0){
                longestLen += (value/2)*2;
            }
        }*/
        //方法二：
        for(char tempChar : map.keySet()){
            if(map.get(tempChar)/2 > 0){
                longestLen += (map.get(tempChar)/2)*2;
            }
        }
        return longestLen += (longestLen == s.length() ? 0 : 1);
    }

    //review
    public int longestPalindrome_repeat(String s){
        int longestLen = 0;   //最长回文串长度
        HashMap<Character,Integer> map = new HashMap<>();    //<字符，出现的次数>
        //遍历字符串所有字符
        for(char tempChar : s.toCharArray()){
            map.put(tempChar,map.getOrDefault(tempChar,0)+1);
        }
        //遍历map表
        for(char tempChar : map.keySet()){
            if(map.get(tempChar) / 2 > 0){
                longestLen += (map.get(tempChar)/2)*2;
            }
        }
        return longestLen += (longestLen == s.length() ? 0 :1);
    }

    /**
     * 方法二：
     * @param s
     * @return
     */
    public static int longestPalindrome2(String s){
        int[] count = new int[128];
        char[] sArray = s.toCharArray();
        for(char c : sArray){
            count[c]++;
        }
        int oddLen = 0;
        for(int temp : count){
            oddLen+=temp%2;
        }
        return oddLen == 0 ? s.length() : s.length()-oddLen+1;
    }
}
