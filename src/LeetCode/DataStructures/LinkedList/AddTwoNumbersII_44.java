package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2019/12/11 10:16
 * @Description: 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 */
public class AddTwoNumbersII_44 {
    public static void main(String[] args) {
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);

        ListNode l1 = new ListNode(1);
        l1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;

        ListNode l2_2 = new ListNode(2);
        ListNode l2_3 = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = l2_2;
        l2_2.next = l2_3;

        ListNode addRst = addTwoNumbers(l1,l2);
        while(null != addRst){
            System.out.println(addRst.val);
            addRst = addRst.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = new ListNode(-1);
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        int surplus = 0;
        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() || surplus != 0){
            int v1 = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int v2 = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = v1+v2+surplus;
            surplus = sum/10;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = head.next;
            head.next = newNode;
        }
        return head.next;
    }
    public static Stack<Integer> buildStack(ListNode l){
        Stack<Integer> rstStack = new Stack<>();
        while(null != l){
            rstStack.push(l.val);
            l = l.next;
        }
        return rstStack;
    }
}
