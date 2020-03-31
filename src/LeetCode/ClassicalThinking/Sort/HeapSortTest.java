package LeetCode.ClassicalThinking.Sort;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/20 18:06
 * @Description:
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] tree = new int[]{4,5,3,10,1,2};
        int n = 6;
        heap_build(tree,n);
        System.out.println(Arrays.toString(tree));
        heap_sort(tree,n);
        System.out.println(Arrays.toString(tree));

    }

    /**
     * 对堆中的第i个节点进行调整
     * @param tree
     * @param n
     * @param i
     */
    public static void heapify(int[] tree, int n, int i ){
        if(i >= n){
            return;
        }
        int c1 = (2 * i) + 1;
        int c2 = (2 * i) + 2;
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            heap_swap(tree,i,max);
            heapify(tree,n,max);
        }
    }

    /**
     * 交换堆中的两个节点值
     * @param tree
     * @param i
     * @param j
     */
    public static void heap_swap(int[] tree, int i, int j){
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    /**
     * 通过原始任意树，构建一个堆
     * @param tree
     * @param n
     */
    public static void heap_build(int[] tree, int n){
        int lastNode = n-1;
        int lastParent = (lastNode - 1) / 2;
        for(int i = lastParent; i >= 0; i--){
            heapify(tree,n,i);
        }
    }

    /**
     * 堆排序
     * @param tree
     * @param n
     */
    public static void heap_sort(int[] tree, int n){
        for (int i = n-1; i >= 0; i--) {
            heap_swap(tree,0,i);
            heapify(tree,i,0);
        }
    }
}
