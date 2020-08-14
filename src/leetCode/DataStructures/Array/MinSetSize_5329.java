package leetCode.DataStructures.Array;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/2/2 11:44
 * @Description: 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 *
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * 示例 3：
 *
 * 输入：arr = [1,9]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 * 示例 5：
 *
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 *
 * Exception:[3,3,3,3,5,5,5,2,2,7]
 */
public class MinSetSize_5329 {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
    public static int minSetSize(int[] arr) {
        //定义map<Integer,Integer>
        Map<Integer,Integer> map  = new HashMap<>();
        //添加<整数，次数>
        for (int i = 0; i < arr.length ; i++) {
            Integer tempVal = map.get(arr[i]);
            if(null != tempVal){
                map.put(arr[i],tempVal+1);
            }else{
                map.putIfAbsent(arr[i],1);
            }
        }
        //map排序
        List<Map.Entry<Integer, Integer>> hashList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(hashList, new Comparator<Map.Entry<Integer, Integer>>() {
            // 降序排序
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //前-后 求和，直到大于一半
        int tempLen = 0;
        int deleteTimes = 0;
        for(Map.Entry<Integer,Integer> m : hashList){
            tempLen += m.getValue();
            deleteTimes ++;
            if(tempLen >= arr.length/2) break;
        }
        return deleteTimes;
    }
}
