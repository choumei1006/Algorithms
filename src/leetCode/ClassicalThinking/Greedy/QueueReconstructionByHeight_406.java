package leetCode.ClassicalThinking.Greedy;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/5 9:19
 * @Description: 【根据身高重建队列】
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class QueueReconstructionByHeight_406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //n个人
        sc.nextLine();

        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine().trim();
            String[] inputOpts = input.split("\\s+");   //以空格隔开
            people[i][0] = Integer.parseInt(inputOpts[0]);
            people[i][1] = Integer.parseInt(inputOpts[1]);
        }

        int[][] rst = reconstructQueue(people);
        for (int i = 0; i < rst.length; i++) {
            System.out.println(Arrays.toString(rst[i]));
        }
    }

    /**
     * 贪心算法
     * 思路：先将高个子插入到 list集合的 p[1]位置，再将矮个子插入到 p[1]位置；
     *
     * @param people
     * @return
     */
    public static  int[][] reconstructQueue(int[][] people) {
        //特判
        if (null == people || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        //排序：身高降序，人数升序
        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));

        //将数组存入队列
        List<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

//        rst = queue.toArray(new int[people.length][2]);
        return queue.toArray(new int[people.length][2]);
    }
}
