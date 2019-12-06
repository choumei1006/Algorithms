package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/6 21:44
 * @Description: 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        ListNode head_2 = new ListNode(2);
        ListNode head_3 = new ListNode(3);
        ListNode head_4 = new ListNode(4);
        ListNode head_5 = new ListNode(5);

        ListNode head = new ListNode(1);
        head.next = head_2;
        head_2.next = head_3;
        head_3.next = head_4;
        head_4.next = head_5;


        ListNode  idx = reverseList2(head);
        while(null != idx){
            System.out.println(idx.val);
            idx = idx.next;
        }
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if(null == head || null == head.next){ return head;}
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        ListNode newHead = new ListNode(-1);
        while(null != head){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
