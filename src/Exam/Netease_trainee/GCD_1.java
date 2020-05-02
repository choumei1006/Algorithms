package Exam.Netease_trainee;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/4/7 20:17
 * @Description:
 */
public class GCD_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //n
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();       //a[i]
        }
        if(n < 2) return ;
        int ans = arr[1] - arr[0];
        for (int i = 2; i < n ; i++) {
            ans = gcd(ans,arr[i] - arr[i-1]);
        }
        System.out.println(ans);
    }
    public static int gcd(int x,int y){
        if(x < 0 || y < 0){
            return -1;
        }
        return x == 0 ? y : gcd(y%x,x);
    }
}
