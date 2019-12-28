package LeetCode.DataStructures.Tree.OrderTraversal;

import PublicClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/28 16:59
 * @Description: 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class BinaryTreeInorderTraversal_94 {
    private static  List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] list = {1,null,2,null,null,3,null};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        List<Integer> result = inorderTraversal2(tree);
        for(int i : result){
            System.out.print(i+"\t");
        }
    }
    public static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result2 = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(null != p || !s.isEmpty()){
            while(null != p){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            result2.add(p.val);
            p = p.right;
        }
        return result2;
    }

    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root){
        inorderTraversalRecurrence(root);
        return result;
    }
    public static void inorderTraversalRecurrence(TreeNode root){
        if(null == root) return;
        inorderTraversalRecurrence(root.left);
        result.add(root.val);
        inorderTraversalRecurrence(root.right);
    }

}
