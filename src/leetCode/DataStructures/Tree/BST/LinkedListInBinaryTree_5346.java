package leetCode.DataStructures.Tree.BST;

import publicClasses.ListNode;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2020/3/1 17:05
 * @Description: 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 示例 3：
 *
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 *
 *
 * 提示：
 *
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 *
 * [1,10,3,7,10,8,9,5,3,9,6,8,7,6,6,3,5,4,4,9,6,7,9,6,9,4,9,9,7,1,5,5,10,4,4,10,7,7,2,4,5,5,2,7,5,8,6,10,2,10,1,1,6,1,8,4,7,10,9,7,9,9,7,7,7,1,5,9,8,10,5,1,7,6,1,2,10,5,7,7,2,4,10,1,7,10,9,1,9,10,4,4,1,2,1,1,3,2,6,9]
 * [4,null,8,null,5,null,7,null,5,null,2,1,3,null,null,null,6,8,9,null,null,null,3,null,2,null,10,null,7,null,8,3,4,null,null,null,3,5,1,null,null,null,3,1,7,null,null,null,4,7,7,null,null,8,3,null,null,null,6,3,1,null,null,null,1,null,8,null,2,5,5,null,null,1,3,null,null,null,5,null,3,3,5,null,null,null,7,null,10,null,7,null,6,null,8,null,4,null,10,null,6,null,6,9,3,null,null,6,5,null,null,null,5,null,2,null,7,null,5,null,4,8,2,null,null,null,2,null,10,10,8,null,null,null,7,null,2,null,5,8,6,null,null,null,5,null,7,null,3,4,5,null,null,null,4,null,8,null,8,null,8,null,2,null,5,2,9,null,null,null,2,null,3,7,1,null,null,10,1,null,null,null,7,null,6,null,6,null,7,null,7,null,4,4,2,null,null,7,4,null,null,null,7,null,3,7,5,null,null,null,5,null,4,null,9,5,2,null,null,null,4,null,9,null,5,null,5,null,5,null,2,null,5,null,2,null,5,null,7,5,5,null,null,null,6,null,1,null,7,null,3,9,8,null,null,null,4,null,7,4,8,null,null,4,2,null,null,null,3,10,2,null,null,null,7,null,10,null,3,null,1,null,2,null,5,null,9,null,8,null,5,null,9,null,3,null,7,null,10,5,2,null,null,null,2,8,10,null,null,null,4,4,7,null,null,null,5,1,4,null,null,null,10,null,9,null,4,null,9,6,5,null,null,null,7,5,4,null,null,null,8,null,8,4,9,null,null,null,6,9,1,null,null,null,3,3,6,null,null,null,6,null,7,null,2,null,1,null,8,2,9,null,null,null,8,null,3,null,1,9,1,null,null,null,2,null,6,null,1,null,6,3,9,null,null,null,10,null,1,null,9,null,9,null,10,null,2,null,6,null,3,null,7,null,2,null,2,null,2,9,5,null,null,null,5,null,6,null,6,null,2,null,5,7,9,null,null,null,6,10,4,null,null,8,4,null,null,4,2,null,null,4,7,null,null,2,5,null,null,null,4,5,1,null,null,null,3,null,1,10,6,null,null,3,2,null,null,null,6,null,9,null,7,null,5,8,5,null,null,null,5,null,5,10,6,null,null,null,7,null,1,null,6,3,7,null,null,null,9,7,1,null,null,null,7,null,4,null,4,null,9,null,4,null,1,null,10,null,1,10,10,null,null,null,6,null,3,null,1,null,9,null,7,null,6,6,1,null,null,null,9,4,7,null,null,null,3,null,10,null,4,3,3,null,null,null,4,5,10,null,null,null,1,8,10,null,null,null,6,null,9,null,10,null,4,4,9,null,null,null,3,null,3,null,3,null,10,null,10,null,6,8,1,null,null,null,9,7,1,null,null,null,5,null,3,null,10,null,5,null,9,null,5,null,8,null,6,3,2,null,null,null,8,null,8,3,9,null,null,null,9,null,10,3,8,null,null,6,6,null,null,null,6,null,8,null,2,null,9,null,4,null,6,null,4,null,4,null,6,null,9,null,7,null,10,null,1,null,3,null,6,null,7,null,4,null,9,null,1,null,3,8,10,null,null,null,2,null,10,null,4,null,8,null,10,null,7,null,8,5,1,null,null,9,3,null,null,7,8,null,null,null,1,null,1,5,4,null,null,null,1,null,4,5,7,null,null,null,3,null,6,null,6,null,9,null,4,null,1,5,10,null,null,null,3,null,7,null,10,null,8,null,9,2,5,null,null,null,3,null,9,10,6,null,null,null,8,null,7,8,6,null,null,null,6,null,3,null,5,null,4,null,4,null,9,null,6,2,7,null,null,null,9,null,6,1,9,null,null,null,4,null,9,9,9,null,null,null,7,7,1,null,null,null,5,null,5,6,10,null,null,null,4,null,4,10,10,null,null,null,7,2,7,null,null,null,2,null,4,null,5,null,5,10,2,null,null,null,7,9,5,null,null,null,8,null,6,null,10,8,2,null,null,8,10,null,null,null,1,null,1,null,6,5,1,null,null,8,8,null,null,8,4,null,null,null,7,null,10,4,9,null,null,null,7,null,9,null,9,1,7,null,null,4,7,null,null,null,7,null,1,null,5,8,9,null,null,9,8,null,null,9,10,null,null,4,5,null,null,1,1,null,null,null,7,null,6,null,1,null,2,1,10,null,null,2,5,null,null,7,7,null,null,null,7,null,2,null,4,3,10,null,null,null,1,null,7,null,10,7,9,null,null,null,5,4,9,null,null,null,10,6,4,null,null,8,4,null,null,null,1,null,2,null,1,8,1,null,null,null,3,null,2,null,6,null,9,null,2,1,10,null,null,null,5,null,8,2,1,null,null,null,2,3,10,null,null,null,8,null,9,null,5,null,4,null,1,9,10,null,null,4,9,null,null,3,5,null,null,null,6,null,6,9,1,null,null,null,5,null,2,null,2,null,6,null,1,7,9,null,null,null,6,null,8,4,4,null,null,null,2,null,10,null,1,null,2,null,9,null,8,null,2,null,1,10,4,null,null,null,10,null,8,3,2,null,null,null,10,null,3,8,1,null,null,5,3,null,null,null,6,null,8,null,7,2,5,null,null,1,6,null,null,null,8,null,6,null,3,null,8,null,9,null,5,null,2,null,9,null,2,6,10,null,null,7,10,null,null,null,6,null,8,null,7,7,4,null,null,null,3,5,2,null,null,10,4,null,null,null,4,4,3,null,null,null,5,null,1,null,10,null,10,null,5,null,9,null,3,null,8,null,3,null,2,null,4,1,1,null,null,null,7,10,8,null,null,null,9,4,8,null,null,1,2,null,null,9,7,null,null,5,8,null,null,null,9,null,7,null,4,null,4,5,3,null,null,null,2,null,4,3,10,null,null,7,7,null,null,null,2,null,2,8,8,null,null,null,2,null,4,null,5,8,4,null,null,null,9,null,4,null,10,null,4,null,5,null,5,null,1,null,5,null,8,null,5,null,5,null,1,null,10,null,9,null,10,null,2,null,7,5,9,null,null,null,6,4,6,null,null,null,2,null,10,null,1,4,3,null,null,7,8,null,null,null,3,null,3,null,8,null,10,null,6,6,10,null,null,null,1,8,5,null,null,1,3,null,null,null,8,null,9,null,10,null,8,4,9,null,null,10,1,null,null,null,2,null,8,5,2,null,null,8,6,null,null,null,4,null,7,10,1,null,null,null,3,3,3,null,null,null,3,null,5,7,3,null,null,10,9,null,null,null,2,null,8,null,10,null,7,null,10,null,3,9,10,null,null,null,6,4,9,null,null,9,3,null,null,null,7,null,2,null,10,null,10,null,7,null,4,5,7,null,null,9,8,null,null,null,6,3,1,null,null,null,9,null,7,4,4,null,null,null,6,null,1,null,9,null,9,null,3,1,1,null,null,1,8,null,null,null,1,null,2,null,7,4,6,null,null,null,1,null,3,null,8,null,10,null,3,null,10,null,10,null,10,null,10,null,10,null,6,null,7,null,3,null,9,null,7,5,4,null,null,null,5,null,5,1,3,null,null,null,6,3,4,null,null,null,3,2,10,null,null,10,5,null,null,null,5,9,1,null,null,null,8,null,7,null,9,5,3,null,null,null,2,null,7,null,10,null,2,9,4,null,null,null,4,10,10,null,null,null,6,2,6,null,null,null,4,null,5,null,7,null,7,null,2,4,1,null,null,null,7,null,5,8,8,null,null,3,6,null,null,null,1,null,5,null,8,4,6,null,null,null,6,null,9,null,4,null,4,null,3,null,2,6,9,null,null,null,6,6,8,null,null,null,7,null,5,null,5,null,9,4,3,null,null,null,10,4,6,null,null,null,9,null,3,null,10,null,9,null,1,null,6,null,1,null,4,null,5,5,3,null,null,7,8,null,null,null,6,null,6,null,5,9,4,null,null,null,9,null,7,null,7,7,5,null,null,null,7,null,3,8,3,null,null,null,1,5,4,null,null,null,2,null,3,null,4,null,5,5,6,null,null,null,2,null,2,7,9,null,null,9,5,null,null,null,9,null,9,null,8,7,6,null,null,null,2,null,9,null,2,null,7,6,4,null,null,null,1,null,7,null,2,null,7,null,3,9,2,null,null,4,5,null,null,null,3,null,2,null,8,7,8,null,null,7,7,null,null,null,10,null,9,2,7,null,null,6,3,null,null,null,10,null,5,null,7,null,9,null,3,null,1,null,9,null,2,5,2,null,null,null,4,null,8,null,6,10,10,null,null,10,3,null,null,null,3,null,1,null,3,null,8,3,2,null,null,null,5,2,8,null,null,7,5,null,null,7,7,null,null,null,1,6,5,null,null,null,2,null,4,null,7,null,5,null,3,null,7,null,10,null,10,null,7,null,9,null,5,5,5,null,null,null,9,null,4,null,7,null,6,null,2,null,3,null,3,8,10,null,null,null,1,null,3,null,6,null,10,null,8,null,6,4,5,null,null,null,6,null,3,null,3,null,8,1,3,null,null,2,3,null,null,null,7,null,10,null,2,null,10,null,2,null,7,null,10,6,7,null,null,3,4,null,null,6,2,null,null,null,9,null,8,null,7,null,10,null,9,10,1,null,null,null,5,1,10,null,null,10,2,null,null,null,2,5,8,null,null,null,9,8,8,null,null,null,8,null,4,1,3,null,null,null,4,null,4,null,9,null,4,10,7,null,null,10,4,null,null,4,5,null,null,9,2,null,null,3,7,null,null,8,7,null,null,null,5,null,10,null,3,null,8,null,3,null,5,2,9,null,null,null,10,null,3,null,10,null,7,5,1,null,null,2,4,null,null,null,5,null,2,null,6,null,8,null,9,null,10,null,9,null,6,null,2,6,7,null,null,2,7,null,null,null,3,null,6,9,5,null,null,2,6,null,null,null,8,null,4,null,8,null,2,4,9,null,null,4,7,null,null,null,9,null,5,null,3,null,8,null,6,null,5,7,4,null,null,8,7,null,null,null,9,1,2,null,null,null,9,6,7,null,null,null,8,null,6,null,6,4,6,null,null,null,3,null,5,10,4,null,null,null,5,null,8,null,8,null,7,null,10,5,10,null,null,null,10,null,10,null,10,8,2,null,null,5,3,null,null,null,8,6,6,null,null,10,8,null,null,1,8,null,null,null,9,1,6,null,null,7,6,null,null,null,10,5,4,null,null,null,10,5,4,null,null,2,5,null,null,null,4,2,5,null,null,null,3,null,4,2,8,null,null,null,5,null,9,null,3,9,3,null,null,null,5,null,7,null,7,null,5,null,10,null,3,2,7,null,null,3,8,null,null,null,10,2,3,null,null,null,7,3,3,null,null,null,6,null,4,null,8,null,3,null,3,null,1,null,9,10,1,null,null,null,1,null,6,6,5,null,null,6,3,null,null,null,6,null,4,null,2,null,10,null,9,2,5,null,null,null,10,null,10,3,5,null,null,10,6,null,null,1,9,null,null,6,7,null,null,6,5,null,null,null,8,null,8,5,6,null,null,null,6,null,8,null,8,null,4,null,6,null,9,null,2,null,1,null,10,null,9,null,9,null,4,1,6,null,null,null,1,null,3,null,4,10,8,null,null,null,7,null,5,null,10,null,1,null,9,null,9,null,9,1,8,null,null,null,1,null,9,5,1,null,null,7,1,null,null,null,8,null,1,8,6,null,null,2,9,null,null,10,5,null,null,null,2,null,10,null,10,null,9,null,10,null,7,null,7,null,5,null,8,8,2,null,null,null,9,null,10,null,1,null,1,null,1,null,10,6,1,null,null,null,9,null,2,9,9,null,null,null,9,3,8,null,null,null,1,null,10,1,10,null,null,null,8,null,7,null,8,null,8,6,5,null,null,2,5,null,null,null,7,null,1,null,10,null,4,8,5,null,null,5,2,null,null,2,3,null,null,null,6,3,10,null,null,1,8,null,null,null,9,null,8,7,10,null,null,null,10,null,5,10,6,null,null,null,5,null,6,null,5,6,6,null,null,5,8,null,null,null,7,null,8,null,10,1,1,null,null,null,10,1,2,null,null,9,5,null,null,null,7,4,5,null,null,null,10,null,3,null,5,null,8,null,2,null,9,null,9,6,7,null,null,7,1,null,null,null,5,null,2,null,8,5,3,null,null,null,7,null,6,null,6,null,7,null,5,null,1,6,7,null,null,null,6,null,8,null,8,null,5,10,10,null,null,null,10,5,2,null,null,6,5,null,null,8,1,null,null,2,3,null,null,9,3,null,null,10,7,null,null,1,4,null,null,5,10,null,null,null,7,null,6,null,1,null,9,null,8,null,2,10,7,null,null,null,5,3,9,null,null,null,2,null,7,null,3,null,7,null,7,9,2,null,null,null,5,null,6,1,2,null,null,5,10,null,null,6,9,null,null,null,10,9,8,null,null,5,9,null,null,null,10,5,6,null,null,null,10,10,1,null,null,null,7,null,10,null,3,null,2,null,6,9,9,null,null,2,5,null,null,null,1,null,8,null,2,null,4,2,9,null,null,null,10,null,6,null,5,2,3,null,null,null,1,null,7,null,10,6,10,null,null,null,2,5,9,null,null,4,7,null,null,null,2,1,1,null,null,null,9,null,5,7,7,null,null,null,3,null,4,null,10,2,6,null,null,8,6,null,null,1,10,null,null,null,10,4,4,null,null,null,7,null,8,7,5,null,null,null,2,10,6,null,null,3,6,null,null,null,10,null,8,null,8,8,9,null,null,null,7,null,8,null,1,null,5,null,8,null,7,10,6,null,null,null,3,null,5,null,6,9,10,null,null,null,10,null,6,null,2,null,2,null,2,null,9,null,7,null,4,5,9,null,null,null,4,null,4,null,3,null,10,null,3,10,3,null,null,5,7,null,null,null,6,null,3,3,4,null,null,null,7,null,6,null,10,null,5,8,8,null,null,null,4,5,5,null,null,null,2,null,10,null,2,null,1,2,8,null,null,null,5,null,8,null,3,null,4,null,8,null,1,null,5,8,1,null,null,3,9,null,null,null,3,1,1,null,null,5,9,null,null,null,6,null,9,5,6,null,null,null,5,3,5,null,null,null,9,3,1,null,null,3,5,null,null,3,10,null,null,null,10,null,8,null,1,null,7,null,4,null,1,null,7,null,1,null,3,7,9,null,null,1,2,null,null,null,8,3,7,null,null,null,8,null,1,6,6,null,null,null,9,7,4,null,null,6,10,null,null,4,5,null,null,null,1,null,7,null,6,7,3,null,null,null,6,null,9,null,8,2,6,null,null,6,8,null,null,2,7,null,null,null,8,null,8,7,5,null,null,null,4,null,9,5,3,null,null,9,5,null,null,null,5,null,1,null,5,null,6,8,6,null,null,null,5,null,4,null,2,8,5,null,null,null,9,null,5,null,9,null,3,null,5,9,3,null,null,null,2,null,7,null,8,null,8,null,8,null,10,7,2,null,null,null,6,null,2,1,10,null,null,null,6,null,8,null,4,null,6,8,5,null,null,null,3,null,1,null,6,null,6,null,2,null,9,1,9,null,null,null,3,null,7,4,7,null,null,9,6,null,null,7,8,null,null,null,1,5,1,null,null,7,10,null,null,null,6,null,8,3,2,null,null,1,5,null,null,null,8,null,3,null,3,9,1,null,null,null,8,null,1,3,5,null,null,null,9,null,8,3,4,null,null,null,9,null,1,null,3,null,7,null,3,5,1,null,null,null,4,null,1,null,5,null,1,null,3,4,8,null,null,null,1,10,7,null,null,null,1,null,9,null,7,null,3,null,10,6,9,null,null,null,3,6,8,null,null,null,8,null,3,null,4,null,10,null,2,10,7,null,null,5,4,null,null,null,4,2,6,null,null,1,10,null,null,null,4,3,7,null,null,null,4,null,1,null,6,null,10,null,7,4,9,null,null,null,10,9,4,null,null,null,6,5,9,null,null,null,7,1,7,null,null,null,4,null,4,null,4,null,6,4,3,null,null,null,4,null,5,null,10,null,2,null,1,null,1,null,2,null,2,9,4,null,null,null,9,null,9,9,4,null,null,null,5,null,6,null,2,null,3,null,10,9,10,null,null,10,2,null,null,3,9,null,null,null,9,null,10,null,9,null,3,null,1,5,6,null,null,null,6,null,2,null,9,null,3,null,9,9,3,null,null,5,3,null,null,null,2,null,3,null,8,null,2,null,9,null,3,null,4,null,3,null,4,null,8,6,7,null,null,null,6,null,3,null,1,null,9,5,1,null,null,null,2,null,7,4,7,null,null,null,2,null,9,null,7,null,10,null,6,null,7,null,1,null,4,null,5,null,2,null,7,null,3,null,7,null,4,null,5,null,10,null,1,null,9,9,8,null,null,10,10,null,null,null,6,6,10,null,null,10,4,null,null,4,6,null,null,null,4,null,3,null,5,4,8,null,null,null,5,6,3,null,null,1,7,null,null,9,4,null,null,null,9,10,2,null,null,null,5,null,6,2,5,null,null,null,10,5,1,null,null,null,8,2,2,null,null,7,6,null,null,null,9,null,4,null,4,null,2,null,4,null,8,1,10,null,null,null,8,null,3,null,1,null,5,null,2,null,9,8,5,null,null,8,6,null,null,null,1,null,6,null,2,2,9,null,null,null,9,5,7,null,null,null,4,null,5,4,5,null,null,1,1,null,null,8,3,null,null,null,10,7,10,null,null,6,5,null,null,6,3,null,null,4,1,null,null,10,1,null,null,4,2,null,null,6,3,null,null,null,2,null,9,null,10,9,9,null,null,null,2,null,8,null,8,6,2,null,null,10,7,null,null,null,10,1,3,null,null,2,3,null,null,null,10,3,1,null,null,null,9,null,4,null,3,null,4,null,7,null,2,null,1,null,9,null,1,null,7,null,9,null,7,null,6,7,9,null,null,null,10,null,6,3,2,null,null,null,4,null,4,null,5,4,1,null,null,null,3,null,3,null,6,null,5,null,4,10,5,null,null,4,6,null,null,10,4,null,null,null,7,null,10,null,1,null,1,5,6,null,null,9,7,null,null,null,3,null,6,null,8,null,2,null,4,null,2,null,7,null,8,3,10,null,null,null,6,null,3,null,7,null,4,2,3,null,null,1,9,null,null,5,6,null,null,6,6,null,null,null,7,null,8,9,9,null,null,null,9,null,1,null,9,null,5,null,1,null,5,2,6,null,null,null,9,2,4,null,null,3,6,null,null,4,2,null,null,null,9,null,6,3,3,null,null,null,7,null,9,null,6,2,9,null,null,null,8,null,5,null,4,null,7,null,4,null,8,null,5,3,2,null,null,null,1,null,1,null,1,null,1,null,1,null,1,null,4,null,6,3,7,null,null,9,7,null,null,9,2,null,null,null,4,null,1,null,5,null,8,null,2,10,1,null,null,null,10,null,1,2,7,null,null,null,5,null,8,null,7,2,6,null,null,null,10,null,3,null,7,null,3,null,6,9,4,null,null,null,2,null,8,null,8,null,1,null,8,null,8,null,9,null,7,null,5,10,9,null,null,4,4,null,null,null,7,null,6,null,8,1,3,null,null,9,3,null,null,1,10,null,null,null,9,8,2,null,null,null,8,null,4,null,4,4,1,null,null,null,7,null,8,1,9,null,null,null,10,null,3,6,7,null,null,null,5,5,2,null,null,null,4,null,5,6,6,null,null,7,7,null,null,5,10,null,null,null,6,10,6,null,null,null,2,null,5,2,5,null,null,null,7,null,7,null,7,null,4,null,9,null,4,null,8,null,1,null,5,null,9,6,4,null,null,null,8,9,2,null,null,10,2,null,null,null,3,null,4,null,10,null,6,null,10,2,9,null,null,6,1,null,null,null,7,6,6,null,null,null,2,null,4,null,10,8,9,null,null,null,7,3,9,null,null,10,4,null,null,null,10,null,6,null,2,null,5,null,1,null,8,8,3,null,null,null,2,5,10,null,null,5,8,null,null,3,10,null,null,null,5,null,8,null,5,null,4,null,5,6,2,null,null,null,7,null,5,null,10,null,8,1,5,null,null,null,1,null,1,null,5,null,9,null,6,null,1,null,5]
 */
