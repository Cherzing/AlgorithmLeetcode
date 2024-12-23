package cn.cherzing.chuanzhi;

import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/29 0029 16:24
 * @description Test3
 */
public class Test3 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt(); // 测试用例数量

    for (int t = 0; t < T; t++) {
        int n = scanner.nextInt(); // 果子数量
        int q = scanner.nextInt(); // 询问次数

        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = scanner.nextInt(); // 果子种类
        }

        int[] days = new int[q];
        for (int i = 0; i < q; i++) {
            days[i] = scanner.nextInt(); // 询问天数
        }

        for (int d : days) {
            int remainingFruits = simulateDays(fruits, d);
            System.out.print(remainingFruits + " ");
        }
    }

}

    private static int simulateDays(int[] fruits, int day) {
        int[] count = new int[fruits.length];
        for (int fruit : fruits) {
            count[fruit]++;
        }

        for (int i = 1; i <= day; i++) {
            if (count[i] == i) {
                for (int j = 0; j < fruits.length; j++) {
                    if (fruits[j] == i) {
                        fruits[j] = 0;
                    }
                }
            }
        }

        int remaining = 0;
        for (int fruit : fruits) {
            if (fruit != 0) {
                remaining++;
            }
        }

        return remaining;
    }
}
