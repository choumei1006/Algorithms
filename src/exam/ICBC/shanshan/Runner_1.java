package exam.ICBC.shanshan;

/**
 * @author:choumei
 * @date:2020/9/6 15:14
 * @Description:
 */
public class Runner_1 {
    public static void main(String[] args) {
        double sumPath = calPath(5, 1000);
        System.out.println(sumPath);
    }

    /**
     * 计算 n个人，起始前进1000m，共计路程
     * @param n
     * @param k
     * @return
     */
    public static double calPath(int n, int k){
        double rst = 0.0;
        for (int i = 0; i < n; i++) {
            Double tmpLen =  (k * Math.pow(0.5, i) * 1.5);
            rst += tmpLen;
        }
        return rst;
    }
}
