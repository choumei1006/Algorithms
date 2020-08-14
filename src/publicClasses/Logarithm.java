package publicClasses;

/**
 * @author:choumei
 * @date:2020/4/11 13:05
 * @Description: 数学工具类
 */
public class Logarithm {

    /**
     * 换底公式
     * @param value
     * @param base
     * @return
     */
    public static double log(double value, double base){
        return Math.log(value)/Math.log(base);
    }
}
