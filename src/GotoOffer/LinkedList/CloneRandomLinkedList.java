package GotoOffer.LinkedList;

import PublicClasses.RandomListNode;

/**
 * @author:choumei
 * @date:2020/2/19 19:09
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneRandomLinkedList {
    public static void main(String[] args) {

    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(null == pHead){
            return pHead;
        }
        RandomListNode currentNode  = pHead;
        //1、复制所有节点，将复制的心节点查到原节点后面，忽略复杂指针；
        while(null != currentNode){
            RandomListNode colneNode = new RandomListNode(currentNode.label);
            RandomListNode currNext = currentNode.next;
            currentNode.next = colneNode;
            colneNode.next = currNext;
            currentNode = currentNode.next.next;
        }

        //2、复制复杂指针
        currentNode = pHead;
        while(null != currentNode){
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //3、拆分
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while(null != currentNode){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return cloneHead;
    }
}
