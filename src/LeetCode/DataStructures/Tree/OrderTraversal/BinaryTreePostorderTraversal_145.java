package LeetCode.DataStructures.Tree.OrderTraversal;

import PublicClasses.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/28 12:05
 * @Description: 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class BinaryTreePostorderTraversal_145 {
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] list = {1,null,2,null,null,3,null};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        List<Integer> result = postorderTraversal2(tree);
        for(int i : result){
            System.out.print(i+"\t");
        }
    }
    public static List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> result2 = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            if(null == cur) continue;
            result2.add(cur.val);
            s.push(cur.left);
            s.push(cur.right);
        }
        Collections.reverse(result2);
        return result2;
    }

    /**
     * 方法一:递归
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root){
        postorderTraversalCurrence(root);
        return result;
    }
    public static void postorderTraversalCurrence(TreeNode root){
        if(null == root) return ;
        if(null != root.left) postorderTraversalCurrence(root.left);
        if(null != root.right) postorderTraversalCurrence(root.right);
        result.add(root.val);
    }
}
