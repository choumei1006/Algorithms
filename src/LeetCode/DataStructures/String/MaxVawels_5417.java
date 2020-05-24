package LeetCode.DataStructures.String;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author:choumei
 * @date:2020/5/24 11:39
 * @Description: 【定长子串中元音的最大数目】
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
public class MaxVawels_5417 {
    @Test
    public void test(){
        System.out.println(maxVowels("tryhard", 4));
    }

    /**
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        HashSet<Character> VowelsList = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        if(null == s || s.length() == 0 || k > s.length()){
            throw new IllegalArgumentException("参数不合法！");
        }
        char[] sArr = s.toCharArray();
        int tmpCnt = 0;
        int l = 0, r = 0;
        for (int i = 0; i < k; i++) {
            if(VowelsList.contains(sArr[i])){
                tmpCnt++;
            }
        }
        int res = tmpCnt;
        r = k - 1;
        while(r < s.length() - 1){
            r++;
            l++;
            if(VowelsList.contains(sArr[r])){
                tmpCnt++;
            }
            if(VowelsList.contains(sArr[l - 1])){
                tmpCnt--;
            }
            if(tmpCnt > res){
                res = tmpCnt;
            }

        }
        return res;
    }
}
