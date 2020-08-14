package exam.Meituan_trainee;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/9 19:48
 * @Description: 字符串匹配是一类经典问题。子串在母串中出现的次数称为匹配次数。
 * 例如，子串aa在母串aaaba中出现了两次（子串[1,2][2,3])
 *
 * 现在，有一个字符串多重集合（即集合中可以有相同的元素），以及k个字符串，这k个字符串构成了初始集合。
 *
 * 现在你需要维护这么一个动态匹配问题：
 *
 * 1、集合中删除原本k个字符串中的编号为x的字符串。如果编号为x的字符串不在该集合中，保持原样。
 *
 * 2、集合中加入原本k个字符串中的编号为x的字符串。如果编号为x的字符串在该集合中，保持原样。
 *
 * 3、给出一个母串，询问所有还在集合中的字符串作为子串的匹配次数之和。
 *
 * 输入
 * 输入第一行包括两个整数n,k，描述操作次数和初始字符串的个数。
 *
 * 接下来k行，每行描述一个字符串。
 *
 * 接下来n行，每行一个字符串描述一个操作
 *
 * 如果该字符串第一个字符为'+'，接下来为一个数字x，代表将原本k个字符串中的第x个字符串加入集合
 *
 * 如果该字符串第一个字符为'-'，接下来为一个数字x，代表将原本k个字符串中的第x个字符串删除出集合
 *
 * 如果该字符串第一个字符为'?'，接下来为一个字符串S，代表询问S作为母串，
 * 所有现在在集合中的字符串作为子串的匹配次数之和。
 *
 * 注意，字符串从1开始编号。
 *
 * 输出
 * 对于每一个'?'操作，输出答案。
 *
 *
 * 样例输入
 * 9 3
 * a
 * ba
 * ab
 * ?ababa
 * +1
 * ?ababa
 * -2
 * ?ababa
 * -3
 * ?ababa
 * +2
 * ?ababa
 * 样例输出
 * 7
 * 7
 * 5
 * 3
 * 5
 *
 * 提示
 * 范围
 * 1<=x<=k题目中出现的字符串长度和不超过200000，所有的字符串均由小写字母组成。
 *
 * 样例解释：
 * a在ababa中出现3次
 * ab在ababa中出现2次
 * ba在ababa中出现2次
 * 对于操作1,字符串1,2,3都在集合中，故答案为3+2+2=7
 * 对于操作2,由于字符串1在集合中，故没有影响。
 * 对于操作5,字符串1,3在集合中，故答案为3+2=5
 * 对于操作7,字符串1在集合中，故答案为3
 * 对于操作9,字符串1,2在集合中，故答案为3+2=5
 */
import java.util.*;

public class StringMatch_5 {
    @Test
    public void test(){
        //System.out.println(kmpSearch("ababa","a"));
        //aaa();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();  //n
        //int n = 9;  //n
        //int k = sc.nextInt();  //k
        //int k = 3;  //k
        String optionStr = sc.nextLine().trim();
        String[] options = optionStr.split("\\s+");
        int n = Integer.parseInt(options[0]);
        int k = Integer.parseInt(options[1]);
        List<String> initList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < k; i++){
            String curStr = sc.nextLine();
            initList.add(curStr);
            set.add(curStr);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String actionStr = sc.nextLine();
            char action = actionStr.charAt(0);
            switch (action){
                case '?':
                    res.add(searchMatchTimes(set,actionStr.substring(1)));
                    break;
                case '+':
                    set.add(initList.get(Integer.parseInt(String.valueOf(actionStr.charAt(1)))-1));
                    break;
                case '-':
                    String c = initList.get(Integer.parseInt(String.valueOf(actionStr.charAt(1)))-1);
                    if(set.contains(c)){
                        set.remove(c);
                    }
                    break;
                default:
                    break;
            }
        }
        for(int temp : res){
            System.out.println(temp);
        }
    }
    //?
    public static int  searchMatchTimes(Set<String> set, String str){
        int res = 0;
        for(String s : set){
            res += kmpSearch(str,s);
        }
        return res;
    }



    /**
     * KMP Search
     * @param s
     * @param p
     */
    public static int kmpSearch(String s, String p){
        int res = 0;
        //特判
        if(null == s || null == p ){
            return 0;
        }
        //获取字符数组
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        //获取next数组
        int[] next = buildNext(pArray);

        int i = 0;    //主串指针
        int j = 0;    //模式串指针

        while(i < s.length()){
            if(sArray[i] == pArray[j]){
                i++;
                j++;
            }else if(j != 0){
                j = next[j-1];
            }else{
                i++;
            }

            //判断是否找到目标串
            if(j == p.length()){
                res++;
                //System.out.println("找到子串位置："+(i - j));
                j = next[j-1];
            }
        }
        return res;
    }

    public static int[] buildNext(char[] pattern){
        //初始化结果
        int[] res = new int[pattern.length];

        int i = 1;   //当前所求位置下标
        int now = res[i-1];    //当前位置之前最长公共前后缀长度

        while(i < pattern.length){
            if(pattern[i] == pattern[now]){
                res[i] = ++now;
                i++;
            }else if(now != 0){
                now = res[now-1];
            }else{
                res[i] = now;   //0
                i++;
            }
        }
        return res;
    }

}
