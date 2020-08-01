package LeetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/2/23 0:35
 * @Description: 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 * 示例 1：
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为
 * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc"
 * (相同字符串算多次)。
 *
 *
 * 示例 2：
 *
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：1
 *
 *
 * 提示：
 *
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 */
public class ContainAllThreeCharacters_1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
    public static int numberOfSubstrings(String s) {
        int n=s.length();
        int a=-1,b=-1,c=-1;
        int Ans=0;
        for (int i=0;i<n;++i)
            if (s.charAt(i)=='a')
            {
                int p=Math.min(b,c);
                a=i;
                Ans+=p+1;
            }
            else if (s.charAt(i)=='b')
            {
                int p=Math.min(a,c);
                b=i;
                Ans+=p+1;
            }
            else
            {
                int p=Math.min(a,b);
                c=i;
                Ans+=p+1;
            }
        return Ans;
    }

    @Test
    public void test(){
        System.out.println(numberOfSubstrings2("aaaabcc"));
    }

    /**
     * 思路：逐一判断所有字符，rst + 其余两个字符最小索引 + 1
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings2(String s) {
        //特判
        if (null == s || s.length() == 0) {
            return 0;
        }

        int rst = 0;   //结果
        int aIdx = -1, bIdx = -1, cIdx = -1;

        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            if(s.charAt(i) == 'a'){
                int lowRange = Math.min(bIdx, cIdx);
                aIdx = i;
                rst += lowRange + 1;
            }else if(s.charAt(i) == 'b'){
                int lowRange = Math.min(aIdx, cIdx);
                bIdx = i;
                rst += lowRange + 1;
            }else if(s.charAt(i) == 'c'){
                int lowRange = Math.min(aIdx, bIdx);
                cIdx = i;
                rst += lowRange + 1;
            }
        }
        return rst;
    }
}
