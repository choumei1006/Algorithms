package exam.Baidu;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/3 20:00
 * @Description:
 */
public class Stairs_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //n
        int m = in.nextInt();  //m

        System.out.println(calCnt(n, m));
    }

    public static int calCnt(int ladder, int maxJump){
        int jump = 0;
        if(ladder == 0){
            return 1;
        }
        if(ladder >= maxJump){
            for (int i = 1; i <= maxJump; i++) {
                jump += calCnt(ladder - i, maxJump);
            }
        }else{
            jump = calCnt(ladder, ladder);
        }
        return jump;
    }
}
