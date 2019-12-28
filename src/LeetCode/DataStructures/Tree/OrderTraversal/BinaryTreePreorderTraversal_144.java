package LeetCode.DataStructures.Tree.OrderTraversal;

import PublicClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/28 10:47
 * @Description: 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 */
public class BinaryTreePreorderTraversal_144 {
    public static  List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] list = {1,null,2,null,null,3};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        List<Integer> result = preorderTraversal2(tree);
        for(Integer i:result){
            System.out.print(i+"\t");
        }
    }

    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> result2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(null == cur) continue;
            result2.add(cur.val);
             stack.push(cur.right);
            stack.push(cur.left);
        }
        return result2;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root){
        preorderTraversalRecurrence(root);
        return result;
    }
    public static void preorderTraversalRecurrence(TreeNode root){
        if(null == root) return ;
        result.add(root.val);
        if(null != root.left)   preorderTraversalRecurrence(root.left);
        if(null != root.right)  preorderTraversalRecurrence(root.right);
    }
}
