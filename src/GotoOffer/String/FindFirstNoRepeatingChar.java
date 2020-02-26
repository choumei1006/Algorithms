package GotoOffer.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/2/26 23:32
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FindFirstNoRepeatingChar {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("googglea"));
    }
    public static  int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++)
            count[str.charAt(i)]++;
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++)
            if(count[str.charAt(i)]==1)
                return i;
        return -1;
    }
}
