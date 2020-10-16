package exam.ShanShan;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/29 20:46
 * @Description: 输入整数a，求其阶乘结果可以被10的N次方整除时，N的最大值
 */
public class Factorial_10 {
    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //计算能被10的N次方整除的最大的N
        int rst = maxPowN(num);
        System.out.println(rst);
    }

    /**
     * 辅助类
     * @param a
     * @return
     */
    public static int maxPowN(int a){

        int two_cnt = 0;
        int five_cnt = 0;

        for(int i = a; i > 1; i--){
            int tmp = i;
            while(tmp % 5 == 0){
                tmp = tmp / 5;
                five_cnt++;
            }
            while(tmp % 2 == 0){
                tmp = tmp / 2;
                two_cnt++;
            }
        }
        return Math.min(five_cnt, two_cnt);
    }
}
