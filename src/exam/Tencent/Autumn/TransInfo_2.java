package exam.Tencent.Autumn;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/6 23:57
 * @Description: 【通知传递】
 * 小 Q管理着一个大团队，大团队中有n个人，m个小团队，已知你每一个小团队里面的人数和每个人的编号
 * （编号范围是0~n-1，一个人可能属于多个小团队，也有人可能一个小团队都不属于。）
 * 现在小Q会下达一个通知给编号为0的人，所有和编号为0的人同属一个小团体的人都会通过编号为0的人知晓这个通知，
 * 知晓通知的人会接着传达通知给自己小团队中的其他人，现在问你以一共有多少个人知晓了通知（包括编号为0的人）。
 *
 * 输入描述：
 * 输入第一行两个数n和m,代表n个人，m个小团队
 * 接下来m行，每一行第一个数先输入一个X，代表这个小团队有x个人，后面跟着x个数，代表这个小团队里面人的编号
 * 1 <= n <= 100000
 * 1 <=m <= 500
 * 1 <= x <= 100
 *
 * 输出描述：
 * 对于每组测试数据，请输出一个答案代表知晓了通知的人数。
 *
 * 示例1
 * 50 5
 * 2 1 2
 * 5 10 11 12 13 14
 * 2 0 1
 * 2 49 2
 * 4 6 7 8 2
 *
 * 输出：
 * 7
 *
 * 说明：
 * 样例解释：知晓了通知的人的编号为0 1 2 6 7 8 49，一共7个人。
 *
 */
public class TransInfo_2 {
    public static void main(String[] args) {
        //接受输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //n
        int m = sc.nextInt();  //m
        Map<Integer, List<Integer>> map1 = new HashMap<>();  //存放<队员编号：所属组号List>
        Map<Integer, List<Integer>> map2 = new HashMap<>();  //存放<组号，队员编号>

        int curGroupIdx = 0;
        for (int i = 0; i < m ; i++) {
            int cnt = sc.nextInt();   //输入当前组人数
            List<Integer> curPeopleList = new ArrayList<>();   //创建当前组队员编号list
            for (int j = 0; j < cnt; j++) {
                int curPeopleIdx = sc.nextInt();  //接收队员编号
                //更新map1中的<编号：所属团体编号>
                if(map1.containsKey(curPeopleIdx)){
                    map1.get(curPeopleIdx).add(curGroupIdx);
                }else{
                    map1.put(curPeopleIdx, new ArrayList<>(Arrays.asList(curGroupIdx)));
                }
                curPeopleList.add(curPeopleIdx);   //构造当前组队员list
            }
            //将当前组<组号：所有队员编号list>存入map2,更新团队编号
            map2.put(curGroupIdx++, curPeopleList);
        }

        Queue<Integer> queue = new LinkedList<>(); //存放获得通知的队员编号
        queue.offer(0);
        Set<Integer> visited = new HashSet<>(Arrays.asList(0));   //已访问队员编号
        int transCnt = getInformCnt(map1, map2, queue, visited);
        System.out.println(transCnt);
    }


    /**
     * 根据已获得通知队员队列、Map1<队员编号：组号list>、Map2<组号：队员编号list>获取获取通知总人数
     *
     * @param map1
     * @param map2
     * @param queue
     * @return
     */
    public static int getInformCnt(Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2, Queue<Integer> queue,Set<Integer> visited) {
        //特判
        if (null == map1 || null == map2 || map1.size() == 0 || map2.size() == 0 || queue.size() == 0) {
            return 0;
        }
        //根据队列已知队员编号，获取所属组号，更新队列
//        int cnt = queue.size();   //已知人数
        while(!queue.isEmpty()){
            int tmpPeople = queue.poll();   //一个队员出队

            //获取该队员所在组号List
            List<Integer> groupList = map1.getOrDefault(tmpPeople, new ArrayList<>());
            //遍历组号List，将该组中的其他成员入队
            for(int g : groupList){
                List<Integer> peopleList = map2.getOrDefault(g, new ArrayList<>());
                for(int p : peopleList){
                    if(!visited.contains(p)){
                        queue.offer(p);
                        visited.add(p);
//                        cnt++;
                    }
                }
            }
        }
        return visited.size();
    }

}
