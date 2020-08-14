package leetCode.DataStructures.LinkedList;

import publicClasses.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:choumei
 * @date:2020/4/26 12:41
 * @Description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class MergeKLinkedList_23 {
    @Test
    public void test(){
        ListNode node1 = ListNode.initListByArray(new int[]{1,4,5});
        ListNode node2 = ListNode.initListByArray(new int[]{1,3,4});
        ListNode node3 = ListNode.initListByArray(new int[]{2,6});

        ListNode[] lists = new ListNode[]{node1, node2, node3};

        ListNode.printListNode(mergeKLists(lists));
    }

    /**
     * 合并K个有序单链表
     * 思路:利用小顶堆存放每个链表中头节点，这样可以维护一个有序的链表头节点数组，
     *     每次获取小顶堆堆顶元素添加到结果链表中，随后将next节点添加到小顶堆中；
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(null == lists || lists.length == 0){
            return null;
        }
        ListNode res = new ListNode(-1);  //结果集
        ListNode curIdx = res;   //结果集索引指针

        //小顶堆(传递比较器)
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        
        //将所有链表的头节点加入堆
        for (int i = 0; i < lists.length; i++) {
            if(null != lists[i]){
                queue.add(lists[i]);
            }
        }
        //循环更新小顶堆
        ListNode curNode = null;
        while(!queue.isEmpty()){
            //获取小顶堆堆顶元素，保证当前元素是所有链表头元素中的最小值
            curNode = queue.poll();

            //添加到结果集
            curIdx.next = curNode;
            curIdx = curIdx.next;

            //当前节点next节点添加到小顶堆（保证有序性）
            if(null != curNode.next){
                queue.add(curNode.next);
            }
        }
        curIdx.next = null;   //尾节点
        return res.next;
    }
}
