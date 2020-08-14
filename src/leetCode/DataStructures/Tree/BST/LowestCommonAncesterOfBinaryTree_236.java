package leetCode.DataStructures.Tree.BST;

import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/30 20:39
 * @Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class LowestCommonAncesterOfBinaryTree_236 {
    public static void main(String[] args) {
        Integer[] list = {3,5,1,6,2,0,8,null,null,7,4,null,null,null,null};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        Integer[] sonList1 = {6,null,null};
        TreeNode sonTree1 = TreeNode.initTree(TreeNode.initTreeNodeList(sonList1));
        Integer[] sonList2 = {0,null,null};
        TreeNode sonTree2 = TreeNode.initTree(TreeNode.initTreeNodeList(sonList2));

        TreeNode result = lowestCommonAncestor(tree,sonTree1,sonTree2);
        TreeNode.printTree(result);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(null == root || root.val == p.val || root.val == q.val) return root;
        TreeNode leftRst = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRst = lowestCommonAncestor(root.right,p,q);
        return null == leftRst ? rightRst : null == rightRst ? leftRst : root;
    }

    //自测

    /**
     * 返回root二叉树中的p,q节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(null == root || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode leftRst = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightRst = lowestCommonAncestor2(root.right, p, q);
        return null == leftRst ? rightRst : null == rightRst ? leftRst : root;
    }

}
