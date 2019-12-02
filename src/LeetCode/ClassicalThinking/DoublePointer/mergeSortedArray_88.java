package LeetCode.ClassicalThinking.DoublePointer;

/**
 * @author:choumei
 * @date:2019/12/2 21:15
 * @Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 */
public class mergeSortedArray_88 {
    public static void main(String[] args) {
        int[] mergeRst = merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        for (int i = 0; i < mergeRst.length; i++) {
            System.out.println(mergeRst[i]);
        }
    }
    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        int mi = m-1;
        int ni = n-1;
        int index = m+n-1;
        while(index >= 0){
            if(mi < 0 || ni < 0){
                if(mi < 0){
                    nums1[index--] = nums2[ni--];
                }else if(ni < 0){
                    nums1[index--] = nums1[mi--];
                }
            }else  if(nums2[ni] > nums1[mi]){
                nums1[index--] = nums2[ni--];
            }else{
                nums1[index--] = nums1[mi--];
            }
        }
        return nums1;

    }
}
