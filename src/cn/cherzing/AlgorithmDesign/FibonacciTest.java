package cn.cherzing.AlgorithmDesign;

/**
 * @author Cherzing
 * @date 2024/12/19 0019 20:43
 * @description FibonacciTest
 */
public class FibonacciTest {
    public static int fibonacciRecursive(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 动态规划:记忆化数组
     *
     * @param n
     * @return
     */
    public static int fibonacciDPMemory(int n) {
        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1];
    }

    /**
     * 动态规划：空间优化之后
     *
     * @param n
     * @return
     */
    public static int fibonacciDP(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int[] cache;
    public static int fibonacciCached(int n) {
        if (cache == null) {
            cache = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                cache[i] = -1;
            }
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        if (n == 1 || n == 2) {
            cache[n] = 1;
        } else {
            cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciDPMemory(10));
        System.out.println(fibonacciDP(10));
        System.out.println(fibonacciCached(10));
        System.out.println();
    }
}
