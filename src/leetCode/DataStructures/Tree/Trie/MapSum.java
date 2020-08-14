package leetCode.DataStructures.Tree.Trie;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

/**
 * @author:choumei
 * @date:2020/1/3 16:29
 * @Description:
 *    Your MapSum object will be instantiated and called as such:
 *  * MapSum obj = new MapSum();
 *  * obj.insert(key,val);
 *  * int param_2 = obj.sum(prefix);
 */
public class MapSum {
    private class Node{
        public int value;
        public TreeMap<Character,Node> next;

        public Node(){
            this.next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        char[] charArr = key.toCharArray();
        for(char c : charArr){
            if(null == cur.next.get(c)){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        return sum(prefix,root);
    }
    public int sum(String prefix,Node node){
        Node cur = node;
        char[] charArr = prefix.toCharArray();
        for(char c : charArr){
            if(null == cur.next.get(c)){
                return 0;
            }
            cur = cur.next.get(c);
        }
        int sum = cur.value;
        for(Node n : cur.next.values()){
            sum += sum("",n);
        }
        return sum;
    }
}
