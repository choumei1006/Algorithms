package leetCode.DataStructures.Tree.BST;

import publicClasses.TreeNode;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/29 19:46
 * @Description: 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class KthSmallestElementInBST_230 {
    private static  int index = 0;
    private static  int kthVal;
    public static void main(String[] args) {
        Integer[] list = {5,3,6,2,4,null,null,1};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(kthSmallest3(tree,3));
    }

    /**
     * 方法一：递归-中序遍历
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest1(TreeNode root,int k){
        dfs(root,k);
        return kthVal;
    }
    public static void dfs(TreeNode root,int k){
        if(null == root) return;
        dfs(root.left,k);
        index++;
        if(index == k){
            kthVal = root.val;
            return;
        }
        dfs(root.right,k);
    }

    /**
     * 方法二：非递归-中序遍历
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest2(TreeNode root,int k){
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(null != cur || !s.isEmpty()){
            while(null != cur){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            count++;
            if(count == k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

    /**
     * 方法三：递归计数法
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest3(TreeNode root,int k){
        int leftCount = count(root.left);
        if(leftCount == k-1) return root.val;
        if(leftCount > k-1) return kthSmallest3(root.left,k);
        return kthSmallest3(root.right,k-leftCount-1);
    }

    public static int count(TreeNode root){
        if(null == root) return 0;
        return count(root.left)+count(root.right)+1;
    }

}
