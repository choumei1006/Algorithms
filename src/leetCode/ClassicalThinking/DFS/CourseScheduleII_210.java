package leetCode.ClassicalThinking.DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/5/17 10:11
 * @Description: 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 */
public class CourseScheduleII_210 {
    @Test
    public void test(){
        System.out.println(Arrays.toString(findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }

    /**
     * 预设条件
     */
    List<List<Integer>> edges;   //邻接矩阵发表示 边
    int[] res;    //一维数组存放拓扑排序结果
    boolean isCircle;    //是否存在环
    int[] visited;     //是否被访问过
    int index;     //结果集索引



    /**
     * 图的拓扑排序
     * @param numCourses
     * @param prerequisities
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisities){
        edges = new ArrayList<>(numCourses);    //邻接矩阵的行
        for (int i = 0; i < numCourses; i++) {
            edges.add( new ArrayList<>());   //邻接矩阵的列
        }

        res = new int[numCourses];   //初始化结果集

        isCircle = false;  //是否存在环

        visited = new int[numCourses];
        index = numCourses - 1;   //结果集索引（有后往前存放）

        //将图的边加入邻接矩阵
        for(int[] req : prerequisities){
            edges.get(req[1]).add(req[0]);  //必要条件在前
        }

        for (int i = 0; i < edges.size(); i++) {
            //若未被访问过，则深度优先遍历
            if(visited[1] == 0){
                dfs(i);
            }
        }

        if(isCircle){
            return new int[0];
        }
        return res;
    }

    /**
     * 深度优先遍历
     * @param v
     */
    public void dfs(int v){
        visited[v] = 1;
        for(int n : edges.get(v)){
            if(visited[n] == 0){
                dfs(n);
                if(isCircle){
                    break;
                }
            }else if(visited[n] == 1){
                isCircle = true;
            }
        }
        visited[v] = 2;
        res[index--] = v;
    }
}
