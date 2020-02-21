package GotoOffer.BackTrack;

/**
 * @author:choumei
 * @date:2020/2/21 22:52
 * @Description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 思路：对于1->n
 * 1、0个位上的1的个数：(n/10)*1 + (n % 10 < 1 ? 0 : (n % 10 >= 2 ? 1 : (n % 10 -1)+1));
 * 2、1十位上的1的个数：(n/100)*10 + (n % 100 < 10 ? 0 : (n % 100) >= 20 ? 10 : (n % 100 - 10)+1);
 * 3、2百位上的1的个数：(n/1000)*100 + (n % 1000 < 100 ? 0 : (n % 1000) >= 200 ? 100 : (n % 1000 - 100)+1);
 */
public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(34));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
         int len = (n+"").length();
         int cnt = 0;
        for (int i = 0; i < len ; i++) {
            int pow_i = (int)Math.pow(10,i);
            int pow_i1 = (int)Math.pow(10,i+1);
            int tempCnt = (n/pow_i1)*pow_i+(n % pow_i1 < pow_i ? 0 : (n % pow_i1) >= 2*pow_i ? pow_i : (n % pow_i1 - pow_i)+1);
            cnt += tempCnt;
        }
        return cnt;

    }
}
