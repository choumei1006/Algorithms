package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/6 22:03
 * @Description: 将字符串向右循环移动 k 位。
 *
 *   将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 *
 *   s = "abcd123" k = 3
 *   Return "123abcd"
 */
public class StringCyclicShift {
    public static void main(String[] args) {
        String str = "abcd123";
        long time1 = System.currentTimeMillis();
        long mem1 = Runtime.getRuntime().freeMemory();
        System.out.println(cyclicShift(str,3));
        long time2 = System.currentTimeMillis();
        long mem2 = Runtime.getRuntime().freeMemory();
        System.out.println("系统占用时间："+(time2-time1));
        System.out.println("系统占用内存："+(mem1-mem2));


    }

    /**
     * 方法一：直接截取后k位拼接到字符串开头
     * @param str
     * @param k
     * @return
     */
    public static String cyclicShift(String str,int k){
        int len = str.length();
        return str.substring(len-k)+str.substring(0,len-k);
    }


}
