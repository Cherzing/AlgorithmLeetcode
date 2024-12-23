package cn.cherzing.AlgorithmDesign;

/**
 * @author Cherzing
 * @date 2024/12/20 0020 20:29
 * @description Knapsack01
 */
public class Knapsack01 {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length; // 物品数量

        // dp[i][j]表示在面对前i件物品，且背包容量为j时所能达到的最大价值
        int[][] dp = new int[n + 1][capacity + 1];

        // 初始化dp数组的第一行为0，因为没有物品时的价值为0
        for (int w = 0; w <= capacity; w++) {
            dp[0][w] = 0;
        }

        // 填充dp数组
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // 如果当前物品的重量小于等于背包的剩余容量
                if (weights[i - 1] <= w) {
                    // 选择物品i和不选择物品i的最大值
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // 当前物品重量超过背包剩余容量，不选择该物品
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 返回dp数组的最后一个元素，即背包容量为capacity时的最大价值
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120}; // 物品的价值
        int[] weights = {10, 20, 30};  // 物品的重量
        int capacity = 50;             // 背包的容量

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("The maximum value that can be put in a knapsack of capacity " + capacity + " is " + maxValue);
    }
}
