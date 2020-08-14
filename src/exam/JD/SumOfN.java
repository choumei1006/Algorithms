package exam.JD;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/6 20:11
 * @Description:
 */
public class SumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfN(n));
    }

    /**
     * 计算给定数列前 n 项和
     * @param n
     * @return
     */
    public static String sumOfN(int n){
        double tmp = 0;
        for (int i = 1; i <= n; i++) {
            tmp += (1.0 / (5 * (2 * i - 1))) - (1.0 / (5 * (2 * i )));
        }
        System.out.println(tmp);
        return String.format("%.4f", tmp);
    }

}
