package exam.QiAnXin.Autumn;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/9/2 16:20
 * @Description:
 */
public class BrokeHouse_2 {
    public static void main(String[] args) {
        System.out.println(house(new int[]{3,2,4}));
    }

    /**
     *
     * @param person int整型一维数组
     * @return int整型
     */
    public static  int house (int[] person) {
        //特判
        if(null == person || person.length == 0){
            return 0;
        }

        int houseCnt = 0;   //房子总数
        int len = person.length;
        int[] person2 = new int[len + 2];
        System.arraycopy(person, 0, person2, 1, len);   //将person数组赋值到person2数组
        person2[0] = Integer.MAX_VALUE;
        person2[len + 1] = Integer.MAX_VALUE;

        int[] houseArr = new int[len + 2];   //存放每户分房数
        Arrays.fill(houseArr, 1);    //每户至少一个房子
        houseArr[0] = Integer.MAX_VALUE;
        houseArr[len + 1] = Integer.MAX_VALUE;

        for (int i = 1; i < len + 1; i++) {
            int minNebIdx = person2[i - 1] < person2[i + 1] ? i - 1 : i + 1;
            if(person2[minNebIdx] < person2[i]){
                houseArr[i] = houseArr[minNebIdx] + 1;
            }
            //houseArr[i] = Math.min(person2[i - 1], person2[i + 1]) < person2[i] ? Math.max(houseArr[i - 1], houseArr[i + 1]) + 1 : houseArr[i];
            houseCnt += houseArr[i];
        }
        return houseCnt;
    }
}
