package LeetCode.DataStructures.Tree.BST;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/29 16:41
 * @Description: 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 */
public class TrimBinarySearchTree_669 {
    public static void main(String[] args) {
        //Integer[] list = {3,0,4,null,2,null,null,null,null,1,null};
        Integer[] list = {1,0,2};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        TreeNode resultTree = trimBST2(tree,1,3);
        TreeNode.printTree(tree);
    }

    /**
     * 方法二：精简逻辑
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static TreeNode trimBST2(TreeNode root,int L,int R){
        if(null == root) return null;
        if(root.val > R) return trimBST2(root.left,L,R);
        if(root.val < L) return trimBST2(root.right,L,R);
        root.left = trimBST2(root.left,L,R);
        root.right = trimBST2(root.right,L,R);
        return root;
    }

    /**
     * 方法一：存在冗余逻辑
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static TreeNode trimBST(TreeNode root,int L,int R){
        if(null == root) return null;
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        if(root.val < L || root.val > R){
            root = deleteRoot(root);
        }
        return root;

    }
    public static TreeNode deleteRoot(TreeNode root){
        if(null == root.left || null == root.right){
            root = (null == root.left) ? root.right : root.left;
        }else{
            TreeNode lrNode = root.left;
            while(null != lrNode.right){
                lrNode = lrNode.right;
            }
            root.val = lrNode.val;
            lrNode = deleteRoot(lrNode);
        }
        return root;
    }
}
