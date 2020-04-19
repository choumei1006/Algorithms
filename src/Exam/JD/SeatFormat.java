package Exam.JD;

import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/18 20:31
 * @Description: 有n位乘客坐一列列车，列车一共会依次经过10^5个节点，从1到10^5编号；
 * 我们已知每一位乘客的上车站点和下车站点，但是不知道这些乘客的订票顺序。
 * 当一位乘客订票时，他会在当前还空余的座位中选择一个他喜欢的位置，但是我们不知道乘客的喜好，
 * 所以他具体选哪个位置我们不知道。
 * 现在你需要计算列车最少需要安排多少座位，可以使得无论乘客的订票顺序是什么样的，所有乘客都有座位可以坐。
 * 例如：有三位乘客：
 * A:1-2
 * B:2-3
 * C:1-3
 * 若订票顺序使A，C，B，那么只需要两个座位就一定能满足，当A订票时，他会选择一个座位，
 * 当C订票时可用座位只剩下一个，他会订这个剩余的座位，当B订票时，可用座位也只有一个，他会订这个座位
 * （即开始A的那个座位）；
 * 当订票顺序是A.B.C，那么有可能会需要三个座位，A订了一个座位，B订了与A不同的座位，
 * 此时C来订票时他只能订第三个座位。
 * 所以对于这组例子，答案是3；
 */
public class SeatFormat {
    @Test
    public void Test(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //人数
        /*Map<Integer,Map<Integer,Integer>> ticketMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });*/
        List<Integer> fromList = new ArrayList<>();
        List<Integer> toList = new ArrayList<>();
        List<Integer> maxDistances = new ArrayList<>();
        int maxDis = 0;



        //循环输入 始发地-目的地
        for(int i = 0; i < n; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            /*String optionStr = sc.nextLine().trim();
            String[] options = optionStr.split("\\s+");

            int from = Integer.parseInt(options[0]);
            int to = Integer.parseInt(options[1]);*/
            fromList.add(from);
            toList.add(to);
            int curDis = to -from;
            if(curDis > maxDis){
                maxDistances.clear();
                maxDistances.add(i);
                maxDis = curDis;
            }else if(to - from == maxDis){
                maxDistances.add(i);
            }
            //ticketMap.put(to-from,new HashMap<>(from,to));
        }
        if(n == 0 || n == 1){
            System.out.println(n);
            return;
        }
        int res = 1;
        for (int i = 0; i < n; i++) {

            int curFrom = fromList.get(i);
            int curTo = toList.get(i);
            for (int j = 0; j < maxDistances.size() && j != i; j++) {
                int maxFrom = fromList.get(j);
                int maxTo = toList.get(j);
                if(curFrom >= maxTo || curTo <= maxFrom){

                }else{
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
