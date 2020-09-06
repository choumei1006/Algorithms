package exam.Bilibili.Autumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/9/4 20:24
 * @Description:
 */
public class CharChip_3 {
    public static void main(String[] args) {
        System.out.println(getChipAvgCnt("aaabbaaac"));
    }

    /**
     * 计算组成字符串的碎片平均长度
     * @param str
     * @return
     */
    public static int getChipAvgCnt(String str){
        //特判
        if(null == str || str.length() == 0){
            return 0;
        }
        //快慢指针遍历字符串
        List<Integer> cntArr = new ArrayList<>();
        int sum = 0;
        int left = 0, right = 0;
        while (right < str.length()) {
            if(str.charAt(right) == str.charAt(left)){
                right++;
            }else{
                int tmpCnt = right - left;
                cntArr.add(tmpCnt);
                sum += tmpCnt;

                left = right;
            }
        }

        //处理最后一个字符碎片
        cntArr.add(right - left);
        sum += right - left;

        return sum / cntArr.size();
    }
}
