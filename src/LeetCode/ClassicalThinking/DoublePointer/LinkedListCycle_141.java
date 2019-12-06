package LeetCode.ClassicalThinking.DoublePointer;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/3 22:13
 * @Description: 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */
public class LinkedListCycle_141 {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h2;

        System.out.println(hasCycle(h1));
    }

    public static boolean hasCycle(ListNode head){
        if(null == head) return false;
        ListNode l1 = head;
        ListNode l2 = head.next;
        while(null != l1 && null != l2 && l2.next != null){
            if(l1 == l2) return true;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;

    }
}
