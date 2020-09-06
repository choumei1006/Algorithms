package exam.Ali;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/28 19:06
 * @Description:
 */
public class Exchange01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    //n

        sc.nextLine();

        String str1 = sc.nextLine().trim();
        String str2 = sc.nextLine().trim();

        System.out.println(helper(str1, str2));
    }

    /**
     * 辅助类
     * @param str1
     * @param str2
     * @return
     */
    public static int helper(String str1, String str2){
        int len1 = str1.length();
        int len2 = str1.length();

        int[][] arr = new int[len1][len2];

        //边界
        for (int i = 0; i < len1; i++) {
            arr[i][0] = i;
        }
        for (int j = 0; j < len2; j++) {
            arr[0][j] = j;
        }

        for (int i = 1;  i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int a = str1.charAt(i) == str2.charAt(j) ? 0 : 1;
                int d = arr[i - 1][j]++;
                int in = arr[i][j - 1]++;
                int sub = arr[i - 1][j - 1] + a;
                arr[i][j] = minNum(d, in, sub);
            }
        }
        System.out.println(arr[len1 - 1][len2 - 1]);
        return 0;
    }

    public static int minNum(int a, int b, int c){
        int min = a > b ? b : a;
        return min > c ? c : min;
    }


}
