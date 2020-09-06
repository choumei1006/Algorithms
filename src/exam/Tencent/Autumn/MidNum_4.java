package exam.Tencent.Autumn;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/6 21:04
 * @Description: 【中位数】
 * 给n个数字a1,a2,...,an,其中n为偶数；
 * 对于每个数字单独删除之后，剩下的n-1个元素中位数是多少。
 *
 * 输入描述：
 * 第一行，一个偶数（n <= 200000）
 * 第二行，输入n个数字，第i个数字表示ai,ai在32位整数范围内。
 *
 * 输出描述：
 * 输出n行，第i行表示删除ai答案之后，剩下的n-1个元素中位数是多少。
 *
 * 示例1：
 * 输入:
 * 6
 * 1 2 3 4 5 6
 *
 * 输出：
 * 4
 * 4
 * 4
 * 3
 * 3
 * 3
 *
 */
public class MidNum_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //n

        if(n % 2 != 0){
            return;
        }

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n ; i++) {
            int temp = in.nextInt();
            arr1[i] = temp;
            arr2[i] = temp;
        }

        Arrays.sort(arr1);

        for(int e : arr2){
            int midIdx = (n - 1) / 2;
            if(e <= arr1[midIdx]){
                midIdx++;
            }
            System.out.println(arr1[midIdx]);
        }
    }


}

