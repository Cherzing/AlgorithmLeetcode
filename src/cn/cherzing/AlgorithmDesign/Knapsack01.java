package cn.cherzing.AlgorithmDesign;

import java.util.Arrays;

/**
 * @author Cherzing
 * @date 2024/12/20 0020 20:29
 * @description Knapsack01
 */
public class Knapsack01 {
    /**
     * 01背包问题 暴力解法
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
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

    /**
     * 0-1 背包：暴力搜索
     * @param wgt
     * @param val
     * @param i
     * @param c
     * @return
     */
    public static int knapsackDFS(int[] wgt, int[] val, int i, int c) {
        // 若已选完所有物品或背包无剩余容量，则返回价值 0
        if (i == 0 || c == 0) {
            return 0;
        }
        // 若超过背包容量，则只能选择不放入背包
        if (wgt[i - 1] > c) {
            return knapsackDFS(wgt, val, i - 1, c);
        }
        // 计算不放入和放入物品 i 的最大价值
        int no = knapsackDFS(wgt, val, i - 1, c);
        int yes = knapsackDFS(wgt, val, i - 1, c - wgt[i - 1]) + val[i - 1];
        // 返回两种方案中价值更大的那一个
        return Math.max(no, yes);
    }

    /**
     * 0-1 背包：记忆化搜索
     * @param wgt
     * @param val
     * @param mem
     * @param i
     * @param c
     * @return
     */
    public static int knapsackDFSMem(int[] wgt, int[] val, int[][] mem, int i, int c) {

        // 若已选完所有物品或背包无剩余容量，则返回价值 0
        if (i == 0 || c == 0) {
            return 0;
        }

        // 若已有记录，则直接返回
        if (mem[i][c] != -1) {
            return mem[i][c];
        }

        // 若超过背包容量，则只能选择不放入背包
        if (wgt[i - 1] > c) {
            return knapsackDFSMem(wgt, val, mem, i - 1, c);
        }

        // 计算不放入和放入物品 i 的最大价值
        int no = knapsackDFSMem(wgt, val, mem, i - 1, c);
        int yes = knapsackDFSMem(wgt, val, mem, i - 1, c - wgt[i - 1]) + val[i - 1];

        // 记录并返回两种方案中价值更大的那一个
        mem[i][c] = Math.max(no, yes);
        return mem[i][c];
    }

    /**
     * 0-1 背包：动态规划
     * @param wgt
     * @param val
     * @param cap
     * @return
     */
    public static int knapsackDP(int[] wgt, int[] val, int cap) {
        int n = wgt.length;

        // 初始化 dp 表
        int[][] dp = new int[n + 1][cap + 1];

        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (wgt[i - 1] > c) {
                    // 若超过背包容量，则不选物品 i
                    dp[i][c] = dp[i - 1][c];
                } else {
                    // 不选和选物品 i 这两种方案的较大值
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }
    public static void main(String[] args) {
        int[] values = {60, 100, 120}; // 物品的价值
        int[] weights = {10, 20, 30};  // 物品的重量
        int capacity = 50;             // 背包的容量

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("The maximum value that can be put in a knapsack of capacity " + capacity + " is " + maxValue);
    }
}
