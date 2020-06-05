package GotoOffer.Array;

/**
 * @author:choumei
 * @date:2020/2/22 21:15
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 质因子：能整除正整数的质数
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
    public static  int GetUglyNumber_Solution(int index) {
        if(index < 7){
            return index;
        }
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int idx2 = 0,idx3 = 0,idx5 = 0;
        for (int i = 1; i < index ; ++i) {
            uglyArr[i] = Math.min(uglyArr[idx2]*2,Math.min(uglyArr[idx3]*3,uglyArr[idx5]*5));
            if(uglyArr[i] == uglyArr[idx2]*2) idx2++;
            if(uglyArr[i] == uglyArr[idx3]*3) idx3++;
            if(uglyArr[i] == uglyArr[idx5]*5) idx5++;
        }
        return uglyArr[index-1];
    }
}
