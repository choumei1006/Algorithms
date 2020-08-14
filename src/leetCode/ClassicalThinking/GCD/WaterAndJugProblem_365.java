package leetCode.ClassicalThinking.GCD;

import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/3/21 11:23
 * @Description: 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class WaterAndJugProblem_365 {

    @Test
    public void test(){
        System.out.println(canMeasureWater2(3,5,4));
    }

    /**
     * 水桶问题
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater1(int x, int y, int z){
        if(x + y < z){
            return false;
        }
        if( x == 0 || y == 0 || z == 0 ){
            return z == 0 || x + y == z;
        }
        int gcdVal = gcd1(x,y);
        return z % gcdVal == 0;
    }

    /**
     * 求最大公约数
     * @param x
     * @param y
     * @return
     */
    public static int gcd1(int x, int y){
        if(x < y){
            int temp = x;
            x = y;
            y = temp;
        }
        int r = x % y;
        while(r > 0){
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }
    public static int gcd2(int x, int y){
        return y == 0 ? x : gcd2(y, (x % y));
    }


    private class State{
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if( null == obj || getClass() != obj.getClass()){
                return false;
            }
            State o  = (State)obj;
            return x == o.x && y == o.y;
        }
    }

    //获取下一步所有可能的状态列表
    public List<State> getNextStates(int curX, int curY, int x, int y){
        List<State> states = new ArrayList<>();
        //情况一：没有满才需要注水
        if(curX < x){
            states.add(new State(x,curY));
        }
        if(curY < y){
            states.add(new State(curX,y));
        }
        //情况二：有水才倒出
        if(curX > 0){
            states.add(new State(0,curY));
        }
        if(curY > 0){
            states.add(new State(curX,0));
        }
        //情况三：倒不满才倒
        if(curX + curY < y){
            states.add(new State(0,curX + curY));
        }
        if(curX + curY < x){
            states.add(new State(curX + curY,0));
        }
        //情况四：倒换有剩余才倒
        if(curX + curY > y){
            states.add(new State(x - (y - curY),y));
        }
        if(curX + curY > x){
            states.add(new State(x,y - (x - curX)));
        }
        return states;
    }
    public  boolean canMeasureWater2(int x, int y, int z){
        if(x + y < z){
            return false;
        }
        if(x == 0 || y == 0 || z == 0){
            return z == 0 || x + y == z;
        }
        State initState = new State(0,0);

        //访问队列
        Queue<State> queue = new LinkedList<>();
        //已访问集合
        Set<State> visited  = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while(!queue.isEmpty()){
            State curState = queue.poll();
            int curX = curState.getX();
            int curY = curState.getY();

            if(curX == z || curY == z || curX + curY == z){
                return true;
            }

            List<State> nextStates = getNextStates(curX,curY,x,y);

            for(State tempState : nextStates){
                if(!visited.contains(tempState)){
                    queue.offer(tempState);
                    visited.add(tempState);
                }
            }
        }
        return false;
    }


    /**
     * 有向有环图的BFS
     * @param x
     * @param y
     * @param z
     * @return
     */
    /*public boolean canMeasureWater2(int x, int y, int z) {
        // 特判
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        State initState = new State(0, 0);

        // 广度优先遍历使用队列
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            // curX + curY == z 比较容易忽略
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }

            // 从当前状态获得所有可能的下一步的状态
            List<State> nextStates = getNextStates(curX, curY, x, y);

            // 打开以便于观察，调试代码
            // System.out.println(head + " => " + nextStates);

            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.offer(nextState);
                    // 添加到队列以后，必须马上设置为已经访问，否则会出现死循环
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
        List<State> nextStates = new ArrayList<>(8);

        // 以下两个状态，对应操作 1
        // 外部加水，使得 A 满
        State nextState1 = new State(x, curY);
        // 外部加水，使得 B 满
        State nextState2 = new State(curX, y);

        // 以下两个状态，对应操作 2
        // 把 A 清空
        State nextState3 = new State(0, curY);
        // 把 B 清空
        State nextState4 = new State(curX, 0);

        // 以下四个状态，对应操作 3
        // 从 A 到 B，使得 B 满，A 还有剩
        State nextState5 = new State(curX - (y - curY), y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        State nextState6 = new State(0, curX + curY);

        // 从 B 到 A，使得 A 满，B 还有剩余
        State nextState7 = new State(x, curY - (x - curX));
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        State nextState8 = new State(curX + curY, 0);

        // 没有满的时候，才需要加水
        if (curX < x) {
            nextStates.add(nextState1);
        }
        if (curY < y) {
            nextStates.add(nextState2);
        }

        // 有水的时候，才需要倒掉
        if (curX > 0) {
            nextStates.add(nextState3);
        }
        if (curY > 0) {
            nextStates.add(nextState4);
        }

        // 有剩余才倒
        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        // 倒过去倒不满才倒
        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }

    private class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }*/



}
