package cn.cherzing.chuanzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试数据组数

        while (T-- > 0) {
            int n = scanner.nextInt(); // 读取果子个数
            int q = scanner.nextInt(); // 读取询问次数
            Map<Integer, Integer> fruitCount = new HashMap<>();

            // 读取果子种类并统计每种果子的数量
            for (int i = 0; i < n; i++) {
                int fruit = scanner.nextInt();
                fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);
            }

            // 处理每个询问
            for (int i = 0; i < q; i++) {
                int d = scanner.nextInt(); // 读取询问的天数
                int remainingFruits = n; // 初始剩余果子数为总数

                for (Map.Entry<Integer, Integer> entry : fruitCount.entrySet()) {
                    int count = entry.getValue();
                    if (count <= d) {
                        remainingFruits -= count; // 如果果子数量小于等于天数，全部打下来
                    }
                }

                System.out.print(remainingFruits + " "); // 输出结果
            }
        }
    }
}
