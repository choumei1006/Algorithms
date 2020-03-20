package LeetCode.DataStructures.Array;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,1,2,1},1)));
    }

    /**
     * 利用库函数排序，复制
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr,int k){
        Arrays.sort(arr);
        int[] rst = new int[k];
        System.arraycopy(arr,0,rst,0,k);
        return rst;
    }
}
