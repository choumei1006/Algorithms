package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

import java.util.List;

/**
 * @author:choumei
 * @date:2019/12/12 10:34
 * @Description: 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class PalindromeLinkedlist_234 {
    public static void main(String[] args) {
        ListNode l_2 = new ListNode(2);
        ListNode l_3 = new ListNode(3);
        ListNode l_4 = new ListNode(3);
        ListNode l_5 = new ListNode(2);
        ListNode l_6 = new ListNode(1);

        ListNode head = new ListNode(1);
        head.next  = l_2;
        l_2.next = l_3;
        l_3.next = l_4;
        l_4.next = l_5;
        l_5.next = l_6;

        System.out.println(isPalindrome(head));

    }

    public static boolean isPalindrome(ListNode head){
        if(null == head || null == head.next) return true;
        ListNode pre = null;
        ListNode cur = head;
        ListNode fast = head.next;
        while(null != cur){
            if(null == fast){
                if(pre.val != cur.val) return false;
                pre = pre.next;
                cur = cur.next;
            }else{
                ListNode flagPoint = cur.next;
                cur.next = pre;
                pre = cur;
                cur = flagPoint;
                if(null == fast.next){
                    fast = null;
                }else{
                    fast = fast.next.next;
                    if(null == fast){
                        cur = cur.next;
                    }
                }
            }
        }
        return true;
    }
}
