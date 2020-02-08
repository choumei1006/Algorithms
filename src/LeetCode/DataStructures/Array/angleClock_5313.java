package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/8 23:13
 * @Description: 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * 示例 2：
 *
 *
 *
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * 示例 3：
 *
 *
 *
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * 示例 4：
 *
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * 示例 5：
 *
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 */
public class angleClock_5313 {
    public static void main(String[] args) {
        System.out.println(angleClock(12,30));
    }
    public static double angleClock(int hour, int minutes) {
        double d1 = 30.0 * (hour + (minutes /60.0));
        double d2 = minutes*360.0/60.0;
        double angle = Math.abs(d2-d1);
        return Math.min(angle,360.0-angle);
    }
}
