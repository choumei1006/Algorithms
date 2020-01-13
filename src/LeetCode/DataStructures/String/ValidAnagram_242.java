package LeetCode.DataStructures.String;

import java.util.HashMap;

/**
 * @author:choumei
 * @date:2020/1/10 21:52
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram2("asdfghj","jhgfdsa"));
    }

    /**
     * 方法一：数组存储字符出现的次数,S和t相互制衡
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s,String t){
        int[] cnt = new int[26];
        for(char temp : s.toCharArray()){
            cnt[temp-'a']++;
        }
        for(char temp : t.toCharArray()){
            cnt[temp - 'a']--;
        }
        for(int i : cnt){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * HashMap存储数组中字符的出现次数，两次遍历相互制衡
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char temp : s.toCharArray()){
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(char temp : t.toCharArray()){
            map.put(temp,map.getOrDefault(temp,0)-1);
        }
        for(Integer cnt : map.values()){
            if(cnt != 0){
                return false;
            }
        }
        return true;
    }



}
