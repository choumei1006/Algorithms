package exam.DJI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/8/25 18:12
 * @Description: 比较两个字符串（str1,str2）,如果str1中的字母经过排列组合后，
 * 可以组合城str2,则返回true,否则返回false；
 * 注意：1、当前方法仅考虑小写字母
 * 2、需要考虑方法的执行效率
 * 例如：
 * （‘rkqodlw’，‘world’）   true
 * （‘katas’，‘steak’）   false
 */
public class isContainsString {
    @Test
    public void test(){
        System.out.println(isReformat("katas", "steak"));
    }

    /**
     * 判断str2可否由str1经过排列组合构成
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isReformat(String str1, String str2) {
        //特判
        if (null == str1 || null == str2 || str1.length() < str2.length()) {
            return false;
        }

        List<Character> str1List = new ArrayList<Character>();
        List<Character> str2List = new ArrayList<Character>();

        for (int i = 0; i < str1.length(); i++) {
            str1List.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            str2List.add(str2.charAt(i));
        }

        return str1List.containsAll(str2List);
    }
}
