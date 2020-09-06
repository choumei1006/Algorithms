package exam.GrapeCity_trainee;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/8/15 9:37
 * @Description: 输出一个等腰倒三角
 *
 */
public class VerseTriangle {
    @Test
    public void test(){
        print(5);
    }

    public void print(int n){
        for (int i = n; i >= 1 ; i--) {
            System.out.println();   //每层换行
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");
            }
        }
    }
}
