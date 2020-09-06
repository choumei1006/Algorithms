package exam.DJI;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/16 20:42
 * @Description:
 */
public class RemoveKDigital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine().trim();
        int K = sc.nextInt();

        System.out.println(removeKdigits(num, K));
    }

    /**
     * 移除K个字符使得剩下的字符串组成的数字最大
     * @param str
     * @param n
     * @return
     */
    public static String removeKdigits(String str, int n){
        //特判
        if(null == str || str.length() == 0 || n == 0){
            return str;
        }
        if(str.length() <= n || str.length() > 10002){
            return "0";
        }
        StringBuffer sb = new StringBuffer(str);
        while(n > 0){
            int  i = 0;
            while(sb.length() - 1 > i && sb.charAt(i) <= sb.charAt(i + 1)){
                i++;
            }

            sb.delete(i, i + 1);
            n--;
        }

        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.delete(0, 1);
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
