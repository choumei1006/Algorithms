package exam.Mi.Autumn;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/8 19:06
 * @Description:
 * 单词搜索
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,同一个单元格内的字母不允许被重复使用。
 *
 *二维网格为：
 *
 * [
 *
 *   ['A','B','C','E'],
 *
 *   ['S','F','C','a'],
 *
 *   ['A','D','E','S']
 *
 * ]
 *
 * 输入描述
 * 需要查询的单词
 *
 * 输出描述
 * true 代表单词存在，false表示不存在
 *
 *
 * 样例输入
 * SEE
 * 样例输出
 * true
 */
public class SearchWord_2 {
    public static void main(String[] args) {
        //初始化网格
        char[][] grid = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        //接受输入
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(isFound(grid, word));
    }

    /**
     * 在网格中查找单词
     * @param grid
     * @param word
     * @return
     */
    public static boolean isFound(char[][] grid, String word){
        //特判
        if(null == grid || grid.length == 0 || grid[0].length == 0 || null == word
                || word.length() == 0){
            return false;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == word.charAt(0)){
                    if(DFS(grid, word, i, j, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 深度遍历搜索
     *
     * @param grid
     * @param word
     * @param i
     * @param j
     * @param index
     * @return
     */
    public static boolean DFS(char[][] grid, String word, int i, int j, int index) {
        //边界判断
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                index >= word.length() || grid[i][j] != word.charAt(index - 1)) {
            return false;
        }
        if(index == word.length() - 1 && grid[i][j] == word.charAt(index)){
            return true;
        }
        return DFS(grid, word, i - 1, j, index + 1)
                || DFS(grid, word, i + 1, j, index + 1)
                || DFS(grid, word, i , j - 1, index + 1)
                || DFS(grid, word, i , j + 1, index + 1);
    }
}
