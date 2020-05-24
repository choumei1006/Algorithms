package LeetCode.DataStructures.Tree.Trie;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author:choumei
 * @date:2020/5/24 10:49
 * @Description: 【检查单词是否为句中其他单词的前缀】
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 *
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 *
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 * 示例 2：
 *
 * 输入：sentence = "this problem is an easy problem", searchWord = "pro"
 * 输出：2
 * 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
 * 示例 3：
 *
 * 输入：sentence = "i am tired", searchWord = "you"
 * 输出：-1
 * 解释："you" 不是句子中任何单词的前缀。
 * 示例 4：
 *
 * 输入：sentence = "i use triple pillow", searchWord = "pill"
 * 输出：4
 * 示例 5：
 *
 * 输入：sentence = "hello from the other side", searchWord = "they"
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * 前缀就是紧密附着于词根的语素，中间不能插入其它成分，
 * 并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ）
 *
 */
public class IsPrefixOfWord_5416 {
    @Test
    public void test(){
        System.out.println(isPrefixOfWord(
                "google google i i pillow corona donald i love pillow they",
                "pillo"));
    }

    /**
     *
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord){
        if(null == sentence || null == searchWord){
            throw new IllegalArgumentException("字符串参数不合法！");
        }
        String[] stces = sentence.split(" ");   //单词数组
        Trie trie = new Trie();
        for(String s : stces){
            trie.insert(s);
        }
        //search
        return trie.search(searchWord);
    }

    //自定义前缀树
    class Trie {
        private class Node{
            public boolean isWord;
            public int ownerIdx;
            public Map<Character, Node> next;

            public Node(Boolean isWord){
                this.isWord = isWord;
                this.next = new TreeMap<>();
            }
            public Node(){
                this(false);
            }
        }


        private Node root;
        //private int size;
        private int lastNodeIdx;

    /*public int getSize(){
        return size;
    }*/

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node();
            lastNodeIdx = 1;
            //this.size = 0;

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node curNode = this.root;
            char[] charArr = word.toCharArray();
            for(char c : charArr){
                boolean isNew = false;
                if(null == curNode.next.get(c)){
                    curNode.next.put(c,new Node());
                    isNew = true;
                }
                curNode = curNode.next.get(c);
                if(isNew){
                    curNode.ownerIdx = lastNodeIdx;
                }
            }
            lastNodeIdx ++;
            if(!curNode.isWord){
                curNode.isWord = true;
                /*curNode.ownerIdx = lastNodeIdx + 1;*/
                //size++;
            }

        }

        /** Returns if the word is in the trie. */
        public int search(String word) {
            Node cur = root;
            int res = -1;
            char[] charArr = word.toCharArray();
            for(char c : charArr){
                if(null == cur.next.get(c))  return -1;
                cur = cur.next.get(c);
            }
            return cur.ownerIdx;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            char[] charArr = prefix.toCharArray();
            for(char c : charArr){
                if(null == cur.next.get(c)){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }

}


