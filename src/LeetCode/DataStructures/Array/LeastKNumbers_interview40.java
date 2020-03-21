package LeetCode.DataStructures.Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/3/20 15:02
 * @Description: 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class LeastKNumbers_interview40 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers2(new int[]{4,5,3,10,1,2},4)));
    }

    /**
     * 利用库函数排序、复制
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr,int k){
        Arrays.sort(arr);
        int[] rst = new int[k];
        System.arraycopy(arr,0,rst,0,k);
        return rst;
    }

    /**
     * 大顶堆
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k){
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        //维持一个K大小的大顶堆
        Queue<Integer> heap = new PriorityQueue<>((v1,v2) -> v2-v1 );
        for(int i : arr){
            if(heap.size() < k){
                heap.offer(i);
            }else if(i < heap.peek()){
                heap.poll();
                heap.offer(i);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for(int temp : heap){
            res[idx] = temp;
        }
        return res;
    }



    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
}
