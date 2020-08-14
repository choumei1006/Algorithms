package leetCode.DataStructures.Tree.Trie;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author:choumei
 * @date:2020/3/28 11:39
 * @Description: 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#"
 * 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，
 * 来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *  
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 *
 * ["me", "time"]
 */
public class ShortEncodingWords_820 {
    @Test
    public void test(){
        System.out.println(minimumLengthEncoding2(new String[]{"me", "time"}));
    }

    /**
     * 方法一：KMP检索
     * @param words
     * @return
     */
    public int minimumLengthEncoding1(String[] words){
        if(null == words){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            String curStr = word+"#";
            if(curStr.length() > sb.toString().length()){
                if(kmpSearch(curStr,sb.toString()) > -1){
                    sb = new StringBuilder(curStr);
                }else{
                    sb.append(curStr);
                }
            }else{
                if(kmpSearch(sb.toString(),curStr) == -1){
                    sb.append(curStr);
                }
            }
        }
        return sb.toString().length();
    }

    //kmp查询单词在主串中的位置
    public int kmpSearch(String s, String p){
        if(s.length() == 0 || p.length() == 0){
            return -1;
        }
        int sLen = s.length();
        int pLen = p.length();

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] next = buildNext(pArr);

        int i = 0, j = 0;
        while(i < sLen){
            if(sArr[i] == pArr[j]){
                i++;
                j++;
            }else if(j != 0){
                j = next[j-1];
            }else{
                i++;
            }

            if(j == pLen){
                return i-j;
            }
        }
        return -1;
    }

    //创建next数组
    public int[] buildNext(char[] pArr){
        int pLen = pArr.length;
        int[] next = new int[pLen];
        next[0] = 0;
        int i = 1;
        int now = next[i-1];

        while(i < pLen){
            if(pArr[i] == pArr[now]){
                next[i++] = ++now;
            }else if(now != 0){
                now = next[now-1];
            }else{
                next[i++] = now;
            }
        }
        return next;
    }

    /**
     * 方法二：字典树（Trie)
     * @param words
     * @return
     */
    public int minimumLengthEncoding2(String[] words){
        if(null == words || words.length == 0){
            return 0;
        }
        int resLen = 0;
        Trie trie = new Trie();
        Arrays.sort(words,(w1,w2)->(w2.length()-w1.length()));
        for(String word : words){
            resLen += trie.insert(word) ? word.length()+1 : 0;
        }
        return resLen;
    }
    class Trie{
        private class TrieNode{
            public boolean isWord;   //标识以该节点为尾是否表示一个单词
            public TreeMap<Character,TrieNode> next;   //标识下一级节点

            //Constructor
            public TrieNode(boolean isWord){
                this.isWord = isWord;
                next = new TreeMap<>();
            }
            public TrieNode(){
                this(false);
            }
        }

        private TrieNode root;    //根节点

        //Constructor
        public Trie(){
            root = new TrieNode();
        }

        /**
         * 插入单词，返回是否是新单词
         * @param word
         * @return
         */
        public boolean insert(String word){
            TrieNode curNode = root;
            boolean isNewNode = false;
            for(int i = word.length()-1; i >= 0; i--){
                char c = word.charAt(i);
                if(null == curNode.next.get(c)){
                    isNewNode = true;
                    curNode.next.put(c,new TrieNode());
                }
                curNode = curNode.next.get(c);
            }
            return isNewNode;
        }

        /**
         * 查找单词
         * @param word
         * @return
         */
        public boolean search(String word){
            TrieNode cur = root;
            for(int i = word.length()-1; i >= 0; i--){
                char c = word.charAt(i);
                if(null == cur.next.get(c)){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean isStartWith(String prefix){
            TrieNode cur = root;
            for(int i = prefix.length()-1; i >= 0; i--){
                char c = prefix.charAt(i);
                if(null == cur.next.get(c)){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
