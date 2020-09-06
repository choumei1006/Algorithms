package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/26 19:56
 * @Description: 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 */
public class SecondMinimunNodeInABinaryTree_671 {
    public static void main(String[] args) {
        Integer[] list = {1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(findSecondMinimumValue2(tree));
    }
    public static int findSecondMinimumValue2(TreeNode root){
        if(null == root || null == root.left) return -1;
        int rootVal = root.val;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if(leftVal == rootVal) leftVal = findSecondMinimumValue2(root.left);
        if(rightVal == rootVal) rightVal = findSecondMinimumValue2(root.right);
        if(leftVal != -1 && rightVal != -1) return Math.min(leftVal,rightVal);
        if(leftVal == -1) return rightVal;
        return leftVal;
    }

    /**
     * 自解：存在冗余逻辑
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode root){
        if(null == root || null == root.left) return -1;
        int rootVal = root.val;
        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if(leftVal != rootVal  && rightVal != rootVal)  return Math.min(leftVal,rightVal);
        if(leftVal == rootVal && rightVal == rootVal ){
            int secMinLeft = findSecondMinimumValue(root.left);
            int secMinRight = findSecondMinimumValue(root.right);
            if(-1 == secMinLeft && -1 == secMinRight) return -1;
            if(-1 != secMinLeft && -1 != secMinRight) return Math.min(secMinLeft,secMinRight);
            return -1 == secMinLeft ? secMinRight : secMinLeft;
        }
        if(leftVal == rootVal){
            int secMinLeft = findSecondMinimumValue(root.left);
            return (-1 == secMinLeft) ? rightVal : Math.min(secMinLeft,rightVal);
        }
        int secMinRight = findSecondMinimumValue(root.right);
        return (-1 == secMinRight) ? leftVal : Math.min(secMinRight,leftVal);

    }

    //====================================2020-08-23 自测=======================================
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{2, 2, 5, null, null, 5, 7}));
        System.out.println(findSecondMinimumValue4(root));
    }

    /**
     * 方法一：分支存在冗余逻辑
     * @param root
     * @return
     */
    public int findSecondMinimumValue3(TreeNode root) {
        //特判
        if (null == root || null == root.left) {
            return -1;
        }

        int rootVal = root.val;
        int leftVal = root.left.val;
        int rightVal = root.right.val;

        //左右子节点不同于根节点
        if(rootVal != leftVal && rootVal != rightVal){
            return Math.min(leftVal, rightVal);
        }

        //左右子树=根节点
        if(rootVal == leftVal && rootVal == rightVal){
            int leftSecMin = findSecondMinimumValue3(root.left);
            int rightSecMin = findSecondMinimumValue3(root.right);
            if(leftSecMin == -1 && rightSecMin == -1){
                return -1;
            }
            else if(leftSecMin != -1 && rightSecMin != -1){
                return Math.min(leftSecMin, rightSecMin);
            }
            else{
                return leftSecMin == -1 ? rightSecMin : leftSecMin;
            }
        }

        //左子树 = 根节点
        if(rootVal == leftVal){
            int leftSecMin = findSecondMinimumValue3(root.right);
            return leftSecMin == -1 ? rightVal : Math.min(leftSecMin, rightVal);
        }

        //右子树 = 根节点
        int rightSecMin = findSecondMinimumValue3(root.right);
        return rightSecMin == -1 ? leftVal : Math.min(leftVal, rightSecMin);
    }


    /**
     * 方法二：精简逻辑
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue4(TreeNode root) {
        //特判
        if (null == root || null == root.left) {
            return -1;
        }

        int rootVal = root.val;
        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if(leftVal == rootVal){
            leftVal = findSecondMinimumValue4(root.left);
        }
        if(rightVal == rootVal){
            rightVal = findSecondMinimumValue4(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        return leftVal == -1 ? rightVal : leftVal;
    }
}
