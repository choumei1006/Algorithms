package exam.Tencent.Autumn;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/6 21:32
 * @Description: 【字符串次数】
 * 小Q给你n个字符串，小Q希望你能统计出出现次数前K多和前K少（出现次数不能为0）的字符串。
 * 注：对字符串字典序的解释：
 *      1、字典序遵循的是逐字符比较的方式，越靠左的字符越会被先比较；
 *      2、逐字符比较过程中，一旦发现某一对被比较的字符之间不相等时，这一对字符的大小关系即为这一对字符串的大小关系；
 *      3、逐字符比较过程中，一旦出现某一个字符串的所有字符都已经经过比较，而另一个字符串还存在未被比较的字符时，
 *      较短的字符串更小。
 *  eg.  "abc" < "abd"
 *  eg.  "abc" < "abcde"
 *
 *  输入描述：
 *  输入的第一行为两个整数 N，K
 *  接下来N行，每行一个字符串
 *  1 <= N <= 10^5, 字符串长度之和 <= 10^5, 1 <= K <= 10^5
 *  保证K合法，字符串中只有数字和英文字母。
 *
 *  输出描述：
 *  输出2*K行，每行有一个字符串和一个该字符串出现的次数。
 *  前面K行输出前K多，你需要按照出现次数由小到大输出，若出现次数相同时字符串字典序较小的优先输出
 *  后面K行输出前K少，你需要按照出现次数由小到大输出，若出现次数相同时字符串字典序较小的优先输出。
 *
 *  示例1：
 *  输入:
 *  4 2
 *  1
 *  2
 *  3
 *  4
 *
 *  输出：
 *  1 1
 *  2 1
 *  1 1
 *  2 1
 *
 */
public class StringTimes_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //n

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            arr.add(in.nextInt());
        }



    }


}

