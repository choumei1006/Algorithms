package LeetCode.DataStructures.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/3/7 23:36
 * @Description:
 */
public class MaxQueue {
    private Queue<Integer> dataQueue;
    private List<Integer> list;

    public MaxQueue() {
        dataQueue = new LinkedList<>();
        list = new ArrayList<>();
    }

    public int max_value() {
        int rst = -1;
        if(list.size() == 0){
            return rst;
        }
        return list.get(0);
    }

    public void push_back(int value) {
        dataQueue.add(value);
        if(list.size() > 0) {
            int temp = list.get(list.size() - 1);
            while (temp < value && list.size() > 0) {
                list.remove(list.size() - 1);
                temp = list.size() > 0 ? list.get(list.size() - 1) : Integer.MAX_VALUE;
            }
        }
        list.add(value);
    }

    public int pop_front() {
        int rst = -1;
        if(list.size() == 0){
            return rst;
        }
        rst = dataQueue.poll();
        if(rst == list.indexOf(0)){
            list.remove(0);
        }
        return rst;
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}
