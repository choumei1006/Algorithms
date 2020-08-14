package leetCode.DataStructures.Tree.Trie;

/**
 * @author:choumei
 * @date:2020/1/3 16:28
 * @Description: 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 */
public class MapSumPairs_677 {
    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("appla",3);
        ms.insert("applb",2);
        ms.insert("applc",1);
        ms.insert("app",4);
        System.out.println(ms.sum("app"));
    }
}
