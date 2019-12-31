package PublicClasses;

/**
 * @author:choumei
 * @date:2019/12/3 22:14
 * @Description: Definition for singly-linked list.
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) {
          val = x;
          next = null;
     }
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
}
