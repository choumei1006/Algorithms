package leetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/1/19 15:17
 * @Description: 一个长度为n的有序数组，范围为【0，n】，找出缺少的数字
 * 示例1：【0，1，3】
 * 返回：2
 * 示例2：【0，1，3，4，5】
 * 返回：2
 * 示例3：【0，1，2，3，5】
 * 返回：4
 */
public class FindLackNumber {
    public static void main(String[] args) {
        System.out.println(findLackNumber(new int[]{0,1,3,4,5}));
    }
    public static int findLackNumber(int[] arr){
        int l = 0, r = arr.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid] <= mid){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return r;
    }
}
