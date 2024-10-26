package cn.cherzing;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/10/26 0026 21:21
 * @description ClimbStairs
 */
public class ClimbStairs {
    @Test
    public void testClimbStairs() {
        SolutionClimbStairs solutionClimbStairs = new SolutionClimbStairs();
        System.out.println(solutionClimbStairs.climbStairs(35));
    }
}

class SolutionClimbStairs {
    /**
     * 全是1的不用考虑，到最后直接加一
     * 遍历每一个加2，如果多出1，就加1，然后排列
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int isEvenNumber = n % 2;
        int num2 = 0;
        int timeAll = 0;
        // 如果是偶数
        if (isEvenNumber == 0) {
            //计算2的个数
            num2 = n / 2;
        } else { // 如果是奇数
            //计算2的个数
            num2 = (n - 1) / 2;
        }
        // 根据“2”的个数，组合“1”和“2”
        for (int i = 0; i <= num2; i++) { // i是2的个数
            // 剩余“1”的个数
            int numLeave1 = n - 2 * i;
            // 总共的数
            int numAll = numLeave1 + i;
            // 排列
            int time_1 = factorial(numAll) / (factorial(numLeave1) * factorial(i));
            //合计
            timeAll += time_1;
        }

        return timeAll;
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    /**
     * 动态规划解决爬楼梯问题
     *
     * @param n 台阶数
     * @return 不同的爬楼梯方法数
     */
    public int climbStairsDynamicProgramming(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2;
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }
}