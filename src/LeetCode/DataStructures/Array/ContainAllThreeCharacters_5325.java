package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/23 0:35
 * @Description: 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
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
public class ContainAllThreeCharacters_5325 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaaabc"));
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
}
