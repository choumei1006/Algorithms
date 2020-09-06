package exam.Tencent.SpringTrainee;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/26 20:14
 * @Description:  数据结构基础之一 - 队列
 * 队列有5种操作，插入队列、取出队列、删除队首、队列大小、清空队列。
 *
 * 现在让你模拟一个队列的操作，具体格式参考输入；
 *
 * 输入描述：
 *
 * 第一行输入一个整数 T，表示接下来有 T 测试数据。
 * 对于每组测试数据：
 * 第一行输入一个整数 Q，表示有 Q 次操作。
 * 接下来Q行，每行输入一种队列操作方式，具体格式如下：
 *
 * 初始状态下队列为空。
 *
 * 插入队列： PUSH X
 * 取出队首：TOP //仅仅是看一下队首元素，不要把队首元素删除
 * 删除队首：POP
 * 队列大小：SIZE
 * 清空队列：CLEAR
 *
 * 1 <= T <= 100
 * 1 <= Q,x <= 1000
 *
 * 保证操作作为以上5种的任意一种。
 *
 * 输出描述：
 * 对于每组测试数据：
 * 如果操作为“取出队首”，输出队首元素，如果无法取出，输出-1；
 * 如果操作为“删除队首”，如果无法删除，输出-1；
 * 如果操作为“队列大小”，输出队列大小；
 * 其他操作无需输出；
 *
 * 示例1
 *
 * 输入
 * 2
 * 7
 * PUSH 1
 * PUSH 2
 * TOP
 * POP
 * TOP
 * POP
 * POP
 * 5
 * PUSH 1
 * PUSH 2
 * SIZE
 * POP
 * SIZE
 *
 * 输出
 * 1
 * 2
 * -1
 * 2
 * 1
 *
 */
public class QueueTest_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //T
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int Q = sc.nextInt();
            sc.nextLine();
            //Q次对队列的操作
            for (int j = 0; j < Q; j++) {
                String optMsg = sc.nextLine();
                String[] msgs = optMsg.split("\\s+");
                String option = msgs[0];
                int num = 0;
                if(msgs.length > 1 && option.equals("PUSH")){
                    num = Integer.valueOf(msgs[1]);
                }

                switch (option){
                    case "PUSH":
                        queue.add(num);
                        break;
                    case "TOP":
                        if(!queue.isEmpty()){
                            res.add(queue.peek());
                        }else{
                            res.add(-1);
                        }
                        break;
                    case "POP":
                        if(!queue.isEmpty()){
                            queue.poll();
                        }else{
                            res.add(-1);
                        }
                        break;
                    case "SIZE":
                        res.add(queue.size());
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                    default:
                        break;
                }
            }

        }
        for(int r : res){
            System.out.println(r);
        }
    }
}
