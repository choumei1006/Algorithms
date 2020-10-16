package exam.DaHua.MengMeng;

/**
 * @author:choumei
 * @date:2020/9/12 16:22
 * @Description:
 */
public class ReverseNumber_2 {
    public static void main(String[] args) {
        System.out.println(reverseNumber(100));
    }
    /**
     * 反转数字
     * @param number
     * @return
     */
    public static int reverseNumber(int number){
        if(number == 0){
            return 0;
        }
        int len = (number + "").length();
        int grade = (int) Math.pow(10, len - 1);
        return reverseNumber(number % grade) * 10 +(number / grade);
    }
}
