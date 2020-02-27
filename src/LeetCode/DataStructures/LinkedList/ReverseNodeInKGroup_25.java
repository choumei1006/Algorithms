package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2020/2/27 16:47
 * @Description: 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class ReverseNodeInKGroup_25 {
    public static void main(String[] args) {
        ListNode head = ListNode.initListByArray(new int[]{1,2,3,4,5});
        ListNode.printListNode(reverseKGroup(head,3));
    }

    /**
     * 将链表head每K个一组进行反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode l = newHead,r = newHead;
        int cnt = 0;
        while(r != null){
            if(cnt == k){
                r = reverHelper(l,r);
                l = r;
                cnt = 0;
            }
            cnt++;
            r = r.next;
        }
        return newHead.next;
    }

    /**
     * 将[l.next,r]反转，并返回反转后地链表rail
     * @param l
     * @param r
     * @return
     */
    public static ListNode reverHelper(ListNode l,ListNode r){
        if(l.next == r){
            return r;
        }
        r = reverHelper(l.next,r);
        //ListNode temp1 = l.next;
        ListNode temp2 = r.next;
        r.next = l.next;
        l.next = l.next.next;
        r.next.next = temp2;
        return r.next;
    }
}
