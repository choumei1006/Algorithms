package LeetCode.DataStructures.Tree.BST;

import PublicClasses.ListNode;
import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/31 10:29
 * @Description: 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class ConvertSortedListToBST_109 {
    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        ListNode list = ListNode.initListByArray(array);
        TreeNode result = sortedListToBST(list);
        TreeNode.printTree(result);
    }

    /**
     * 生成一个BST
     * @param head : 有序递增链表
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head){
        if(null == head) return null;
        if(null == head.next) return new TreeNode(head.val);
        ListNode preMid = getPreMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode rst = new TreeNode(mid.val);
        rst.left = sortedListToBST(head);
        rst.right = sortedListToBST(mid.next);

        return rst;
    }

    /**
     * 获取链表中间节点的前一个节点
     * @param head
     * @return
     */
    public static ListNode getPreMid(ListNode head){
        ListNode slow = head,fast = head.next;
        ListNode preMid = head;
        while(null != fast && null != fast.next){ //防止空指针:null.next
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preMid;
    }

}
