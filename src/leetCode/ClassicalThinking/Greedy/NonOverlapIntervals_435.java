package leetCode.ClassicalThinking.Greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:choumei
 * @date:2020/9/4 9:38
 * @Description: 【无重叠子区间】
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 */
public class NonOverlapIntervals_435 {
    @Test
    public void test(){
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}}));
    }

    /**
     * 计算最少删除区间数，保证剩余区间不重叠
     * 思路：待删除区间数 = 总区间数 - ‘最多’不重叠区间数
     * 最多不重叠区间数-思路【贪心】：将区间按照结尾由小到大排序，
     *          从左至右遍历，每次选择结尾最小、与‘当前已覆盖区间结尾’不重叠的区间+1，更新已覆盖区间结尾
     *          这样可以尽可能保证后未覆盖区间‘最长’；
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals){
        //特判
        if(null == intervals || intervals.length == 0){
            return 0;
        }

        //1、计算最多不重叠区间数
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));   //lambda表达式创建Comparator
        //使用 lambda 表示式创建 Comparator 会导致算法运行时间过长，
        //     如果注重运行时间，可以修改为普通创建 Comparator 语句：
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int tmpEnd = intervals[0][1];    //初始end
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < tmpEnd){
                continue;       //当前区间与当前最远结尾重叠
            }
            cnt++;
            tmpEnd = intervals[i][1];
        }
        //2、返回待删除区间数
        return intervals.length - cnt;
    }


}
