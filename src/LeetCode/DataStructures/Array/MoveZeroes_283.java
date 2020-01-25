package LeetCode.DataStructures.Array;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/1/25 23:48
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0,1,0,3,12})));
    }
    public static int[] moveZeroes(int[] nums){
        int eZeroIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0){
                nums[eZeroIndex++] = nums[i];
            }
        }
        while (eZeroIndex < nums.length) {
            nums[eZeroIndex++] = 0;
        }
        return nums;
    }
}
