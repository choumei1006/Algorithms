package LeetCode.DataStructures.String;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/19 10:58
 * @Description:
 */
public class ReformatNumAndChar_5388 {
    @Test
    public void test(){
        System.out.println(reformat("covid2019"));
    }
    public String reformat(String s) {
        if(null == s || s.length() == 0){
            return null;
        }
        StringBuilder numSb = new StringBuilder();
        StringBuilder charSb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                numSb.append(c);
            }
            if(c >= 'a' && c <= 'z'){
                charSb.append(c);
            }
        }
        int numLen = numSb.toString().length();
        int charLen = charSb.toString().length();
        if(Math.abs(numLen - charLen) > 1){
            return "";
        }else{

            int i = 0, j = 0;
            while(i < numLen && j < charLen){
                res.append(charSb.charAt(j++));
                res.append(numSb.charAt(i++));
            }
            if(i < numLen){
                res.append(numSb.charAt(i));
            }else if(j < charLen){
                res.append(charSb.charAt(j));
            }
        }
        return res.toString();
    }
}
