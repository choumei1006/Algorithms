package leetCode.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:choumei
 * @date:2020/2/23 10:41
 * @Description: 请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 *
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 *
 *
 * 提示：
 *
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 */
public class NumbersBetweenTwoDays_5169 {
    public static void main(String[] args) throws ParseException {
        System.out.println(daysBetweenDates("2019-06-15","2018-6-15"));
    }
    public static  int daysBetweenDates(String date1, String date2)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int)(Math.abs(d2.getTime()-d1.getTime())/(60*60*24*1000));
    }
}
