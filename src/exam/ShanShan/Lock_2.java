package exam.ShanShan;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/10 17:32
 * @Description:  【火星探险队】
 * “探险猫”火星探险队在火星探险过程中误入了一个岩洞，出不来了。
 * 危急时刻小队找到了一扇门，门上有N个钥匙孔，旁边有N把钥匙。
 * 只有钥匙孔的形状跟门孔相同才可以开门
 * 门旁边对应要是每一列都有一个开关，可以改变对应列的形状
 * 0变1， 1变0
 * 比如有3个孔，每个孔由2位变时
 *      孔       钥匙
 *      01        11
 *      11        00
 *      10        10
 *  孔第二列位 1  1  0，
 *  拨动第二列的开关就变成了0 0 1
 *  钥匙孔的相对位置是不变的，要是可以随便插（只要插的进去）
 *  上面的孔是无法插上3把要是的，
 *  00
 *  10
 *  11
 *  这样三把要是就可以同时插进去，门就可以打开
 *  拨动石头开关也是很累的事情
 *  但是探险小队太累了，请你帮忙找一下最小的操作数
 *  可以把钥匙孔调整到可以打开的状态
 *
 *  输入描述：
 *  第一行
 *  一个整数T代表T组数据
 *  每组测试数据第一行有两个数 N，L，代表N个钥匙孔，每个孔用L位表示形状
 *  每组数据第二行表示N个钥匙孔的形状
 *  每组数据第三行表示N个钥匙的形状
 *  1 <= T <= 100
 *  1 <= N <= 150
 *  10 <= L <= 40
 *
 *  输出描述：
 *  如果有可能打开门
 *  输出一个整数代表最小的操作数
 *  如果不可能，打印字符串  NOT POSSIBLE
 *
 *  示例1：
 *  输入：
 *  3
 *  3 2
 *  01 11 10
 *  11 00 10
 *  2 3
 *  101 111
 *  010 001
 *  2 2
 *  01 10
 *  10 01
 *
 *  输出；
 *  1
 *  NOT POSSIBLE
 *  0
 */
public class Lock_2 {
    public static void main(String[] args) {
        //1、接收输入
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //测试数据数目

        //T组数据
        for (int i = 0; i < T; i++) {

        }
        int N = sc.nextInt();   //N：钥匙孔数量
        int L = sc.nextInt();   //N：钥匙孔的位数

    }
}