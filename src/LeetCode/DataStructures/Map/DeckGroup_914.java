package LeetCode.DataStructures.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/3/27 21:13
 * @Description: 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * [1,1,1,1,2,2,2,2,2,2]
 * [0,0,0,0,0,1,1,2,3,4]
 */
public class DeckGroup_914 {
    @Test
    public void test(){
        //System.out.println(hasGroupsSizeX(new int[]{2,2,2,2,2,2,1,1,1,1,3,3}));
        System.out.println(gcd(6,4));
    }
    public boolean hasGroupsSizeX(int[] deck){
        if(null == deck || deck.length < 2){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : deck){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int gcdVal = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(gcdVal == -1){
                gcdVal = entry.getValue();
            }else{
                gcdVal = gcd(gcdVal,entry.getValue());
            }
        }
        return gcdVal >= 2;
    }
    public int gcd(int x, int y){
        return x == 0 ? y : gcd(y % x,x);
    }
}
