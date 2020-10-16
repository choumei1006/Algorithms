package exam.WuBa.TreePrint_2;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/9/14 21:00
 * @Description:
 */
public class Number_3 {
    public static void main(String[] args) {

    }

    public int firstMissingPositive (int[] nums) {
        if(null == nums  || nums.length == 0 ){
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                continue;
            }
            if(nums[i] == res){
                ++res;
            }
        }
        return res;
    }
}
