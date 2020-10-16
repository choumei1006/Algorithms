package exam.InterActiveEntertainment37.Autumn;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/2 19:39
 * @Description:
 */
public class Play37 {

    /**
     * 我需要1个N级宝石，则最少需要3个N-1级宝石
     * 需要3个N-1级宝石，则最少需要（3-1）*5/2+3个N-2级宝石，这三个N-1级宝石的其中两个由快捷方式合成，另外一个传统合成
     * 那么我就需要8个N-2级宝石，则他们可以分4批由快捷合成，即需要8*5/2个N-3级宝石也就是20个
     * 那么我们需要20个N-3级宝石，则需要50个N-4级宝石
     * 需要50个N-4级宝石，就需要125个N-5级宝石
     * 需要125个N-5级宝石，就需要通过快捷方式合成其中的124个，剩下的一个由传统方式合成，即需要124*5/2+3=313个N-6级宝石
     * 需要313个M-6级宝石，则需要312*5/2+3=783个N-7级宝石
     * 需要783个N-7级宝石，就需要1958个N-8级宝石，就需要4895个N-9级宝石...
     */
    public static void main(String[] args) {
//        int n = 6;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = n;
        int sum = 1; //需要sum个n级宝石，temp和sum都在变化，要计算需要sum个temp级宝石
        while (temp != 1) {//循环结束意味着着需要sum个1级宝石
            //如果需要奇数个temp级宝石
            if (sum%2 == 1) {
                //则需要3+(sum-1)*5/2个temp-1级宝石
                sum = 3+(sum-1)*5/2;
                temp--;
            }else if (sum%2 == 0) {//如果需要偶数个temp级宝石
                //则需要sum*5/2个temp-1级宝石。这偶数个temp宝石全部由快捷方式合成
                sum = sum*5/2;
                temp--;
            }
        }
        System.out.println(sum);
    }

    /**
     * 对应等级的所需的一级宝石个数
     * @param level
     * @return
     */
    public int getNum(int level){
        if(level == 2){
            return 3;
        }else{
            return (int) (8 * Math.pow(2.5, level - 3));
        }
    }
}
