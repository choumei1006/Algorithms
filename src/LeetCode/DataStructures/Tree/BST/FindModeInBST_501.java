package LeetCode.DataStructures.Tree.BST;

import PublicClasses.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/1/2 13:47
 * @Description: 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
public class FindModeInBST_501 {
    public static void main(String[] args) {
        Integer[] list = {2147483647};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        int[] result = findMode(tree);
        for(int i : result){
            System.out.print(i+"\t");
        }
    }
    private static int curCnt = 1;
    private static int maxCnt = 1;
    private static TreeNode preNode = null;

    /**
     * 获取众数（出现次数最多的节点值）
     * @param root
     * @return int[] （众数可能有多个）
     */
    public static int[] findMode(TreeNode root){
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        int[] resultArray = new int[nums.size()];
        int index= 0;
        for(int i : nums){
            resultArray[index++] = i;
        }
        return resultArray;
    }

    /**
     * 中序遍历过程中，更新众数数组
     * @param root
     * @param nums
     */
    public static void inorder(TreeNode root,List<Integer> nums){
        if(null == root) return;
        inorder(root.left,nums);
        if(null != preNode){
            if(preNode.val == root.val)  curCnt++;
            else curCnt = 1;
        }
        if(curCnt > maxCnt){
            maxCnt = curCnt;
            nums.clear();
            nums.add(root.val);
        }else if(curCnt == maxCnt){
            nums.add(root.val);
        }
        preNode = root;
        inorder(root.right,nums);
    }
}
