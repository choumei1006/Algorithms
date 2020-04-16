package LeetCode.DataStructures.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/16 9:08
 * @Description: 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class MergeIntervals_56 {
    @Test
    public void test(){

    }

    /**
     * 方法一：暴力破解-两两遍历
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) res[ri++] = pair;
        }
        return res;
    }

    /**
     * 方法二：
     * 左、右区间分成两个数组分别排序
     * 逐个判断是否可合并
     * 若可合并则合入后者
     * 此处不急于合并（j 在等待另一半），而是等待可成对后，再合入 list
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                // 下一个 start 左区间已无法涵盖当前 end 右区间
                // 已找到 j 的另一半 i
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 方法三：
     * 整体按左区间升序排序
     * 遍历并判断前后两者是否可合并
     * 若可合并则合入后者
     * @param intervals
     * @return
     */
    public int[][] merge3(int[][] intervals) {
        int len = intervals.length;
        if (len < 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>(len);
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else list.add(intervals[i]);
        }
        list.add(intervals[len - 1]); // 别忘了最后一个

        return list.toArray(new int[list.size()][2]);
    }




}
