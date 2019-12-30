package LeetCode.DataStructures.Tree.BST;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/30 21:29
 * @Description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class ConvertSortedArrayToBST_108 {
    public static void main(String[] args) {
        int[] list = {-10,-3,0,5,9};
        TreeNode tree = convertArrayToBST(list);
        TreeNode.printTree(tree);
    }
    public static TreeNode convertArrayToBST(int[] nums){
        return convertArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode convertArrayToBST(int[] nums,int i,int j){
        if(i>j) return null; //谨防栈溢出：i=0,j=1    mid=0  left = cvt(nums,0,-1);  right = cvt(nums,1,1);
        int midIdx = (j+i)/2;
        TreeNode root = new TreeNode(nums[midIdx]);
        root.left = convertArrayToBST(nums,i,midIdx-1);
        root.right = convertArrayToBST(nums,midIdx+1,j);
        return root;
    }
}
