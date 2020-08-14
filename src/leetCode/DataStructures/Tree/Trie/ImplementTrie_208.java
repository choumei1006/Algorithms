package leetCode.DataStructures.Tree.Trie;

/**
 * @author:choumei
 * @date:2020/1/2 17:21
 * @Description: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 */
public class ImplementTrie_208 {
    public static void main(String[] args) {

        Trie trie = new Trie();

        System.out.println(trie.search("apple"));   // 返回 false
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 true
        System.out.println(trie.search("app"));  // 返回 false
        System.out.println(trie.startsWith("app"));   // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 true
    }
}
