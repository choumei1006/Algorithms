package leetCode.DataStructures.LinkedList;

import publicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/9 9:33
 * @Description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class DeleteDuplicates_83 {
    public static void main(String[] args) {

        ListNode l_2 = new ListNode(2);
        ListNode l_3 = new ListNode(2);
        ListNode l_4 = new ListNode(4);
        ListNode l_5 = new ListNode(6);

        ListNode head = new ListNode(1);
        head.next = l_2;
        l_2.next = l_3;
        l_3.next = l_4;
        l_4.next = l_5;

        ListNode  deleteRst = deleteDuplicates(head);
        while(null != deleteRst){
            System.out.println(deleteRst.val);
            deleteRst = deleteRst.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head){
        if(null == head || null == head.next) return head;
        head.next = deleteDuplicates(head.next);
        return (head.val == head.next.val) ? head.next : head;
    }
}
