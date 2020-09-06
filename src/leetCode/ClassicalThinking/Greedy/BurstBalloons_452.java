package leetCode.ClassicalThinking.Greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/4 10:18
 * @Description: 【用最少数量的箭引爆气球】
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 */
public class BurstBalloons_452 {

    public static void main(String[] args) {
        //接收输入参数
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    //气球个数
        int[][] points = new int[n][2];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String inputLR = sc.nextLine().trim();
            String[] inputOpts = inputLR.split("\\s+");   //空格隔开
            points[i][0] = Integer.parseInt(inputOpts[0]);
            points[i][1] = Integer.parseInt(inputOpts[1]);
        }

        System.out.println(findMinArrowsShots(points));
    }

    /**
     * 方法一：贪心
     * 最少射箭数 = 不重叠区间数目
     * 最多不重叠区间数（贪心）：同435题；注意区别：[1,2]和[2,3]在本题中属于重叠区间
     *
     * @param points
     * @return
     */
    public static  int findMinArrowsShots(int[][] points) {
        //特判
        if (null == points || points.length == 0) {
            return 0;
        }
        //1、计算不重叠子区间个数
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));   //将区间按照结尾排序
        int cnt = 1;
        int tmpEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= tmpEnd ){    //重叠
                continue;
            }
            tmpEnd = points[i][1];                //更新已覆盖区间结尾
            cnt++;                                 //更新不重叠子串个数
        }
        //2、返回不重叠区间个数，即飞镖个数
        return cnt;
    }
}
