package cn.cherzing.test;

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
        System.out.println(solutionClimbStairs.climbStairs(35)); // 应该输出14930352
    }
    @Test
    public void climbStirs(){
        SolutionClimbStairs solutionClimbStairs = new SolutionClimbStairs();
        System.out.println(solutionClimbStairs.climbStirs(35));
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
            long time_1 = permutation(numAll, numLeave1);
            //合计
            timeAll += time_1;
        }

        return timeAll;
    }

    public long permutation(int n, int r) {
        long result = 1;
        for (int i = n; i > n - r; i--) {
            result *= i;
        }
        return result;
    }
    public int climbStirs(int n){
        int step1 = 1;
        int step2 = 2;
        int total = 0;
        for (int i = 3;i <= n;i++){
            total = step1 + step2;
            step1 = step2;
            step2 = total;
        }
        return total;
    }
}