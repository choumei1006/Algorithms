package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/9 9:42
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode l_2 = new ListNode(2);
        ListNode l_3 = new ListNode(3);
        ListNode l_4 = new ListNode(4);
        ListNode l_5 = new ListNode(5);
        ListNode l_6 = new ListNode(6);

        ListNode head = new ListNode(1);
        head.next = l_2;
        l_2.next = l_3;
        l_3.next = l_4;
        l_4.next = l_5;
        l_5.next = l_6;

        ListNode rmRst = removeNthFromEnd(head,5);
        while(null != rmRst){
            System.out.println(rmRst.val);
            rmRst = rmRst.next;
        }
    }

    /**
     * 用i，j之间的长度测量距离
     * @param head
     * @param n
     * @return
     */
    public  static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode i = head;
        while(n-- > 0){
            i = i.next;
        }
        if(null == i){
            return head.next;
        }
        ListNode j = head;
        while(i.next != null){
            i = i.next;
            j = j.next;
        }
        j.next = j.next.next;
        return head;
    }


}
