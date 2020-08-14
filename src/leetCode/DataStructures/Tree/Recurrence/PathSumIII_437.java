package leetCode.DataStructures.Tree.Recurrence;

import publicClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2019/12/20 22:29
 * @Description: 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */
public class PathSumIII_437 {
    public static void main(String[] args) {
        Integer[] list = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(pathSum(tree,8));
    }

    public static int pathSum(TreeNode root,int sum){
        if(null == root) return 0;
        return pathSumStartWithRoot(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public static int pathSumStartWithRoot(TreeNode root,int sum){
        if(null == root ) return 0;
        int count = 0;
        if(root.val == sum) count+=1;
        return count+pathSumStartWithRoot(root.left,sum-root.val)+pathSumStartWithRoot(root.right,sum-root.val);
    }
}