public class LinkedListInBinaryTree_5346 {
    public static void main(String[] args) {
        ListNode head = ListNode.initListByArray(new int[]{1,4,2,6,5});
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,4,4,null,2,2,null,null,null,1,null,6,8,null,null}));
        System.out.println(isSubPath(head,root));
    }
    /*public static  boolean isSubPath1(ListNode head, TreeNode root) {
        if(null == head || null == root){
            return head == null ? true : false;
        }
        Boolean flag = isSubPath(head,root.right) || isSubPath(head,root.left);
        Boolean flag2 = isSubPath(head.next,root.left) || isSubPath(head.next,root.right);
        if(head.val == root.val){
            return flag2 ||flag;
        }else{
            return flag;
        }
        //return ( head.val == root.val ? (isSubPath(head.next,root.left) || isSubPath(head.next,root.right) ) : false )
               // ||  isSubPath(head,root.right) || isSubPath(head,root.left);

    }*/
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean isSub(ListNode head, TreeNode node) {
        //特判：链表走完了，返回true
        if (head == null) {
            return true;
        }
        //特判：链表没走完，树走完了，这肯定不行，返回false
        if (node == null) {
            return false;
        }
        //如果值不同，必定不是啊
        if (head.val != node.val) {
            return false;
        }
        //如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head.next, node.left) || isSub(head.next, node.right);

    }
}
