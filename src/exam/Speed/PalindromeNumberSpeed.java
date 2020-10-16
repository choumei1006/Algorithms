package exam.Speed;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/29 21:03
 * @Description:    一辆车以固定速度行驶，司机在上午10点看到里程表上的读数是一个对称数
 * （即这个数从左向右和从右往左的读数是完全一样的）
 *    ，为95859，两个小时后里程表上出现了一个新的对称数，该数仍为5位数。
 *    问该车的速度为多少？新的对称数为多少？
 *
 *    算法分析：该算法为对称数的判定类问题，有多种解决方式，将每一位数都存在数组中，然后再前后比较。
 */
public class PalindromeNumberSpeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mileage = sc.nextInt();                                             //初始车速
        boolean flag = true ;                                               //while循环条件
        int mileage2 = mileage ;
        while(flag){
            mileage2++ ;
            if(isPalindrome(mileage2)){
                flag = false;   //遇到下一个回文数字
                System.out.println(Math.round((mileage2-mileage)/2));     //四舍五入输出
            }
        }
    }


    /**
     * 判断一个数字是否是回文数字
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){
        if(x == 0){
            return true;
        }
        if(x < 0 || x % 10 == 0){
            return false;
        }
        int right = 0;
        while(x > right){
            right = right*10 + (x % 10);
            x /= 10;
        }
        return x == right || x == (right/10);
    }
}
