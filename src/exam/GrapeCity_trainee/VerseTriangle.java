package exam.GrapeCity_trainee;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/8/15 9:37
 * @Description: ���һ������������
 *
 */
public class VerseTriangle {
    @Test
    public void test(){
        print(5);
    }

    public void print(int n){
        for (int i = n; i >= 1 ; i--) {
            System.out.println();   //ÿ�㻻��
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");
            }
        }
    }
}
