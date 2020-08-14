package leetCode.DataStructures.LinkedList;

import publicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/14 21:14
 * @Description: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 */
public class OddEvenLinkedList_328 {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        ListNode head = ListNode.initListByArray(list);
        ListNode rstList = oddEvenList2(head);
        ListNode.printListNode(rstList);
    }

    /**
     * 方法二：精简逻辑：先分别链接奇偶链表，最后衔接奇链表末尾与偶链表头
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head){
        if(null == head || null == head.next) return head;
        ListNode odd = head,even = head.next,headEven = even;
        while(null != even && null != even.next){
            odd.next= odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = headEven;
        return head;
    }
    public static ListNode oddEvenList(ListNode head){
        if(null == head || null == head.next) return head;
        ListNode oddIdx = head;
        ListNode evenIdx = head.next;
        ListNode evenStart = head.next;
        while(null != evenIdx.next){
            ListNode evenNext = evenIdx.next.next;
            ListNode oddNext = evenIdx.next;
            evenIdx.next = evenNext;
            oddNext.next = evenStart;
            oddIdx.next = oddNext;

            oddIdx = oddIdx.next;
            if(null != evenIdx.next){
                evenIdx = evenIdx.next;
            }
        }
        return head;
    }


}
