package cn.cherzing.AlgorithmDesign;


/**
 * @author Cherzing
 * @date 2024/12/18 0018 15:07
 * @description Fibonacci
 */
public class Fibonacci {
    /**
     * 标准递归写法
     * @param n
     * @return
     */
    public static int fibonacciRecursive(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 动态规划：自底向上
     * @param n
     * @return
     */
    public static int fibonacciMemoization(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    private static int[] cache;
    /**
     * 带缓存数组的递归（标准递归写法的优化）:
     * 自顶向下的动态规划方法，它通过一个数组来存储已经计算过的斐波那契数，从而避免重复计算
     * @param n
     * @return
     */
    public static int fibonacciCached(int n){
        // 初始化缓存数组，大小为n+1，所有元素初始值为-1
        if (cache == null) {
            cache = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                cache[i] = -1;
            }
        }
        // 如果缓存中有值，直接返回
        if (cache[n] != -1) {
            return cache[n];
        }
        // 计算斐波那契数并存储到缓存中
        if (n <= 1) {
            cache[n] = n;
        } else {
            cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        }
        // 返回计算结果
        return cache[n];
    }
    /**
     * 迭代
     * @param n
     * @return
     */
    public static int fibonacciIterative(int n){
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        //System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciRecursive(40));
        System.out.println(fibonacciMemoization(40));
        System.out.println(fibonacciCached(40));
        System.out.println(fibonacciIterative(40));
    }
}
