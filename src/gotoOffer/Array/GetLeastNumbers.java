package gotoOffer.Array;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * @author:choumei
 * @date:2020/2/20 18:56
 * @Description: 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},10));
    }
    public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rstList = new ArrayList<>();
        if(k > input.length){
            return rstList;
        }
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            tempList.add(input[i]);
        }
        Collections.sort(tempList);

        for (int i = 0; i < k; i++) {
            rstList.add(tempList.get(i));
        }
        return rstList;
    }
}
