package cn.cherzing.chuanzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/29 0029 15:52
 * @description Test2
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试数据组数

        for (int t = 0; t < T; t++) {

            int n = scanner.nextInt(); // 读取果子个数
            int q = scanner.nextInt(); // 读取询问次数

            int[] fruits = new int[n];
            Map<Integer, Integer> fruitCount = new HashMap<>();

            // 读取果子种类并统计每种果子的数量
            for (int i = 0; i < n; i++) {
                fruits[i] = scanner.nextInt();
                fruitCount.put(fruits[i], fruitCount.getOrDefault(fruits[i], 0) + 1);
            }

            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = scanner.nextInt(); // 读取询问的天数
            }

            // 处理每个询问
            for (int d : queries) {
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
