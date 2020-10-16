package exam.ShanShan;

import java.util.Scanner;
/**
 * @author:choumei
 * @date:2020/9/21 20:52
 * @Description: 输入一个整数，输出最接近这个整数的ABA型整数
 */
public class ClosestPalindrome {
    public static void main(String[] args) {
        //1、接收输入
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        //2、获取最接近的回文整数
        int rst = calHelper(input);
        System.out.println(rst);
    }

    /**
     * 获取最接近input的回文整数
     * @param input
     * @return
     */
    public static int calHelper(int input){
        //特判
        if(input < 0 || input > 100000000){
            return 0;
        }
        //双指针左右扩散
        int l = input - 1;
        int r = input + 1;
        while(!isPalindrome(l) && !isPalindrome(r)){
            l--;
            r++;
        }
        return isPalindrome(l) ? l : r;
    }

    /**
     * 判断num是否构成回文整数
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
        int   rightNumber = 0;
        while(x > rightNumber){
            rightNumber = rightNumber*10 + (x%10);
            x /=  10;
        }
        return x == rightNumber || x == (rightNumber/10);
    }

}
