package LeetCode.ClassicalThinking.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/31 21:15
 * @Description: 归并排序
 * 事件复杂度：O(nLogn)
 */
public class MergeSortTest {
    @Test
    public void test(){
        System.out.println(Arrays.toString(mergeSortHelper(new int[]{5,2,3,1})));
    }
    public void mergeSort(int[] arr){
        mergeSortHelper(arr);
    }
    public int[] mergeSortHelper(int[] arr){
        if(null == arr){
            return null;
        }
        int len = arr.length;
        if(len == 1){
            return arr;
        }
        int midIdx = len / 2;
        int leftLen = midIdx;
        int rightLen = len % 2 == 0 ? midIdx : midIdx + 1;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        System.arraycopy(arr,0,leftArr,0,leftLen);
        System.arraycopy(arr,midIdx,rightArr,0,rightLen);

        //递归
        int[] sortedLeftArr = mergeSortHelper(leftArr);
        int[] sortedRightArr = mergeSortHelper(rightArr);

        int[] res = new int[len];

        int leftPoint = leftLen-1, rightPoint = rightLen-1;
        int resPoint = len-1;
        while(leftPoint >= 0 || rightPoint >= 0){
            int curLeft = leftPoint < 0 ? Integer.MIN_VALUE : sortedLeftArr[leftPoint];
            int curRight = rightPoint < 0 ? Integer.MIN_VALUE : sortedRightArr[rightPoint];
            if(curLeft > curRight){
                res[resPoint--] = curLeft;
                leftPoint--;
            }else{
                res[resPoint--] = curRight;
                rightPoint--;
            }
        }
        return res;
    }
}
