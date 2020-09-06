package exam.JD.Autumn;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/8/27 20:37
 * @Description:
 */
public class BollGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //特判
        if(n < 1){
            return;
        }

        List<List<Integer>> map = new ArrayList<>();

        //第一层
        String firstNumStr = sc.nextLine().trim();
        int firstNode = Integer.parseInt(firstNumStr);
        List<Integer> firstList = new ArrayList<>();
        firstList.add(firstNode);
        map.add(firstList);
        Tree3Node1 root = new Tree3Node1(firstNode);

        for (int i = 1; i < n; i++) {
            String numStr = sc.nextLine().trim();
            String[] numArr = numStr.split("\\s+");
            List<Integer> levelList = new ArrayList<>();
            for (int j = 0; j < map.get(map.size() - 1).size(); j++) {

                int numVal1 = Integer.parseInt(numArr[j]);
                int numVal2 = Integer.parseInt(numArr[j + 1]);
                int numVal3 = Integer.parseInt(numArr[j + 2]);

                levelList.add(numVal1);
                levelList.add(numVal2);
                levelList.add(numVal3);
            }
        }
    }
}


class Tree3Node1 {
    public Integer val;

    public Tree3Node val2;
    public Tree3Node val3;
    public Tree3Node val5;

    public Tree3Node1( Integer x) {
        if (null == x) return;
        this.val = x;
    }
}

