package leetCode.DataStructures.Tree.Recurrence;

import publicClasses.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:choumei
 * @date:2019/12/26 10:23
 * @Description: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 */
public class HouseRobberIII_337 {
    private static int maxMoney;
    public static void main(String[] args) {
        Integer[] list = {3,2,3,null,3,null,1};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(rob4(tree));
    }

    /**
     * 终极解法：
     * 用一个int[2]表示一个节点偷与不偷时的最大偷盗数情况：
     * int[0]：本节点不偷时，最大偷盗数 = 左右子节点能偷到的最大数之和（不管左右子节点自己偷不偷）；
     * int[1]：本节点偷时，最大偷盗数 = 左右子节点不偷时的最大偷盗数之和；
     * @param root
     * @return
     */
    public static int rob4(TreeNode root){
        int[] result = robInternal4(root);
        return Math.max(result[0],result[1]);
    }
    public static int[] robInternal4(TreeNode root){
        if(null == root) return new int[2];
        int[] resultList = new int[2];

        int[] leftlist = robInternal4(root.left);
        int[] rightList = robInternal4(root.right);

        resultList[0] = Math.max(leftlist[0],leftlist[1])+Math.max(rightList[0],rightList[1]);
        resultList[1] = root.val+leftlist[0]+rightList[0];

        return resultList;
    }

    /**
     * 记忆法：解决重复子问题
     * @param root
     * @return
     */
    public static int rob3(TreeNode root){
        HashMap<TreeNode,Integer> memo = new HashMap<>();
        return robInternal(root,memo);
    }
    public static int robInternal(TreeNode root,HashMap<TreeNode,Integer> memo){
        if(null == root) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int money1 = root.val;
        money1 += (null != root.left) ? robInternal(root.left.left,memo)+robInternal(root.left.right,memo) : 0;
        money1 += (null != root.right) ? robInternal(root.right.left,memo) + robInternal(root.right.right,memo) : 0;

        int money2 = robInternal(root.left,memo) + robInternal(root.right,memo);

        int result = Math.max(money1,money2);
        memo.put(root,result);

        return result;
    }
    /**
     * 暴力递归法
     * @param root
     * @return
     */
    public static int rob2(TreeNode root){
        if(null == root) return 0;
        int money1 = root.val;
        money1 += (null != root.left) ? rob2(root.left.left)+rob2(root.left.right) : 0;
        money1 += (null != root.right) ? rob2(root.right.left)+rob2(root.right.right) : 0;

        int money2 = rob2(root.left) + rob2(root.right);

        return Math.max(money1,money2);
    }

    /**
     * 自解：存在冗余逻辑
     * @param root
     * @return
     */
    public static int rob1(TreeNode root) {
        if (null == root) return 0;
        int temp_left = rob1(root.left);
        int temp_left_left = (null != root.left) ? rob1(root.left.left) : 0;
        int temp_left_right = (null != root.left) ? rob1(root.left.right) : 0;
        int temp_right = rob1(root.right);
        int temp_right_left = (null != root.right) ? rob1(root.right.left) : 0;
        int temp_right_right = (null != root.right) ? rob1(root.right.right) : 0;

        boolean ifLeftRootUsed = (temp_left == temp_left_left + temp_left_right) ? false : true;
        boolean ifRightRootUsed = (temp_right == temp_right_left + temp_right_right) ? false : true;

        if (ifLeftRootUsed || ifRightRootUsed) {
            return Math.max(temp_left + temp_right, root.val + temp_left_left + temp_left_right + temp_right_left + temp_right_right);
        }
        return root.val + temp_left + temp_right;
    }


    /**
     * 自测
     */
    @Test
    public void test(){

    }

    /**
     * 返回二叉树不相邻节点值之和的最大值
     * @param root
     * @return
     */
    public int rob5(TreeNode root){
        int[] res = rob5Helper(root);   //获取root根节点偷与不偷的最大获利值
        return Math.max(res[0], res[1]);
    }

    /**
     * 获取一个二叉树根节点偷与不偷的最大获利值数组
     * @param root
     * @return
     */
    public int[] rob5Helper(TreeNode root){
        //特判
        if(null == root){
            return new int[]{};
        }
        //获取左右子树计算结果数组
        int[] leftRes = rob5Helper(root.left);
        int[] rightRes = rob5Helper(root.right);

        int[] res = new int[2];
        //父节点不取时，左右子树可取可不取
        res[0] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        //父节点取时，左右子树不可取
        res[1] = root.val + leftRes[0] + rightRes[0];

        return res;
    }





    //=================================2020-08-23 自测====================================
    @Test
    public void test2(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3, 4, 5, 1, 3, null, 1}));
        System.out.println(rob8(root));
    }

    /**
     * 方法一：暴力递归
     * 获取二叉树间隔节点最大值
     * @param root
     * @return
     */
    public int rob6(TreeNode root){
        //特判
        if(null == root){
            return 0;
        }

        //根 + 孙
        int max1 = root.val;
        max1 += ( null != root.left ) ? rob6(root.left.left) + rob6(root.left.right) : 0;
        max1 += ( null != root.right ) ? rob6(root.right.left) + rob6(root.right.right) : 0;

        //子
        int max2 = rob6(root.left) + rob6(root.right);

        return Math.max(max1, max2);
    }

    /**
     * 方法二：记忆法（解决重复子问题）
     *
     * @param root
     * @return
     */
    public int rob7(TreeNode root) {
        //存放中间结果
        Map<TreeNode, Integer> memo = new HashMap<>();

        return rob7Helper(root, memo);
    }

    /**
     * 辅助类
     *
     * @param root
     * @param memo
     * @return
     */
    public int rob7Helper(TreeNode root, Map<TreeNode, Integer> memo) {
        //特判
        if (null == root) {
            return 0;
        }

        //查看是否有缓存记忆
        if(memo.containsKey(root)){
            return memo.get(root);
        }

        //没有缓存记忆
        int max1 = root.val;
        max1 += (null != root.left ) ? rob7Helper(root.left.left, memo) + rob7Helper(root.left.right, memo) : 0;
        max1 += (null != root.right ) ? rob7Helper(root.right.left, memo) + rob7Helper(root.right.right, memo) : 0;

        int max2 = rob7Helper(root.left, memo) + rob7Helper(root.right, memo);

        int rst = Math.max(max1, max2);
        memo.put(root, rst);

        return rst;
    }

    /**
     * 方法三：递归二
     * @param root
     * @return
     */
    public int rob8(TreeNode root){
        int[] rst = rob8Helper(root);
        return Math.max(rst[0], rst[1]);
    }

    /**
     * 辅助类
     * 功能:获取子树根节点偷与不偷时的最大值
     * 【0】：根节点不偷时最大值=左子树中的间隔偷最大值 + 右子树间隔偷的最大值（此时不管左右子树根节点是否偷）
     * 【1】：根节点偷时最大值 = 左子树不偷时最大值 + 右子树不偷时最大值
     *
     * @param root
     * @return
     */
    public int[] rob8Helper(TreeNode root) {
        //特判
        if (null == root) {
            return new int[2];
        }
        //递归
        int[] rst = new int[2];

        //左右子树【偷-不偷】结果集
        int[] leftRst = rob8Helper(root.left);
        int[] rightRst = rob8Helper(root.right);

        rst[0] = Math.max(leftRst[0], leftRst[1]) + Math.max(rightRst[0], rightRst[1]);
        rst[1] = root.val + leftRst[0] + rightRst[0];

        return rst;
    }




}
