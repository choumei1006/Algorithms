package leetCode.DataStructures.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/3/13 23:11
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class MajorityElement_169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
    public static int majorityElement(int[] nums){
        int len = nums.length;
        int marNum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < len;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > len/2){
                marNum = nums[i];
                break;
            }
        }
        return marNum;
    }
}
