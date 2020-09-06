package exam.Meituan_trainee.Autumn_20200829;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/29 16:56
 * @Description: 【小团的神秘暗号】 AC
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，小团如果需要传输一个字符串S，则他会为这个字符串添加一个头部字符串和一个尾部字符串。头部字符串满足至少包含一个“MT”子序列，且以T结尾。尾部字符串需要满足至少包含一个“MT”子序列，且以M开头。例如AAAMT和MAAAT都是一个合法的头部字符串，而MTAAA就不是合法的头部字符串。很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约束，就是S是满足头尾字符串合法的情况下的最长的字符串。
 *
 * 很显然这样的加密策略是支持解码的，给出你一个加密后的字符串，请你找出中间被加密的字符串S。
 *
 *
 *
 * 输入描述
 * 输入第一行是一个正整数n，表示加密后的字符串总长度。(1<=n<=100000)
 *
 * 输入第二行是一个长度为n的仅由大写字母组成的字符串T。
 *
 * 输出描述
 * 输出仅包含一个字符串S。
 *
 * 样例输入
 * 10
 * MMATSATMMT
 * 样例输出
 * SATM
 */
public class HeadString_1 {
    public static void main(String[] args) {
        //接收数据输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String str  = sc.nextLine().trim();

        if(str.length() < 4){
            System.out.println("");
            return;
        }

        int head = -1;
        int tail = -1;
        //从前往后找头
        boolean ifM = false;
        boolean ifT = false;

        for (int i = 0; i < str.length(); i++) {
            if(ifM && ifT){
                break;
            }
            if(!ifM && str.charAt(i) == 'M'){
                ifM = true;
                continue;
            }
            if(!ifT && str.charAt(i) == 'T'){
                ifT = true;
                head = i + 1;
                break;
            }
        }

        //从前往后找尾
        boolean ifM2 = false;
        boolean ifT2 = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(ifM2 && ifT2){
                break;
            }
            if(!ifT2 && str.charAt(i) == 'T'){
                ifT2 = true;
                continue;

            }
            if(!ifM2 && str.charAt(i) == 'M'){
                ifM2 = true;
                tail = i ;
                break;
            }
        }

        if(head >= tail){
            System.out.println("");
            return;
        }

        System.out.println(str.substring(head, tail));
    }
}
