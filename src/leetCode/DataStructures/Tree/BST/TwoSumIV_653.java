package leetCode.DataStructures.Tree.BST;

import publicClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2019/12/31 21:54
 * @Description:
 * 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，
 * 则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 */
public class TwoSumIV_653 {
    public static void main(String[] args) {
        Integer[] list = {5,3,6,2,4,null,7};
        TreeNode treeBST = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(findTarget(treeBST,28));
    }

    /**
     * 判断BST中是否存在两个节点的值之和为target值
     * 1、通过中序遍历获取BST的中序遍历数组
     * 2、双指针查找数组中是否存在两个数值之和等于target
     * @param root
     * @param target
     * @return
     */
    public static boolean findTarget(TreeNode root,int target){
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root,list);
        int i = 0,j = list.size()-1;
        while(i<j){
            int sum = list.get(i)+list.get(j);
            if(sum == target) return true;
            if(sum > target) j--;
            else i++;
        }
        return false;
    }

    /**
     * 中序遍历BST
     * @param root
     * @param list
     */
    public static void inOrderTraversal(TreeNode root,List<Integer> list){
        if(null == root) return;
        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);
    }
}
