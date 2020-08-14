package publicClasses;

/**
 * @author:choumei
 * @date:2019/12/3 22:14
 * @Description: Definition for single-linked list.  [单链表节点]
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) {
          val = x;
          next = null;
     }

    /**
     * 初始化一个链表
     * @param array：整型数组
     * @return
     */
     public static ListNode initListByArray(int[] array){
          ListNode head = new ListNode(-1);
          ListNode idx = head;
          for (int i = 0; i < array.length ; i++) {
               ListNode cur = new ListNode(array[i]);
               idx.next = cur;
               idx = idx.next;
          }
          return head.next;
     }

    /**
     * 顺次输出链表所有节点值
     * @param head
     */
     public static void printListNode(ListNode head){
         while(null != head){
             System.out.println(head.val);
             head = head.next;
         }
     }
}
