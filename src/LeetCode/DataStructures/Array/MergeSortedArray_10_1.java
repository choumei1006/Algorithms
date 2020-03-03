package LeetCode.DataStructures.Array;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/3 10:35
 * @Description: 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArray_10_1 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{-3,-2,-1};
        merge2(A,3,B,3);
        for(int a : A){
            System.out.println(a);
        }
    }

    /**
     * 自动排序
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        if(null == A || A.length == 0 || null == B || B.length == 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            A[m+i] = B[i];
        }
        Arrays.sort(A);
    }

    /**
     * 尾插法
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge2(int[] A,int m,int[] B,int n){
        int i = m-1,j = n-1,k = m+n-1;
        while(i >= 0 && j >= 0){
            A[k--] = B[j] > A[i] ? B[j--] : A[i--];
        }
        while(j >= 0){
            A[k--] = B[j--];
        }
    }
}
