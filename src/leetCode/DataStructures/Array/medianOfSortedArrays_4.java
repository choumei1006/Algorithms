package leetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2019/11/2123:36
 * @Description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class medianOfSortedArrays_4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,5,7,9};
        int[] nums2 = {3,4};
        System.out.println(medianOfSortedArrays(nums1,nums2));

    }
    public static double medianOfSortedArrays(int[] nums1,int[] nums2){
        int sumLen = nums1.length+nums2.length;
        int lastMedianIndex = (sumLen)/2+1;
        int[] medianStr = new int[lastMedianIndex];
        int index1 = 0,index2 = 0;
        for (int i = 0; i < lastMedianIndex; i++) {
            if(index1 < nums1.length  && index2 < nums2.length) {
                if (nums1[index1] > nums2[index2]) {
                    medianStr[i] = nums2[index2++];
                } else {
                    medianStr[i] = nums1[index1++];
                }
            }else if(index1 < nums1.length){
                medianStr[i] = nums1[index1++];
            }else{
                medianStr[i] = nums2[index2++];
            }
        }

        return sumLen%2 == 0 ? (medianStr[lastMedianIndex-2]+medianStr[lastMedianIndex-1])/2.0: medianStr[lastMedianIndex-1];
    }

    /**
     * 自测
     */
    @Test
    public void test(){
        System.out.println(medianOfSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
    public double medianOfSortedArrays2(int[] nums1, int[] nums2){
        if(null == nums1 || null == nums2){
            throw new IllegalArgumentException("参数数组为空！");
        }
        int len = nums1.length + nums2.length;
        int medianIdx = len / 2;
        int[] resArr = new int[medianIdx + 1];  //为了照顾偶数长度
        int idx1 = 0, idx2 = 0, resIdx = 0;

        //按序存放medianIdx + 1个元素,   !!!注意！！！idx要++
        for (int i = 0; i < resArr.length; i++) {
            if(idx1 < nums1.length && idx2 < nums2.length){
                resArr[resIdx++] = nums1[idx1] < nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
            }else if(idx1 < nums1.length){
                resArr[resIdx++] = nums1[idx1++];
            }else{
                resArr[resIdx++] = nums2[idx2++];
            }
        }
        return len % 2 == 0 ? (resArr[medianIdx - 1] + resArr[medianIdx]) / 2 : resArr[medianIdx];
    }
}
