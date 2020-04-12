package LeetCode.ClassicalThinking.KMP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/12 11:00
 * @Description: 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * 示例 2：
 *
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * 示例 3：
 *
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] 仅包含小写英文字母。
 * 题目数据 保证 每个 words[i] 都是独一无二的。
 */
public class WordsMatch_5380 {
    @Test
    public void test(){
        System.out.println(stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}).toString());
    }
    public List<String> stringMatching(String[] words){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(j != i && words[j].length() > words[i].length() && kmpSearch(words[j],words[i]) && !res.contains(words[i])){
                    res.add(words[i]);
                }
            }
        }
        return res;
    }
    public boolean kmpSearch(String s, String p){
        //特判
        if(null == s || null == p ){
            return false ;
        }
        //获取字符数组
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        //获取next数组
        int[] next = buildNext(pArray);

        int i = 0;    //主串指针
        int j = 0;    //模式串指针

        while(i < s.length()){
            if(sArray[i] == pArray[j]){
                i++;
                j++;
            }else if(j != 0){
                j = next[j-1];
            }else{
                i++;
            }

            //判断是否找到目标串
            if(j == p.length()){
                /*System.out.println("找到子串位置："+(i - j));*/
                return true;
                //j = next[j-1];
            }
        }
        return false;
    }

    public int[] buildNext(char[] pattern){
        //初始化结果
        int[] res = new int[pattern.length];

        int i = 1;   //当前所求位置下标
        int now = res[i-1];    //当前位置之前最长公共前后缀长度

        while(i < pattern.length){
            if(pattern[i] == pattern[now]){
                res[i] = ++now;
                i++;
            }else if(now != 0){
                now = res[now-1];
            }else{
                res[i] = now;   //0
                i++;
            }
        }
        return res;
    }
}
