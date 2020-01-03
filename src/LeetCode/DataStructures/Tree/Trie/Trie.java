package LeetCode.DataStructures.Tree.Trie;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author:choumei
 * @date:2020/1/3 10:01
 * @Description:
 *   Your Trie object will be instantiated and called as such:
 *   Trie obj = new Trie();
 *   obj.insert(word);
 *   boolean param_2 = obj.search(word);
 *   boolean param_3 = obj.startsWith(prefix);
 */


public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

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

    /*public int getSize(){
        return size;
    }*/

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
        //this.size = 0;

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curNode = this.root;
        char[] charArr = word.toCharArray();
        for(char c : charArr){
            if(null == curNode.next.get(c)){
                curNode.next.put(c,new Node());
            }
            curNode = curNode.next.get(c);
        }
        if(!curNode.isWord){
            curNode.isWord = true;
            //size++;
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        char[] charArr = word.toCharArray();
        for(char c : charArr){
            if(null == cur.next.get(c))  return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
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
