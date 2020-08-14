package leetCode.DataStructures.Tree.BST;

import publicClasses.TreeNode;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/29 20:36
 * @Description: 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 */
public class ConvertBSTToGreaterTree_538 {
    private static int sum = 0;
    public static void main(String[] args) {
        Integer[] list = {2,1,3};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        TreeNode.printTree(convertBST2(tree));
    }

    /**
     * 方法一:非递归 逆-中序遍历
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root){
        int addVal = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(null != cur || !s.isEmpty()){
            while(null != cur){
                s.push(cur);
                cur = cur.right;
            }
            cur = s.pop();
            int curVal = cur.val; //因后边要对cur.val进行修改，所以先将cur.val保存起来
            cur.val += addVal;
            addVal += curVal;
            cur = cur.left;
        }
        return  root;
    }

    /**
     * 方法二：递归 逆-中序 遍历
     * @param root
     * @return
     */
    public static TreeNode convertBST2(TreeNode root){
        traver(root);
        return root;
    }
    public static void traver(TreeNode root){
        if(null == root) return ;
        traver(root.right);
        sum += root.val;
        root.val = sum;
        traver(root.left);
    }
}
