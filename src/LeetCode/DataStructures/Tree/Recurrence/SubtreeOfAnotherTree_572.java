package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/22 20:02
 * @Description: 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 */
public class SubtreeOfAnotherTree_572 {
    public static void main(String[] args) {
        TreeNode s = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3,4,5,1,null,2}));
        TreeNode t = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3,1,2}));
        System.out.println(isSubtree(s,t));
    }

    /**
     * 判断s树是否存在与t相同的子树
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s,TreeNode t){
        if(null == s || null == t){
            if(s == t) return true;
            return false;
        }
        return isSametree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    /**
     * 判断两树相等
     * @param s
     * @param t
     * @return
     */
    public static boolean isSametree(TreeNode s,TreeNode t){
        if(null == s || null == t){
            if(s == t) return true;
            return false;
        }
        if(s.val != t.val) return false;
        return isSametree(s.left,t.left) && isSametree(s.right,t.right);
    }
}
