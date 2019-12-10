package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/10 9:37
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        ListNode l_2 = new ListNode(2);
        ListNode l_3 = new ListNode(3);
        ListNode l_4 = new ListNode(4);
        ListNode l_5 = new ListNode(5);

        ListNode head  = new ListNode(1);
        head.next = l_2;
        l_2.next = l_3;
        l_3.next = l_4;
        l_4.next = l_5;

        ListNode swapRst = swapPairs(head);
        while(null != swapRst){
            System.out.println(swapRst.val);
            swapRst = swapRst.next;
        }

        System.out.println();
    }

    public static ListNode swapPairs(ListNode head){
        if(null == head || null == head.next) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
