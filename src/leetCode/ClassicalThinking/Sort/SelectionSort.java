package leetCode.ClassicalThinking.Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/3/21 18:04
 * @Description: 选择排序
 * 时间复杂度：O(n^2)
 */
public class SelectionSort {
    @Test
    public void test1(){
        Scanner scan = new Scanner(System.in);
        int listLen = scan.nextInt();
        int[] scores = new int[listLen];
        for(int i = 0; i < listLen; i++){
            scores[i] = scan.nextInt();
        }
        int[] sortedScores = scores;

        Arrays.sort(sortedScores);
        //Arrays.sort(scores);
        int times = scan.nextInt();
        double[] rsts = new double[times];
        for(int i = 0; i < times; i++){
            int index = scan.nextInt();
            rsts[i] = (double)(indexOf(sortedScores,scores[index-1])/listLen);
        }
        for(int i = 0; i < times; i++){
            System.out.println(rsts[i]);
        }
    }
    public int indexOf(int[] nums,int num){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                return i;
            }
        }
        return -1;
    }

    /**
     * 测试生成一个80000个元素的数组
     */
    @Test
    public void test2(){
        int[] arr = new int[80000];
        Random random = new Random();
        for (int i = 0; i < 80000; i++) {
            arr[i] = random.nextInt(80000);
        }
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test(){
        int[] arr = new int[]{3,4,6,5,8,7,9,1,0};
        selectSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort1(int[] arr){
        if(null == arr){
            return;
        }
        int len = arr.length;
        for (int i = len; i > 1; i--) {
            int maxPos = getMaxPos(arr,i);
            int temp = arr[maxPos];
            arr[maxPos] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    /**
     * 获取数组arr中前n个元素中的最大值的下标
     * @param arr
     * @param n
     * @return
     */
    public int getMaxPos(int[] arr, int n){
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[maxPos]){
                maxPos = i;
            }
        }
        return maxPos;
    }

    //自测
    public void selectSort2(int[] arr){
        if(null == arr){
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int minIdx = i;
            int minNum = arr[minIdx];
            for (int j = i+1; j < len ; j++) {
                if(arr[j] < minNum){
                    minIdx = j;
                    minNum = arr[minIdx];
                }
            }
            if(minIdx != i){
                arr[minIdx] = arr[i];
                arr[i] = minNum;
            }
        }
    }
}
