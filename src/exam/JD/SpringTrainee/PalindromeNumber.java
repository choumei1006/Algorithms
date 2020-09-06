package exam.JD.SpringTrainee;


import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/6 19:40
 * @Description:
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int cnt = 0;
        //循环，判断每一个数删除一位是不是回文素数
        for (int i = N; i <= M; i++) {
            if(isPalindromeNumber(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    /**
     * 判断一个数删除一位之后是否是回文素数
     *
     * @param num
     * @return
     */
    public static boolean isPalindromeNumber(int num) {
        //1位数
        if (num < 10) {
            return false;
        }
        //2+位数
        boolean flag = false;
        String numStr = String.valueOf(num);
        int len = numStr.length();
        for (int i = 0; i < len; i++) {
            //删除一位
            int tmpNum = Integer.parseInt(numStr.substring(0, i) + numStr.substring(i + 1, len));
            if(isPrime(tmpNum) && isPalindrome(tmpNum)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断一个数是否是素数
     * @param v
     * @return
     */
    public static boolean isPrime(int v) {
        if(v<=3) {
            return v>1;
        }
        for(int i = 2;i < v;i++) {
            if(v % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个整数是否是回文数
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
            right = right * 10 + (x % 10);
            x /= 10;
        }
        return x == right || x == (right / 10);
    }
}
