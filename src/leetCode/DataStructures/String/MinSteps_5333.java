package leetCode.DataStructures.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/2/9 10:47
 * @Description: 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 *
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 *
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 *
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 *
 * 输出：s = "friend", t = "family"
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s 和 t 只包含小写英文字母
 */
public class MinSteps_5333 {
    public static void main(String[] args) {
        System.out.println(minSteps2("friend","family"));
    }

    /**
     * 方法二：
     * @param s
     * @param t
     * @return
     */
    public static int minSteps2(String s,String t){
        int[] counts = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            int sChar = s.charAt(i),tChar = t.charAt(i);
            counts[sChar-'a']++;
            counts[tChar-'a']--;
        }
        int steps = 0;
        for (int i = 0; i < counts.length ; i++) {
            if(counts[i] > 0){
                steps += counts[i];
            }
        }
        return steps;
    }
    /**
     * 方法一：
     * @param s
     * @param t
     * @return
     */
    public static int minSteps1(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            char tempChar = s.charAt(i);
            sMap.put(tempChar,sMap.getOrDefault(tempChar,0)+1);
        }
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length() ; i++) {
            char tempChar = t.charAt(i);
            tMap.put(tempChar,tMap.getOrDefault(tempChar,0)+1);
        }
        List<Map.Entry<Character,Integer>> sEntryList = new ArrayList<>(sMap.entrySet());
        List<Map.Entry<Character,Integer>> tEntryList = new ArrayList<>(tMap.entrySet());

        sEntryList.removeAll(tEntryList);
        int rstCnt = 0;
        for (int i = 0; i < sEntryList.size() ; i++) {
            Integer tempNum = tMap.get(sEntryList.get(i).getKey());
            rstCnt += null == tempNum ? sEntryList.get(i).getValue() : tempNum < sEntryList.get(i).getValue() ? sEntryList.get(i).getValue() - tempNum   : 0;
        }
        return rstCnt;
    }
}
