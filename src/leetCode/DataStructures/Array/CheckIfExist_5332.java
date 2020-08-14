package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:choumei
 * @date:2020/2/9 10:36
 * @Description: 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，
 * 满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class CheckIfExist_5332 {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
    }
    public static boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            Integer tempRst = map.get(arr[i]);
            if(null != tempRst){
                return true;
            }
            map.put(2*arr[i],i);  //存放2倍
            if(arr[i]%2 == 0) {
                map.put(arr[i] / 2, i);   //存放1/2倍
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(checkIfExist3(new int[]{1,2,4,5}));
    }

    /**
     * 判断一个数组中是否存在 1：2关系
     * 思路：遍历数组，将数组元素的 2、1/2倍元素存入目标数组中
     * @param arr
     * @return
     */
    public boolean checkIfExist2(int[] arr) {
        //特判
        if (null == arr || arr.length == 0) {
            return false;
        }

        Map<Integer, Integer> targets = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer tempTarget = targets.get(arr[i]);
            //存在1：2关系
            if(null != tempTarget){
                return true;
            }
            targets.put(2 * arr[i], i);

            if(arr[i] % 2 == 0){
                targets.put(arr[i] / 2, i);
            }
        }
        return false;
    }

    /**
     * 改进3：将目标集合更换为 Set
     * @param arr
     * @return
     */
    public boolean checkIfExist3(int[] arr){
        if(null == arr || arr.length == 0){
            return false;
        }
        Set<Integer> targets = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(targets.contains(arr[i])){
                return true;
            }
            targets.add(2 * arr[i]);
            if(arr[i] % 2 == 0){
                targets.add(arr[i] / 2);
            }
        }
        return false;
    }
}
