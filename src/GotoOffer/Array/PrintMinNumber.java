package GotoOffer.Array;

/**
 * @author:choumei
 * @date:2020/2/22 20:41
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
    public static  String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        if(null == numbers || numbers.length == 0){
            return sb.toString();
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int tempSum1 = Integer.parseInt(numbers[i]+""+numbers[j]);
                int tempSum2 = Integer.parseInt(numbers[j]+""+numbers[i]);
                if(tempSum1 > tempSum2){
                    int tempVal = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tempVal;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}
