package GotoOffer.Array;

import java.util.HashMap;

/**
 * @author:choumei
 * @date:2020/2/20 18:47
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNumber {
    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }
    public static  int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rst = 0;
        for (int i = 0; i < array.length; i++) {
            int tempNum = map.getOrDefault(array[i],0);
            map.put(array[i],tempNum+1);
            if(tempNum+1 > array.length/2){
                rst = array[i];
                break;
            }
        }
        return rst;
    }
}
