package exam.DaHua.MengMeng;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/9/12 16:19
 * @Description:
 */
public class Banana_31 {
    public static void main(String[] args) {
        functionN(2);
        System.out.println( 5 * initCnt + 1);
    }

    private static int initCnt = 1;

    /**
     * 返回
     * @param people
     * @return
     */
    public static void functionN(int people){
        if(people == 1){
            return;
        }
        initCnt = (5 * initCnt + 1) / 4;
        functionN(people - 1);
    }

    /*@Test
    public void test(){
        T(T(5));
        System.out.println(cnt);
    }
    int cnt = 0;

    int T(int m){
        int a[30] = {};
        cnt++;
        if(m <= 3){
            return 1;
        }else return T(m - 2) + T(m - 4) + 1;
    }*/
}
